import coloredString.ColoredString;
import coloredString.Colors;

import static coloredString.Colors.*;
import static coloredString.Logger.*;
import static helpers.Helpers.*;

public class Main {
    public static void main(String[] args) {
        printArticle("coloredString.Logger");

        printSubSection("printAlarm/Warning/MarkMessage()");
        {
            printAlarmMessage("Попытка добавить null задачу");
            printAlarmMessage("Попытка добавить null задачу", true);
            printAlarmMessage("Попытка добавить null задачу", false, true);
            printWarningMessage("Такой задачи еще не существует");
            printMarkMessage("Удалили из конца");
            printMarkMessage(false, "Удалили из конца");
        }

        printSubSection("printMessage()");
        {
            printMessage("Only bold", BLACK, true);
            printMessage("Only italic", BLACK, false, true);
            printMessage("Only underlain", BLACK, false, false, true);
            printMessage("Only bold and italic", BLACK, true, true);
            printMessage("Only italic and underline", BLACK, false, true, true);
            printMessage("Only bold and underline", BLACK, true, false, true);
        }

        printSubSection("Bold/Italic/Underline");
        {
            printBoldMessage("Only bold", GREEN);
            printItalicMessage("Only italic", GREEN);
            printUnderlineMessage("Only underline", GREEN);
        }


        printSubSection("Явная демонстрация");
        {
            System.out.println("\u001B[30m" + "Xyonix" + RESET);
            System.out.println("\u001B[1;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[3;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[4;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[3;4;1;30m" + "Xyonix" + RESET);
        }

        printSubSection();
        {
            ColoredString string1 = new ColoredString("Zyzoza", RED);
            System.out.println(string1 + "Brightness" + string1);

            string1.changeColor(GREEN);
            System.out.println(string1 + "Brightness" + string1);

            string1.changeText("NewZyzoza ");
            System.out.println(string1 + "Brightness" + string1);

            System.out.println(string1.getUncoloredText() + "Brightness" + string1.getUncoloredText());
        }

        printSubSection("Перечисление coloredString.Colors:");
        {
            for (Colors value : values()) {
                System.out.println(value.getColoredString());
            }
        }

        printSubSection("Просто сравнение длины строк");
        {
            String origin = "The wild wind";
            System.out.println(origin);
            System.out.println(origin.length());

            ColoredString string = new ColoredString("The wild wind", PURPLE);
            System.out.println(string);
            System.out.println(string.toString().length());

            string = string.changeOptions(true, false, true);
            System.out.println(string);
            System.out.println(string.toString().length());

        }

        printSubSection();
        {
            ColoredString string = new ColoredString("Если бы да кабы", BLACK, true, false, true);
            System.out.println(string);

            string.changeColor(GREEN);
            System.out.println(string);

            ColoredString copy = new ColoredString(string);
            System.out.println(copy);

            copy = string.changeColor(RED);
            copy.changeOptions(false, true, true);
            System.out.println(copy);
        }
        printArticleEnding();
    }
}