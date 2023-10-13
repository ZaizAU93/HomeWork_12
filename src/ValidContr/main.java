package ValidContr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

        String catalog = "E:\\TeachMeSkills\\HomeWork_12\\docum.txt";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите название файла, через точку расши рение .txt");
        //catalog.concat(scanner.nextLine());
        //catalog += scanner.nextLine();
        String text = "";
        System.out.println(catalog);
        try {
            FileInputStream fis = new FileInputStream(catalog);
            int i;
            while ((i = (fis.read())) != -1) {
                text += (char) i;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = text.split("\\n");


        // System.out.println(Arrays.toString(text.split("\t")));
        try {
            FileOutputStream fos = new FileOutputStream("E:\\TeachMeSkills\\HomeWork_12\\noValid.txt");
            Validity val = new Validity(arr);

            for (String s : arr) {
                String strResult = "";
                if (val.validity_Check_Name(String.valueOf(s))) {
                    strResult = "Название не соответствеет условиям " + s + '\r';
                    fos.write(strResult.getBytes(StandardCharsets.UTF_8));
                } else if (val.validity_Check_SpecialCharacters(String.valueOf(s))) {
                    strResult = "В названиии документа имеются служебные символы " + s + '\r';
                    fos.write(strResult.getBytes(StandardCharsets.UTF_8));
                } else if (val.validity_Check_Length(String.valueOf(s))) {
                    strResult = "Не соответсвтвие длинны " + s + '\r';
                    fos.write(strResult.getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Validity k = new Validity(arr);
        for (String s: arr){
          //  k.validity_Check_Length(s);
         // k.validity_Check_Name(s);
          //  k.validity_Check_SpecialCharacters(s);
        }

    }
}
