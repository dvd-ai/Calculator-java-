package application.calculator.calculation;

import application.calculator.i_calculator;

public class calculation implements i_calculator.calculation {
    public char m_operator;
    public int[] m_operands;
    public boolean m_num_is_Roman;

    public calculation(String str) {
        try {
            m_num_is_Roman = false;
            m_operator = get_operator(str);
            m_operands = get_Numbers(str, m_operands);
            define_operator_and_calculate(m_operator, m_operands);
        }
        catch (Exception ex) {
            System.err.println("in application.calculator.calculation (constructor): " + ex.getMessage());
            System.exit(1);
        }
    }

    public char get_operator(String str) {
        int str_length = str.length();
        int v_op_length = VALID_OPERATORS.length();

        for (int i = 0; i < str_length; i++) {
            for (int j = 0; j < v_op_length; j++ ) {
                if (str.charAt(i) == VALID_OPERATORS.charAt(j)) {
                    return VALID_OPERATORS.charAt(j);
                }
            }
        }
        return '0'; //unreachable due to input_check.java (for compiler only)
    }

    public int[] get_Numbers(String str, int[] dst) {
        int arrSize = 2;
        dst = new int[arrSize];

        //избавление строки от пробелов
        String[] Splt_str = str.replaceAll(" ", "").split("(\\+|-|(\\*)|/)");

        //если 1-я цифра римская (значит все цифры будут римскими)
        if (Splt_str[0].matches("(I{1,3}|(I?V)|(VI{1,3})|(I?X))"))
            m_num_is_Roman = true;

        for (int i = 0; i < arrSize; i++) {
            if (!m_num_is_Roman)
                dst[i] = Integer.parseInt(Splt_str[i]);    //арабское число

            else dst[i] = Roman2Int(Splt_str[i]); //римское число
        }
        return dst;
    }

    public int Roman2Int(String roman) {
        int result = 0;
        String uRoman = roman.toUpperCase();    //case-insensitive
        for (int i = 0; i < uRoman.length() - 1; i++) {     //loop over all but the last character
            if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                result -= decodeSingle(uRoman.charAt(i));
            } else {
                result += decodeSingle(uRoman.charAt(i));
            }
        }
        result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
        return result;
    }

    //подметод Roman2Int
    public int decodeSingle(char letter) {
        return switch (letter) {
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }

    public String Int2Roman(int aNumber)
    {
        String numeric = "";
        int BitDepth;
        int index = 0;
        int ArabicSymbols_len = ArabicSymbols.length;

        while (index<ArabicSymbols_len)
        {
            BitDepth = aNumber / ArabicSymbols[index];

            for (int i = 0; i < BitDepth; i++) {
                numeric += RomanSymbols[index];
            }
            aNumber -= BitDepth * ArabicSymbols[index];
            index++;
        }
        return numeric;
    }

    public void define_operator_and_calculate(char operator, int[] operands) {
        int i = 0;
        int j = 1;

        switch (operator) {
            case '+' -> print_result(addition(operands[i], operands[j]));
            case '-' -> print_result(subtraction(operands[i], operands[j]));
            case '*' -> print_result(multiplication(operands[i], operands[j]));
            case '/' -> print_result(division(operands[i], operands[j]));
        }
    }

    public int addition(int a, int b) { return a + b; }

    public int subtraction(int a, int b) { return a - b; }

    public int division(int a, int b) { return a / b; }

    public int multiplication(int a, int b) { return a * b; }

    public void print_result(int result) {
        if (!m_num_is_Roman)
            System.out.println(result);

        else System.out.println(Int2Roman(result));     }
}
