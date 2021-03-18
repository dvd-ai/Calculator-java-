package application.calculator;

public class Main {

    public static void main(String[] args) {
        try {
            Calculator myCalculator = new Calculator();
        }
        catch (Exception ex) {
            System.err.println("Something went wrong in main method");
            System.exit(1);
        }
    }
}
