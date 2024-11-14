package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoJDBCImpl implements UserDao {
    private PreparedStatement statement;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS User (" +
                "id BIGINT NOT NULL," +
                "name VARCHAR(50) NOT NULL," +
                "lastName VARCHAR(50) NOT NULL," +
                "age INT NOT NULL)";
        try {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String drop = "DROP TABLE IF EXISTS User";
        try {
            statement.executeUpdate(drop);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        List<User> user = new LinkedList<>();
        return user;
    }

    public void cleanUsersTable() {

    }
}
