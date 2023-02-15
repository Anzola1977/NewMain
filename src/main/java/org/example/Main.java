package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";

        String username = "postgres";
        String sql = "SELECT * FROM test";
        String password = "ZAPlmk2014";
        String conok = "Соединение с бд установлено";
//        String conerr = "Произошла ошибка подключения к бд";

        Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println(String.format("%s", conok));

        Statement statement = connection.createStatement();
            boolean isExecuted = statement.execute(sql);
            if (isExecuted) {
                System.out.println("Select executed");
            }
            statement.close();
            connection.close();
    }
}