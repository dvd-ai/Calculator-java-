package application.calculator;

public interface i_calculator {

    interface getting_input {
        String read_keyboard_data();
    }

    interface input_check {
        String ER_STR_FORMAT = "Incorrect string format (input)";

        boolean check_string_format(String input);

        void print_found_exception(String message);
    }

    interface calculation {
        String VALID_OPERATORS = "+-*/";
        String [] RomanSymbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] ArabicSymbols = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        char get_operator(String str);

        int[] get_Numbers(String str, int[] dst);

        String Int2Roman(int aNumber);

        int Roman2Int(String Roman_num);

        void define_operator_and_calculate(char operator, int[]operands);

        int addition(int a, int b);

        int subtraction(int a, int b);

        int division(int a, int b);

        int multiplication(int a, int b);

        void print_result(int result);
    }
}
