package part_3;

//Проверить, является ли заданное слово палиндромом
public class Task_8 {
    public static void main(String[] args) {
        String str = "ДоХод";
        char[] strToArray = str.toCharArray();
        char[] newStrToArray = new char[strToArray.length];
        for (int i = 0, j = strToArray.length - 1; i < strToArray.length && j >= 0; i++, j--) {
            newStrToArray[i] = strToArray[j];
        }
        String result = String.valueOf(newStrToArray);
        System.out.println("Слово " + str + " является или не является палиндромом: " + str.equalsIgnoreCase(result));
    }
}
