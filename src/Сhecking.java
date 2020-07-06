import java.util.ArrayList;

class Сhecking {

    public static ArrayList<String> check(String line) throws CalculatorException{
        line = line.replaceAll("\\s", ""); //удаляем пробелы

        String regRome="M{0,3}(|CD|D?C{0,3}|CM)(|XL|L?X{0,3}|XC)(|IV|V?I{0,3}|IX)";
        String regRome10="(|IV|V?I{0,3}|I?X)";

        boolean a0 = line.matches("\\S+[\\+\\-\\*\\/]\\S+"); //проверка, что операнды не пустые символы
        boolean a = line.matches("\\d+[\\+\\-\\*\\/]\\d+"); //проверка, что введены две арабские цифры с корректным оператором
        boolean b = line.matches(regRome+"[\\+\\-\\*\\/]"+regRome); //проверка, что введены две римские цифры с корректным оператором
        boolean c = line.matches(regRome+"[\\+\\-\\*\\/]\\d+"); //проверка, что цифры или только арабские, или только римские
        boolean d = line.matches("\\d+[\\+\\-\\*\\/]"+regRome);//проверка, что цифры или только арабские, или только римские
        boolean e = line.matches("((0*10)|0*[0-9])[\\+\\-\\*\\/]((0*10)|0*[0-9])"); //проверка, что арабские цифры не превышают 10
        boolean f = line.matches(regRome10+"[\\+\\-\\*\\/]"+regRome10); //проверка, что римские цифры не превышают 10

       if(!(a0)) throw new CalculatorException("Вы ввели некорректную операцию.");

       if(!(a||b||c||d)) throw new CalculatorException("Вы ввели некорректную операцию.");

       if (c||d) throw new CalculatorException("Вы ввели одновременно арабские и римские цифры.");

       if (!(e||f)) throw new CalculatorException("Вы ввели цифру(-ы) больше 10.");



       ArrayList<String> list = new ArrayList<>();
       String[] array = line.split("[\\+\\-\\*\\/]");

       for (String element : array)
           list.add(element); // добавляем в список операнды
       list.add(line.replaceAll("[^\\+\\-\\*\\/]", "")); // добавляем в список оператор

        // добавляем в список тип цифр:
       if (a) list.add("arabic");
       else list.add("roman");

        return list;
    }
}

class CalculatorException extends Exception{

    public CalculatorException(String message){

        super(message);
    }
}

