package mySqlPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        createTable();
        createCustomer("Bro", "010-1234-0000", "Male", "1", "no notes");
        ArrayList<String> customersData = getCustomer();
        for(String customerData : customersData) {
            System.out.println(customerData);
        }
    }
    public static Connection getConnection() {
        // reference
        // https://www.youtube.com/watch?v=W9SBHZf3aG4&list=PLHGvDasahwZPXuHYGhdMhU6Csjz1CjOi9&index=16
        // 비밀번호 : 연결해주세요
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12601459";
            String user = "sql12601459";
            String password = "LK5kfPrJEg";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("sql 연결이 되었습니다.");
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            System.out.println("sql 연결에 문제가 발생하였습니다.");
        }
        return connection;
    }

    public static void createTable() {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement createTable = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                    "Customer(id int NOT NULL AUTO_INCREMENT," +
                    "name varChar(255)," +
                    "phone varChar(255)," +
                    "gender varChar(255)," +
                    "age varChar(255)," +
                    "note varChar(255)," +
                    "PRIMARY KEY(id))");

            createTable.execute();
            System.out.println("mysql 에 table 만들기에 성공하였습니다.");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("mysql 에 table 만들기에 실패하였습니다");
        }
    }
    public static void createCustomer(String name, String phoneNumber, String gender, String age, String note) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT INTO Customer" +
                    "(name, phone, gender, age, note) VALUE " +
                    "('" + name + "','" + phoneNumber + "','" + gender + "','" + age + "','" + note + "')");
            insert.executeUpdate();
            System.out.println("Customer database 에 내용이 추가 되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Customer database 에서 에러가 발생하였습니다.");
        }
    }
    public static ArrayList<String> getCustomer() {
        ArrayList<String> customerData = null;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("Select name, phone, gender FROM Customer");
            ResultSet resultSet = statement.executeQuery();
            customerData = new ArrayList<String>();
            while(resultSet.next()) {
                customerData.add("name: " + resultSet.getString("name") +
                        ", phone: " + resultSet.getString("phone") +
                        ", gender: " + resultSet.getString("gender"));
            }
            System.out.println("Customer database 에서 값을 불러오는데 있어서 성공하였습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Customer database 에서 값을 불러오는데 있어서 실패하였습니다.");
        }
        return customerData;
    }

}
