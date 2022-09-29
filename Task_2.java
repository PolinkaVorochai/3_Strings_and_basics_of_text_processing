package part_3;

//Замените в строке все вхождения 'word' на 'letter'.
public class Task_2 {
    public static void main(String[] args) {
        String oldString = "Hello world! Welcome, world, cats, dogs";
        String newString = oldString.replace("world", "letter");
        System.out.println("Заданная строка: " + oldString);
        System.out.println("После замены: " + newString);
    }
}
