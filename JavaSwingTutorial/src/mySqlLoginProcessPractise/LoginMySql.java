package mySqlLoginProcessPractise;

import java.sql.*;

// [1] localhost mysql 연결방법 : https://www.javatpoint.com/example-to-connect-to-the-mysql-database
public class LoginMySql {
    private final String database = "test_db", table = "login_table";
    private final String url = "jdbc:mysql://localhost:3306/" + database;
    private final String userName = "root";
    private final String password = "비밀번호";

    public LoginMySql() {
        getConnection();
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("[success] url: " + url + " 연결에 성공하였습니다.");
        } catch (SQLException e) {
            System.out.println("[warning] url: " + url + " 연결에 실패하였습니다.");
        }
        return connection;
    }
    public ResultSet loginSelectQuery(String id, String password) {
        String query = "SELECT * FROM " + table + " WHERE user_id='" + id + "' AND user_password='"
                + password + "'";
        ResultSet resultSet = null;

        try {
            resultSet = getConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("[warning] login SELECT QUERY 에서 문제가 발생하였습니다.");
        }
        return resultSet;
    }
    public boolean login(String id, String password) {
        ResultSet resultSet = loginSelectQuery(id, password);
        try {
            while(resultSet.next()) {
                if(id.equals(resultSet.getString("user_id")) && password.equals(resultSet.getString("user_password"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
