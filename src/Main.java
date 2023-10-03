import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //«адача 1:
        //»спользу€ FileOutputStream и FileInputStream записать в файл tms.txt строку, введенную
        //пользователем с консоли. —читать строку из файла tms.txt и вывести в консоль, заменив
        //все пробелы на знак нижнего подчеркивани€.
        System.out.println("¬ведите строку дл€ записи в файл");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        File file = new File("E:\\TeachMeSkills\\HomeWork_12\\tms.txt");

        FileOutputStream fOs = new FileOutputStream(file, true);
        fOs.write(text.getBytes());



        String strings = "stroka нова€";
        try (FileWriter fileWriter = new FileWriter(file)) {
           fileWriter.write(String.valueOf(strings.getBytes()));
           fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int i;
            String s = "";
            while (bufferedReader.read() != -1) {
                i = (bufferedReader.read());
                System.out.print((char) i);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}