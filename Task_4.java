package part_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//В строке найти количество чисел
public class Task_4 {
    public static void main(String[] args) {
        int k = 0;
        String str = "12 cats 15 dogs 105 tiger";
        int counter = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        int position = 0;
        while (matcher.find(position)) {
            position = matcher.end();
            counter++;
        }
        System.out.println("Заданная строка: " + str);
        System.out.println("Количество цифр в строке: " + counter);
    }
}
