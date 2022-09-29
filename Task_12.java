package part_3;

import java.util.Scanner;

//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
// Например, если было введено "abc cde def", то должно быть выведено "abcdef".
public class Task_12 {
    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String strWithoutSpace = str.replaceAll("\\s+", "");
        //System.out.println(strWithoutSpace);
        char[] charArray = strWithoutSpace.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    charArray[j] = 0;
                }
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 0) {
                System.out.print(charArray[i]);
            }
        }
    }
}


