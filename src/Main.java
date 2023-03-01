

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int b;
    static int c;
    static boolean isRoma = true;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите числа от 1 до 10: ");        // вводятся данные с консоли и происходит вызов метода calc
        String input = sc.nextLine();                           // который производит арифметические операции
        String calc = calc(input);
        System.out.println("Ответ: " + calc);

        sc.close();
    }




    public static String calc(String input) throws Exception {


        String[] signs = {"+", "-", "*", "/"};
        String[] result = input.split("[+\\-*/]", 2); //сплит по знаку
        String[] resul = input.split(" ");               //сплит по пробелу
        int f = 0;
        String str = "";
        String out = "";
        RomaNumber[] values = RomaNumber.values();
        RomaNumber.fromArab(str,f);

        if (3 != resul.length) {
            throw new Exception("Не корректное выражение! ");
        }
        if (result.length != 2) {
            throw new Exception("Не корректное выражение!");


        }
        int signIndex = -1;
        for (int i = 0; i < signs.length; i++) {        // цикл фор ищет введеный знак
            if (input.contains(signs[i]))
                signIndex = i;
        }
        int b, c;
        int d = 0;

        try {
            b = Integer.parseInt(resul[0]);        //преобразование из стринга в инт
            c = Integer.parseInt(resul[2]);
            isRoma = false;                       //если введены не римские числа этот парс не работает

        } catch (NumberFormatException e) {
            try {

                b = RomaNumber.valueOf(resul[0]).getX();
                c = RomaNumber.valueOf(resul[2]).getX();
                isRoma = true;

            } catch (IllegalArgumentException ex) {
                throw new Exception("Не корректный ввод! ", ex);     // Вывод ошибки если введеные числа в разных форматах
            }
        }


        if (b < 1 || b > 10) {
            throw new Exception("Не корректное выражение! Введите числа от 1 до 10!");    //выбрасывание исключений
        }
        if (c < 1 || c > 10) {
            throw new Exception("Не корректное выражение! Введите числа от 1 до 10!");
        }


        switch (signs[signIndex]) {
            case "+" -> d = b + c;
            case "-" -> d = b - c;                  //арифметические операции
            case "*" -> d = b * c;
            case "/" -> d = b / c;
            default -> {

            }


        }

        if (isRoma) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].getX() == d) {
                       out = values[i].getStr();
                             return out;
                }
            }
        }


        return Integer.toString(d);




    }

}








