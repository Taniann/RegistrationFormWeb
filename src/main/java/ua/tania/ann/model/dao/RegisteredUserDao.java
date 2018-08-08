package ua.tania.ann.model.dao;

import ua.tania.ann.model.entity.RegisteredUser;
import ua.tania.ann.util.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Таня on 08.08.2018.
 */
public class RegisteredUserDao {
    private Connection jdbcConnection;

    protected void connectToDatabase() throws SQLException, ClassNotFoundException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = MySqlConnection.getMySQLConnection();
        }
    }

    protected void disconnectFromDatabase() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertRegisteredUser(RegisteredUser registeredUser) {
        boolean rowInserted = false;

        String sql = "INSERT INTO registered_user (email, phone_number, " +
                "login, password) VALUES (?, ?, ?, ?)";
        try {
            connectToDatabase();


        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, registeredUser.getEmail());
        statement.setString(2, registeredUser.getPhoneNumber());
        statement.setString(3, registeredUser.getLogin());
        statement.setString(4, registeredUser.getPassword());

            rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnectFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }


}
