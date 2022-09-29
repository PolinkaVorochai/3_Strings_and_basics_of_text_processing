package part_3;

//Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
// Крайние пробелы в строке удалить.
public class Task_5 {
    public static void main(String[] args) {
        String oldStr = "   12     cats   15    dogs    105    tigers    ";
        System.out.println("Заданная строка: " + oldStr);
        String newStr = oldStr.replaceAll("\\s+", " ");
        System.out.println(newStr.trim());
    }
}
