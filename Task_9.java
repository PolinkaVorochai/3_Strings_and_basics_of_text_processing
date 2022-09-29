package part_3;

//С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
public class Task_9 {
    public static void main(String[] args) {
        String str = "информатика";

        int indexT = str.indexOf('т');
        int indexO = str.indexOf('о');
        int indexP = str.indexOf('р');

        char chT = str.charAt(indexT);
        char chO = str.charAt(indexO);
        char chP = str.charAt(indexP);

        char[] chars = {chT, chO, chP, chT};
        System.out.println(str);
        System.out.println(String.valueOf(chars));
    }
}
