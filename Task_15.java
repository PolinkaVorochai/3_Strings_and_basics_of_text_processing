package part_3;

//Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным знаком.
// Определить количество предложений в строке X.
public class Task_15 {
    public static void main(String[] args) {
//        System.out.println("Введите строку из нескольких предложений.В конце предложения может стоять точка, " +
//                "восклицательный или вопросительный знаки : ");
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
        String str = "cats!dogs?tigers.chicken?!";
        int number = 0;

        for (String suggestions : str.split("[.!?]+")) {
            number += 1;
        }

        System.out.println("Количество предложений в тексте: " + number);
    }
}
