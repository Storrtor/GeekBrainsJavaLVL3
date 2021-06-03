//package lesson2;
//
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
//import launcher.Launcher;
//
//import javax.swing.*;
//import java.sql.*;
//
//public class Database {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/project";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    private static final String INSERT_NEW_USER = "INSERT INTO users(login, password, email, name, surname, date, groups, status, session) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
//    private static final String LOGIN = "SELECT * FROM users WHERE login = ? AND password = ?;";
//    private static final String OPEN_SESSION = "UPDATE users set session = 'online' WHERE id = ?;";
//    private static Connection connection;
//
//    private static int id;
//    private static String login;
//    private static String email;
//    private static String name;
//    private static String surname;
//    private static Date date;
//    private static String group;
//    private static String status;
//
//    public static void connectionToData() {
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void register(String login, String password, String email, String name, String surname, Date birthday, String group, String status) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//            preparedStatement.setString(3, email);
//            preparedStatement.setString(4, name);
//            preparedStatement.setString(5, surname);
//            preparedStatement.setDate(6, birthday);
//            preparedStatement.setString(7, group);
//            preparedStatement.setString(8, status);
//            preparedStatement.setString(9, "offline");
//            preparedStatement.execute();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void login(String login, String password) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN);
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            setValues(resultSet);
//            JOptionPane.showMessageDialog(Launcher.getLauncherFrame(), "Welcome");
//            preparedStatement = connection.prepareStatement(OPEN_SESSION);
//            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void setValues(ResultSet resultSet) {
//        try {
//            if (resultSet.next()) {
//                id = resultSet.getInt("id");
//                login = resultSet.getString("login");
//                email = resultSet.getString("email");
//                name = resultSet.getString("name");
//                surname = resultSet.getString("surname");
//                date = resultSet.getDate("date");
//                group = resultSet.getString("groups");
//                status = resultSet.getString("status");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getStatus() {
//        return status;
//    }
//
//    public static String getGroup() {
//        return group;
//    }
//
//    public static Date getDate() {
//        return date;
//    }
//
//    public static String getSurname() {
//        return surname;
//    }
//
//    public static String getName() {
//        return name;
//    }
//
//    public static String getEmail() {
//        return email;
//    }
//
//    public static String getLogin() {
//        return login;
//    }
//
//    public static int getId() {
//        return id;
//    }
//}