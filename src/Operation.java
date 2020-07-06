public class Operation {

    private static int x, y;
    private static String result;

    public static String operation(String a, String b, String operator, String type) {

      if (type.equals("arabic")) {
          x = Integer.parseInt(a);
          y = Integer.parseInt(b);
          result = "" + oper(x,y,operator);
      } else if (type.equals("roman")){
          x = romanToArabic(a);
          y = romanToArabic(b);
          result = arabicToRoman(oper(x,y,operator));
      }

        return result;
    }

    private static int oper(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y; //сложение
            case "-":
                return x - y; //вычитание
            case "*":
                return x * y; //умножение
            case "/":
                return x / y;//деление
            default:
                return 0;
        }
    }



    private static int romanToArabic(String a) {  //конвертирует римскую цифру до 10 в арабскую
            String[] array = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i=0; i<array.length;i++) {
            if (a.equals(array[i]))
                return i + 1;
        }
        return 0;
    }

    private static String arabicToRoman(int oper) { //конвертирует арабкую цифру до 100 в римскую
        if (oper<1) { //проверяем, что римская цифра больше 0
            return "Ошибка! Результат операции над римским цифрами меньше или равно 0";
        }

        String[] array = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] array2 = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String result = "";

        for (int i=0; i<array2.length;i++){
            if (oper/10==(i+1)) {
                result = array2[i];
            }
        }

        for (int i=0; i<array.length;i++){
            if (oper%10==(i+1)) {
                result = result + array[i];
            }
        }
      return result;
    }


}
    
