package lesson2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseApp {

    static final String DATABASE_URL = "jdbc:sqlite:javadb.db";
    static Connection connection;
    static Statement statement;

    //сначала всегда выполянется статик блок, до вызова приложения
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DataBaseApp dataBaseApp = new DataBaseApp();
        dataBaseApp.createTable();
        dataBaseApp.insertNewBike("bike1", "no1");
        dataBaseApp.insertNewBikePS("model", "serial");
        dataBaseApp.searchForBike();
        System.out.println(dataBaseApp.searchForBike());
//        dataBaseApp.dropTable();
    }

    public void createTable() throws SQLException {
        String createTable = "create table IF NOT EXISTS bike (" +
                "id integer not null primary key, " +
                "model varchar(30) not null, " +
                "serial_no varchar(10))";
        statement.execute(createTable);
    }

    public void insertNewBike(String name, String serial) throws SQLException {
        String insertSql = "insert into bike (model, serial_no) values ('" + name + "', '" + serial + "')";
        statement.execute(insertSql);
    }

    public void insertNewBikePS(String model, String serial) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into bike (model, serial_no) values (?, ?)");
            for (int i = 0; i < 11; i++) {
                preparedStatement.setString(1, model + " " + i );
                preparedStatement.setString(2, serial + " " + (i + 10) + "\n");
                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Bike> searchForBike() throws SQLException {
        String sql = "select * from bike";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Bike> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new Bike(
                    resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getString(3)));
//            System.out.println(resultSet.getInt("id") + " "
//                    + resultSet.getString("model") + " " +
//                    resultSet.getString(3));
        }
        return list;
    }

    public void dropTable() throws SQLException {
        String dropSql = "drop table bike";
        statement.execute(dropSql);
    }


}
