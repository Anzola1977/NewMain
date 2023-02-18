package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "ZAPlmk2014";
        String conok = "Соединение с бд установлено";
        String conerr = "Произошла ошибка подключения к бд";
        int count = 9;
        String SQL = "Select * from Test WHERE id = ?;";

        try {
            Connection connection = DriverManager.getConnection(URL, username, password);
            System.out.println(String.format("%s", conok));
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, count);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("Name"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(String.format("%s", conerr));
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
