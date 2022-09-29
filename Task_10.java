package part_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
public class Task_10 {
    public static void main(String[] args) {
        String oldStr = "London is the cApital of Great BritainaaAA";
        System.out.println("Заданная строка: " + oldStr);
        int numbers = 0;
        Pattern space = Pattern.compile("[aA]");
        Matcher matcher = space.matcher(oldStr);
        while (matcher.find()) {
            numbers += matcher.end() - matcher.start();
        }
        System.out.println("Буква 'a' встречается " + numbers + " раз ");
    }
}
