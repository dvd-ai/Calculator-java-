package application.calculator.input_check;

import application.calculator.i_calculator;

public class input_check implements i_calculator.input_check {

    public input_check(String input) {
        try {
            if (!check_string_format(input)) throw new Exception(ER_STR_FORMAT);
        }
        catch (Exception ex) {
            print_found_exception(ex.getMessage());
            System.exit(1);
        }

    }

    public boolean check_string_format(String input) {
        return input.matches(
                "(^(10|[0-9]) *" + // 1-й случай: [НАЧАЛО СТРОКИ(^); первое число: 10 или
                                        // от 0 до 9 вкл и ВОЗМОЖЕН следующий символ - пробел(-ы)
                "(\\+|-|(\\*)|/) *" + // знак операции (+/-/*//) и ВОЗМОЖЕН пробел(-ы)
                "(10|[0-9]$))" +         //второе число: 10 или от 0 до 9 и КОНЕЦ СТРОКИ($)]
                        "|(^(I{1,3}|(I?V)|(VI{1,3})|(I?X)) *" +  //2-й случай: [НАЧАЛО СТРОКИ(^); римские цифры от 1 до 10 вкл] и ВОЗМОЖЕН пробел(-ы)
                "(\\+|-|(\\*)|/) *" +    // знак операции (+/-/*//) и ВОЗМОЖЕН пробел(-ы)
                "(I{1,3}|(I?V)|(VI{1,3})|(I?X))$)");                // римские цифры от 1 до 10 вкл и КОНЕЦ СТРОКИ($)]
                                            // P.S. '|' - 'логическое или', '?' - пред. символ встречается 1 или 0 раз
    }

    public void print_found_exception(String message) {
        System.err.println(message);
    }
}
