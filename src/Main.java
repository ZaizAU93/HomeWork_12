import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.io.Serializable;
import Serializable.*;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Задача 1:
        //Используя FileOutputStream и FileInputStream записать в файл tms.txt строку, введенную
        //пользователем с консоли. Считать строку из файла tms.txt и вывести в консоль, заменив
        //все пробелы на знак нижнего подчеркивания.
        System.out.println("Введите строку для записи в файл");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String stroka = null;
        try {
            File file = new File("E:\\TeachMeSkills\\HomeWork_12\\tms.txt");

            FileOutputStream fOs = new FileOutputStream(file, false);
            fOs.write(text.getBytes(StandardCharsets.UTF_8));
            fOs.close();
            FileInputStream fIs = new FileInputStream(file);

            int i;
            stroka = "";
            while ((i = fIs.read()) != -1) {
                stroka += ((char) i);
            }
            fIs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stroka.replace(" ", "_"));
        System.out.println("--------------Задание 2-----------------------");
        //Задача 2:
        //Используя FileReader и FileWriter сначала записать в файл tms2.txt фразу на латыни
        //“Cognosce te ipsum”, а затем считать ее и вывести в консоль первую букву

        File file_2 = new File("E:\\TeachMeSkills\\HomeWork_12\\tms2.txt");
        String stroka_1 = "Cognosce te ipsum";
        try {
            FileWriter fw = new FileWriter(file_2);
            fw.write(stroka_1);
            fw.write(stroka_1);
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String read = "";

        try {
            FileReader fr = new FileReader(file_2);
            int i;

            while ((i = (fr.read())) != -1) {
                read += (char) i;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(read.charAt(0));

        System.out.println("-------------------Серилизация и десерилизация------------------------------");

        Student stud_boris = new Student("Борис Бритва", 3, 4.9);
        Student stud_britva = new Student("Nana Borisovs", 3, 4.7);
        try {
        ObjectOutputStream objOtStre = new ObjectOutputStream(new FileOutputStream(new File("E:\\TeachMeSkills\\HomeWork_12\\student.txt")));
        objOtStre.writeObject(stud_boris);
        objOtStre.writeObject(stud_britva);
        objOtStre.flush();
        objOtStre.close();
    }catch (IOException e){
        e.printStackTrace();
        }

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("E:\\TeachMeSkills\\HomeWork_12\\student.txt"));
        Student[] st = new Student[2];
        for(int i = 0; i <st.length; i++) {
            st[i] = (Student) objIn.readObject();
        }
        System.out.println(st[1].getName());
        System.out.println(st[0].getName());
    }
}