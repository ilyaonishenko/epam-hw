package DAO.H2;

import DAO.GunDAO;
import DAO.common.ConnectionPool;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import models.Gun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by wopqw on 25.10.16.
 */
@AllArgsConstructor
public class H2GunDAO implements GunDAO {

    ConnectionPool connectionPool;

    @Override
    @SneakyThrows
    public Collection<Gun> getAll() {

        Collection<Gun> guns = new HashSet<>();

        try(Connection connection = connectionPool.getConnection()){

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Gun");

            Gun.GunBuilder gunBuilder = Gun.builder();

            while(rs.next()){

                guns.add(gunBuilder.id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .caliber(rs.getDouble("caliber"))
                        .price(rs.getDouble("price"))
                        .build());
            }

            return guns;
        }
    }

    @Override
    @SneakyThrows
    public void update(Gun gun) {

        try(Connection connection = connectionPool.getConnection()){

            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE Gun SET name = ?, caliber = ?, price = ? WHERE id = ?");

            preparedStatement.setString(1, gun.getName());
            preparedStatement.setDouble(2, gun.getCaliber());
            preparedStatement.setDouble(3, gun.getPrice());
            preparedStatement.setLong(4, gun.getId());

            preparedStatement.execute();
        }
    }
}
