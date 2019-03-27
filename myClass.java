import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class myClass {
    public static class MyException extends IOException {

    }

    public static void main(String[] args) throws IOException {

        for (int x = 1; x < 5; x = x + 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер телефона");
            String number = sc.nextLine();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя");
            String name = scanner.nextLine();
            String str1 = number + " " + name + "\n";

            try {
                FileReader fr = new FileReader("C:\\Users\\Ольга\\IdeaProjects\\Project1\\src\\out.txt");
                Scanner scan = new Scanner(fr);
                boolean hasName = true;
                int i = 1;
                String str = "";
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                    System.out.println(i + " : " + str);
                    i++;
                    if (str.contains(name)) {
                        try {
                            throw (new MyException());
                        } catch (MyException e) {
                            System.out.println("Ошибка, такой контакт уже существует");
                            e.printStackTrace();
                            hasName = false;
                        }
                    }
                }
                if (hasName) {

                    FileWriter writer = new FileWriter("C:\\Users\\Ольга\\IdeaProjects\\Project1\\src\\out.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(str1);
                    bufferedWriter.close();
                }
            }

            catch(IOException e){
                System.out.println("Ошибка");
                e.printStackTrace();
            }
        }
    }
}


