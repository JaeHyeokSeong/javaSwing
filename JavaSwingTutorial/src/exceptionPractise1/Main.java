package exceptionPractise1;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Calculator.divide(10,0)); // Arithmetic Exception
        } catch (ArithmeticException e) {
            System.out.println("[warning] 0으로 나눌 수 없습니다.");
        }

    }
}
