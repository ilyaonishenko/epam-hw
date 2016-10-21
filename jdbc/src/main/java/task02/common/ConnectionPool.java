package task02.common;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

/**
 * Created by wopqw on 21.10.16.
 */
public class ConnectionPool implements AutoCloseable {

    private static BlockingQueue<Connection> freeConnections;
    private static BlockingQueue<Connection> reservedConnections;
    private volatile boolean isClosing = false;


    @SneakyThrows
    public static ConnectionPool create(String pathToConfig){

        Properties properties = new Properties();
        properties.load(new FileInputStream(pathToConfig));

        int poolSize = Integer.parseInt(getValueAndRemoveKey(properties, "poolSize"));

        freeConnections = new ArrayBlockingQueue<>(poolSize);
        reservedConnections = new ArrayBlockingQueue<>(poolSize);

        BlockingQueue<ConnectionWrapper> connectionQueue = new ArrayBlockingQueue<>(poolSize);

//        for (int i = 0; i < poolSize; i++)
//            connectionQueue.add(
//                    ConnectionWrapper.create(
//                            DriverManager.getConnection(url, properties),
//                            connectionQueue));

        return new ConnectionPool(poolSize, () ->{

            Class.forName(getValueAndRemoveKey(properties, "driver"));
            String url = getValueAndRemoveKey(properties, "url");
            String user = getValueAndRemoveKey(properties,"user");
            String password = getValueAndRemoveKey(properties,"password");
            return DriverManager.getConnection(url, user, password);
        });

    }

    private ConnectionPool(int poolSize, Supplier<Connection> connectionSupplier) {
        freeConnections = new ArrayBlockingQueue<>(poolSize);
        reservedConnections = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            freeConnections.add(connectionSupplier.get());
        }
    }

    @Override
    public void close() throws Exception {

        isClosing = true;

        freeConnections.forEach(connection -> {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static String getValueAndRemoveKey(Properties properties, String key) {
        return (String) properties.remove(key);
    }

    private ConnectionWrapper wrap(Connection connection) {
        return new ConnectionWrapper(connection) {
            @Override
            public void close() throws SQLException {
                if (connection.isClosed()) {
                    throw new SQLException("Connection is already closed");
                }

                if (connection.isReadOnly()) {
                    connection.setReadOnly(false);
                }

                if (reservedConnections.contains(this) && !reservedConnections.remove(this)) {
                    throw new RuntimeException("Cannot close reserved connection");
                }

                if (isClosing) {
                    connection.close();
                } else if (!freeConnections.offer(connection)) {
                    throw new RuntimeException("Cannot return connection to the pool");
                }
            }
        };
    }

    public Connection getConnection() {
        if (isClosing) {
            throw new RuntimeException("Cannot get connection from the closing pool");
        }

        try {
            Connection connection = wrap(freeConnections.take());
            reservedConnections.add(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
