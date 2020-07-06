import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws ArithmeticException {
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя целыми числами:");
        System.out.println("a + b, a - b, a * b, a / b. Данные передаются в одну строку!");
        System.out.println("Числа могут быть арабскими или римскими от 0 до 10. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
        System.out.println("Например: 1+2; 6/2; IX-II.");

        while (true) {
            System.out.println("Введите операцию и нажмите \"Ввод\":");
            Scanner in = new Scanner(System.in);


            try {
                ArrayList<String> list = Сhecking.check(in.nextLine());
                System.out.println(Operation.operation(list.get(0), list.get(1), list.get(2), list.get(3)));
            } catch (CalculatorException ex) {
                System.out.println(ex.getMessage());
                break;
            } catch (ArithmeticException ex1) {
                System.out.println("Ошибка: "+ex1.getMessage());
            }
        }


    }
}
