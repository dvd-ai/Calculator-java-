package application.calculator;

import application.calculator.getting_input.getting_input;
import application.calculator.input_check.input_check;
import application.calculator.calculation.calculation;

public class Calculator {

    public input_check in_check;
    public getting_input in;
    public String in_str;
    public calculation calc;

    Calculator () {
        try {
            in = new getting_input();
            in_str = in.read_keyboard_data();
            in_check = new input_check(in_str);
            calc = new calculation(in_str);
        }
        catch (Exception ex) {
            System.err.println("In application.calculator.Calculator (constructor): " + ex.getMessage());
            System.exit(1);
        }
    }
}
