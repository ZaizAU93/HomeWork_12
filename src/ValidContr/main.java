package ValidContr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

        String catalog = "E:\\TeachMeSkills\\HomeWork_12\\";
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �������� �����, ����� ����� ����� ����� .txt");
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
        System.out.println("������ ������ "+arr.length);

        for (String arrs: arr) {
        //    System.out.println(arrs);
        }


       // System.out.println(Arrays.toString(text.split("\t")));

       Validity val = new Validity(arr);
        val.validity_Check_Length();
    }
}
