package ValidContr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Задача *:
        //Допустим есть txt файл с номерами документов. Номером документа является строка,
        //состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
        //номер документа с новой строки и в строке никакой другой информации, только номер
        //документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
        //последовательности docnum(далее любая последовательность букв/цифр) или
        //contract(далее любая последовательность букв/цифр). Написать программу для чтения
        //информации из входного файла - путь к входному файлу должен задаваться через
        //консоль. Программа должна проверять номера документов на валидность. Валидные
        //номера документов следует записать в один файл-отчет. Невалидные номера документов
        //следует записать в другой файл-отчет, но после номеров документов следует добавить
        //информацию о том, почему этот документ не валиден

        String catalog = "E:\\TeachMeSkills\\HomeWork_12\\";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла, через точку расши рение .txt");
        //catalog.concat(scanner.nextLine());
        catalog += scanner.nextLine();
        String text = "";
        System.out.println(catalog);
        try {
            FileInputStream fis = new FileInputStream(catalog);
            int i;
            while ((i=(fis.read())) != -1){
                text += (char)i;
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        String[] arr = text.split("\\n");
        System.out.println("длинна масива "+arr.length);

        for (String arrs: arr) {
        //    System.out.println(arrs);
        }


       // System.out.println(Arrays.toString(text.split("\t")));

       Validity val = new Validity(arr);
        val.validity_Check_Length();
    }
}
