package Romeo_and_Juliet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Задача 1:
        //В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
        //Проанализировать и записать в другой файл самое длинное слово
        String text = "";
        try {
            FileInputStream fis = new FileInputStream("E:\\TeachMeSkills\\HomeWork_12\\Romeo and Juliet.txt");
            int i;
            while ((i = fis.read()) != -1){
                text += (char) i;
                System.out.print((char) i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------");
        String[] arr = text.split("\\W+");

        String max_length_word = "";
        //int buf = 0;

        for (int i = 0; i < arr.length; i++){
            if(arr[i].length() > max_length_word.length()){
                max_length_word = arr[i];
            }
        }
      //  System.out.println(max_length_word);
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\TeachMeSkills\\HomeWork_12\\Romeo and Juliet word.txt"));
            fos.write(max_length_word.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
