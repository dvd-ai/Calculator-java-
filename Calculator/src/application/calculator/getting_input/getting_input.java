package application.calculator.getting_input;

import application.calculator.i_calculator;
import java.util.Scanner;

public class getting_input implements i_calculator.getting_input {

    public String read_keyboard_data() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextLine();
        }
        catch (Exception ex) {
            System.err.println("In application.calculator.getting_input method 'read_keyboard_data':"
                    + ex.getMessage());
            System.exit(1);
            return null;
        }
    }
}
