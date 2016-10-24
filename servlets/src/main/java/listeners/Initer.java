package listeners;

import DAO.PersonDAO;
import DAO.common.ConnectionPool;
import DAO.h2.H2PersonDAO;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import security.StringEncryptUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by wopqw on 24.10.16.
 */

@Log
@WebListener
public class Initer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        //noinspection Split Declaration
        String path = servletContext.getRealPath("/") + "WEB-INF/classes/";

        ConnectionPool connectionPool = ConnectionPool.create(path + "db.properties");

        connectionPool.initDb(path+"h2.sql");

        reinitDbWithHash(connectionPool);

        PersonDAO personDAO = new H2PersonDAO(connectionPool);

        servletContext.setAttribute("personDAO",personDAO);
    }

    @SneakyThrows
    private void reinitDbWithHash(ConnectionPool connectionPool){


        try(Connection connection = connectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, password FROM Person");
            Statement statement1 = connection.createStatement()){

            while (rs.next()){

                long id = rs.getLong("id");
                String password = rs.getString("password");

                statement1.addBatch("UPDATE Person SET password = '"
                        + StringEncryptUtil.encrypt(password)
                        +"' WHERE id = "+id);
            }
            statement1.executeBatch();
        }
    }
}
