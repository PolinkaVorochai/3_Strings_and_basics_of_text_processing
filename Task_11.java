package part_3;

//Из заданной строки получить новую, повторив каждый символ дважды
public class Task_11 {
    public static void main(String[] args) {
        String str = "12 cats 15 elephant 105 tigers ";
        char[] fromStr = str.toCharArray();
        char[] doubledFromStr = new char[fromStr.length * 2];

        for (int i = 0, j = 0; i < fromStr.length && j < doubledFromStr.length; i++, j += 2) {
            doubledFromStr[j] = fromStr[i];
            doubledFromStr[j + 1] = fromStr[i];
        }
        System.out.println(str);
        System.out.println(String.valueOf(doubledFromStr));
    }
}
