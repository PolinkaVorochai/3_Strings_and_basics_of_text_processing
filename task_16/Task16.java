package part_3.task_16;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Cоздать приложение, разбирающее текст (текст хранится в строке)
и позволяющее выполнять с текстом
три различных операции: отсортировать абзацы по количеству предложений;
в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений
заданного символа, а в случае равенства – по алфавиту
 */
class Task16 {
    String text =
            "In the ancient city of London, on a certain autumn day in " +
                    "the second quarter of the sixteenth centure, a boy was born to a " +
                    "poor family of the name of Canty, who did not want him. " + "\n" + "On the same day another " +
                    "English child was born to a rich family of the name of Tudor, who did want him. " +
                    "All England wanted him too. England had so longed for him, and hoped for him, and prayd God for him, " +
                    "that, now that he was really come, the people went mad for joy. " + "\n" + "Mere acquaintances hugged and kissed each other and cried. " +
                    "Everybody took a holiday, and high and low, rich and poor, feasted and danced and sang, and got very mellow; " +
                    "and they kept this up for days and nights together.";

    //печать текста
    void printText() {
        System.out.println("text: ");
        System.out.println(text);
        System.out.println();
    }

    //разбить текст на параграфы (в массив)
    String[] splitTextOnParagraph() {
        Pattern paragraphPattern = Pattern.compile("\\n");
        String[] strings = paragraphPattern.split(text, -1);
        System.out.println("split text on paragraphs: ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println("paragraph " + i + " :" + strings[i]);
        }
        System.out.println();
        return strings;
    }

    //разбить текст на предложения (в массив) и удалить символ ненужные символы пунктуации из текста
    String[] splitTextOnSentence() {
        Pattern delete = Pattern.compile("[\\n,:;]||[\\s{2,}]");
        Matcher matcherNewParagraph = delete.matcher(text);
        String newText = matcherNewParagraph.replaceAll("");//удалить все ненужные символы пунктуации  из текста
        Pattern sentencePattern = Pattern.compile("[\\.!?]");
        String[] strings = sentencePattern.split(newText, 0);
        for (String string : strings) {
            string.trim();
        }
        System.out.println("split text on sentences: ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println("sentence " + i + " :" + strings[i].trim());
        }
        System.out.println();
        return strings;
    }

    //в каждом предложении отсортировать слова по длине
    void sortWordlength() {
        String[] sentence = splitTextOnSentence();
        System.out.println("result: ");
        for (int i = 0; i < sentence.length; i++) {
            System.out.println("sentence " + i + " :");
            String[] word = splitAndSortWordInSentence(sentence[i]);
            for (int j = 0; j < word.length; j++) {
                System.out.print(word[j].trim() + " ");
            }
            System.out.println();
        }

    }

    //разбить предложение одно на массив слов и отсортировать слова в массиве по длине
    String[] splitAndSortWordInSentence(String sentence) {
        Pattern wordPattern = Pattern.compile("\\s+?");
        String[] arrayWord = wordPattern.split(sentence.trim(), -1);
        ;
        boolean unsorted = true;
        String word;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < arrayWord.length - 1; i++) {
                if (arrayWord[i].length() > arrayWord[i + 1].length()) {
                    word = arrayWord[i];
                    arrayWord[i] = arrayWord[i + 1];
                    arrayWord[i + 1] = word;
                    unsorted = true;
                }
            }
        }
        return arrayWord;
    }

    //разбить 1 параграф на массив предложений
    String[] splitParagraphOnSentence(String paragraph) {
        Pattern patternSentence = Pattern.compile("[\\.!?][^\\n]");
        String[] arraySentence = patternSentence.split(paragraph, -1);
        return arraySentence;
    }

    //разбить все параграфы на массив массивов предложений
    String[][] splitAllParagraphOnSentenceReturn() {
        String[] paragraph = splitTextOnParagraph();
        String[][] sentence = new String[paragraph.length][];
        for (int n = 0, i = 0; i < paragraph.length && n < paragraph.length; i++, n++) {
            sentence[i] = splitParagraphOnSentence(paragraph[n]);
        }
        return sentence;
    }

    // отсортировать абзацы по количеству предложений;
    void sortNumberSentence() {
        String[][] sentence = splitAllParagraphOnSentenceReturn();
        boolean unsorted = true;
        String[] temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < sentence.length - 1; i++) {
                if (sentence[i].length > sentence[i + 1].length) {
                    temp = sentence[i];
                    sentence[i] = sentence[i + 1];
                    sentence[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
        System.out.println("result: ");
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence[i].length; j++) {
                System.out.println("paragraph " + i + " sentence " + j + " : " + sentence[i][j]);
            }
        }
    }

    //отсортировать лексемы в предложении по убыванию количества вхождений
//заданного символа, а в случае равенства – по алфавиту
    void sortlexeme() {
        String redactionText = text.replaceAll("[.,!?:;\\n]+", "");
        Pattern patternLexeme = Pattern.compile("\\s");
        String[] arrayLexeme = patternLexeme.split(redactionText, 0);
        //  Arrays.sort(arrayLexeme);//сортировка по алфавиту
        boolean unsorted = true;
        String temp;
        char symbol = setChar();
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < arrayLexeme.length - 1; i++) {
                int countNow = numberOfCharRepetitions(arrayLexeme[i], symbol);
                int countNext = numberOfCharRepetitions(arrayLexeme[i + 1], symbol);
                if (countNow < countNext) {
                    temp = arrayLexeme[i];
                    arrayLexeme[i] = arrayLexeme[i + 1];
                    arrayLexeme[i + 1] = temp;
                    unsorted = true;
                } else if (countNow == countNext) {
                    int compare = arrayLexeme[i].compareTo(arrayLexeme[i + 1]);//сортировка по алфавиту
                    if (compare > 0) {
                        temp = arrayLexeme[i];
                        arrayLexeme[i] = arrayLexeme[i + 1];
                        arrayLexeme[i + 1] = temp;
                        unsorted = true;
                    }
                }
            }
        }
        System.out.println("result: ");
        for (int i = 0; i < arrayLexeme.length; i++) {
            System.out.print(arrayLexeme[i] + " ");
        }
    }

    //ввести символ
    char setChar() {
        System.out.print("input any symbol: ");
        Scanner scan = new Scanner(System.in);
        char symbol = scan.next().charAt(0);
        return symbol;
    }

    //посчитать количество вхождений символа в слове
    int numberOfCharRepetitions(String word, char symbol) {
        int countSymbol = 0;
        char[] arrayChars = word.toCharArray();
        for (int i = 0; i < arrayChars.length; i++) {
            if (arrayChars[i] == symbol) {
                countSymbol++;
            }
        }
        return countSymbol;
    }
}


