package mySqlLoginProcessPractise;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world!!");
        LoginMySql loginMySql = new LoginMySql();
        boolean result = loginMySql.login("id1", "password1");
        if(result) {
            System.out.println("login success");
        } else {
            System.out.println("login fail");
        }
    }
}
