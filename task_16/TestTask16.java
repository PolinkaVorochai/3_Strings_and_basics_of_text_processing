package part_3.task_16;
/*
Cоздать приложение, разбирающее текст (текст хранится в строке)
и позволяющее выполнять с текстом
три различных операции: отсортировать абзацы по количеству предложений;
в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений
заданного символа, а в случае равенства – по алфавиту
 */

public class TestTask16 {
    public static void main(String[] args) {
        Task16 object = new Task16();
        object.printText();
        String command = "sortlexeme";//ввод команды

        switch (command) {
            case "sortNumberSentence":
                object.sortNumberSentence();
                break;
            case "sortWordlength":
                object.sortWordlength();
                break;
            case "sortlexeme":
                object.sortlexeme();
                break;
            default:
                System.out.println("command is wrong");
        }
    }
}
