package part_3.task_17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Дана строка, содержащая следующий текст (xml-документ):
<notes>
<note id = "1">
<to>Вася</to>
<from>Света</from>
<heading>Напоминание</heading>
<body>Позвони мне завтра!</body>
</note>
<note id = "2">
<to>Петя</to>
<from>Маша</from>
<heading>Важное напоминание</heading>
<body/>
</note>
</notes>
Напишите анализатор, позволяющий последовательно
возвращать содержимое узлов xml-документа и его тип
(открывающий тег, закрывающий тег,
содержимое тега, тег без тела).
Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */
public class ParseXml {
    private static final String path = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\part_3\\task_17\\note.xml";
    void findCTextInTag(String str) {
        Pattern text = Pattern.compile(">. +<");
        Matcher matOpen = text.matcher(str);
        boolean foundOpen = matOpen.find();
        if (foundOpen) {
            int start = matOpen.start() + 1;
            int end = matOpen.end() - 1;
            System.out.println("text in tag " + str.substring(start, end));
        }
    }

    void findCloseTag(String str) {
        Pattern tag = Pattern.compile("</.+>");
        Matcher matOpen = tag.matcher(str);
        boolean foundOpen = matOpen.find();
        if (foundOpen) {
            int start = matOpen.start();
            int end = matOpen.end();
            System.out.println("close tag " + str.substring(start, end));
        }
    }

    void findNoBodyTag(String str) {
        Pattern tag = Pattern.compile("<.+/>");
        Matcher matOpen = tag.matcher(str);
        boolean foundOpen = matOpen.find();
        if (foundOpen) {
            int start = matOpen.start();
            int end = matOpen.end();
            System.out.println("no body tag " + str.substring(start, end));
        }
    }

    void findOpenTag(String str) {
        Pattern tag = Pattern.compile("<[^/][^/]+?>");
        Matcher matOpen = tag.matcher(str);
        boolean foundOpen = matOpen.find();
        if (foundOpen) {
            int start = matOpen.start();
            int end = matOpen.end();
            System.out.println("open tag " + str.substring(start, end));
        }
    }

    public void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            findOpenTag(str);
            findCTextInTag(str);
            findCloseTag(str);
            findNoBodyTag(str);
        }
        bufferedReader.close();
    }
}




