package ValidContr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //������ *:
        //�������� ���� txt ���� � �������� ����������. ������� ��������� �������� ������,
        //��������� �� ���� � ����(��� ��������� ��������). ����� ���� ���� �������� ������
        //����� ��������� � ����� ������ � � ������ ������� ������ ����������, ������ �����
        //���������. �������� ����� ��������� ������ ����� ����� 15 �������� � ���������� �
        //������������������ docnum(����� ����� ������������������ ����/����) ���
        //contract(����� ����� ������������������ ����/����). �������� ��������� ��� ������
        //���������� �� �������� ����� - ���� � �������� ����� ������ ���������� �����
        //�������. ��������� ������ ��������� ������ ���������� �� ����������. ��������
        //������ ���������� ������� �������� � ���� ����-�����. ���������� ������ ����������
        //������� �������� � ������ ����-�����, �� ����� ������� ���������� ������� ��������
        //���������� � ���, ������ ���� �������� �� �������

        String catalog = "E:\\TeachMeSkills\\HomeWork_12\\docum.txt";
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("������� �������� �����, ����� ����� ����� ����� .txt");
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
                    strResult = "�������� �� ������������� �������� " + s + '\r';
                    fos.write(strResult.getBytes(StandardCharsets.UTF_8));
                } else if (val.validity_Check_SpecialCharacters(String.valueOf(s))) {
                    strResult = "� ��������� ��������� ������� ��������� ������� " + s + '\r';
                    fos.write(strResult.getBytes(StandardCharsets.UTF_8));
                } else if (val.validity_Check_Length(String.valueOf(s))) {
                    strResult = "�� ������������� ������ " + s + '\r';
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
