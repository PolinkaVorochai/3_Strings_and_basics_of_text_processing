package part_3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы.
public class Task_14 {
    public static void main(String[] args) {
        System.out.println("Введите строку из слов, разделенных пробелами: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        Pattern lowercaseLetters = Pattern.compile("[a-z]");
        Pattern capitalLetters = Pattern.compile("[A-Z]");

        Matcher matcherLower = lowercaseLetters.matcher(str);
        Matcher matcherCapital = capitalLetters.matcher(str);
        int lower = 0;
        while (matcherLower.find()) {
            lower += 1;
        }
        System.out.println("Количество строчных букв: " + lower);
        int capital = 0;
        while (matcherCapital.find()) {
            capital += 1;
        }
        System.out.println("Количество прописных букв " + capital);
    }
}
