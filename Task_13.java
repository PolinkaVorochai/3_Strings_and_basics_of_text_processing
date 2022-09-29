package part_3;

import java.util.Scanner;

//Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
// Случай, когда самых длинных слов может быть несколько, не обрабатывать.
public class Task_13 {
    public static void main(String[] args) {
        System.out.println("Введите строку из слов, разделенных пробелами: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        int maxLength = 0;
        String maxWord = new String("");

        for (String words : str.split("\\s+")) {
            if (maxLength < words.length()) {
                maxLength = words.length();
                maxWord = words;
            }
        }
        System.out.println("Самое длинное слово: " + maxWord);
    }
}
