package part_3;

//В строке вставить после каждого символа 'a' символ 'b'.
public class Task_7 {
    public static void main(String[] args) {
        String oldStr = "12 cats 15 elephant 105 tigers ";
        String newStr = oldStr.replaceAll("a", "ab");
        System.out.println("Заданная строка " + oldStr);
        System.out.println("Ответ " + newStr);
    }
}
