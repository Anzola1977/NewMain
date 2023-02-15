package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";

        String username = "postgres";
        String sql = "SELECT * FROM test";
        String password = "ZAPlmk2014";
        String conok = "Соединение с бд установлено";
        String conerr = "Произошла ошибка подключения к бд";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println(String.format("%s", conok));
        } catch (SQLException e) {
            System.out.println(String.format("%s", conerr));
            e.printStackTrace();
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
            boolean isExecuted = statement.execute(sql);
            if (isExecuted) {
                System.out.println("Select executed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("ID");
            System.out.println("||------------||");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
            }
            System.out.println("||------------||");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//        final String URL = "jdbc:postgresql://localhost:5432/postgres";
//
//        String username = "postgres";
//        String sql = "SELECT * FROM test";
//        String password = "000000000";
//        String conok = "Соединение с бд установлено";
//        String conerr = "Произошла ошибка подключения к бд";
//
//        try (Connection connection = DriverManager.getConnection(URL, username, password)) {
//            System.out.println(String.format("%s", conok));
//        } catch (SQLException e) {
//            System.out.println(String.format("%s", conerr));
//            e.printStackTrace();
//        }
//
//        Connection connection = null;
//        try (Statement statement = connection.createStatement()) {
//            boolean isExecuted = statement.execute(sql);
//            if (isExecuted) {
//                System.out.println("Select executed");
//            }
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
