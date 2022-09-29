package part_3;

//Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
public class Task_1 {
    public static void main(String[] args) {
        String s = "saleBritainSaleChine";
        String[] splitString = s.split("(?=[A-Z])");
        String arrayToString = String.join("_", splitString);
        String snake = arrayToString.toLowerCase();
        System.out.println(snake);
    }
}
