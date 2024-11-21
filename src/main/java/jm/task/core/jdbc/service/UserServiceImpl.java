package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Util util = new Util();
//    private Statement statement = (Statement)util.getConnection().createStatement();
    private Connection connection = util.getConnection();
//    private PreparedStatement ps = connection.prepareStatement(str);

    public void createUsersTable() {
        String sql = "create table if not exists user (" +
                "id bigint not null auto_increment primary key," +
                "name varchar(50) not null," +
                "lastName varchar(50) not null," +
                "age int not null)";
        try {
            connection.prepareStatement(sql).executeUpdate();
//            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql = "drop table if exists user";
        try {
            connection.prepareStatement(sql).executeUpdate();
//            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into user (name, lastName, age) values('" + name + "', '"
                + lastName + "', "
                + age + ")";
//        System.out.println(sql);
        try {
            connection.prepareStatement(sql).executeUpdate();
//            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "delete from user where id = '" + id + "'";
        try {
            connection.prepareStatement(sql).executeUpdate();
//            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = "select * from user";
        List<User> userAll = new LinkedList<>();
//        System.out.println("asdfasdf");
        try (ResultSet rs = connection.prepareStatement(sql).executeQuery()) {
            while (rs.next()) {
//                System.out.println(rs.getString(2));
                User user = new User(rs.getString(2),
                        rs.getString(3), rs.getByte(4));
                userAll.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userAll;
    }

    public void cleanUsersTable() {
        String sql = "delete from user";
        try {
            connection.prepareStatement(sql).executeUpdate();
//            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
