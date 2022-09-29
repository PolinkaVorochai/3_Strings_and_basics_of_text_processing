package part_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
public class Task_6 {
    public static void main(String[] args) {
        String oldStr = "   12     cats   15    dogs    105    tigers    ";
        System.out.println("Заданная строка: " + oldStr);
        int numbers;
        int maxNumbers = 0;
        Pattern space = Pattern.compile("\\s+");
        Matcher matcher = space.matcher(oldStr);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            numbers = end - start;
            //numbers = matcher.end()-matcher.start();
            if (maxNumbers < numbers) {
                maxNumbers = numbers;
            }
            // System.out.println(" с " + start + " по " + end);
            //  System.out.println("Количество пробелов " + numbers);
        }
        System.out.println("Максимальное количество пробелов " + maxNumbers);
    }
}
