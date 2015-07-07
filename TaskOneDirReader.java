import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by CuCbKu on 07.07.2015.
 *
 * The task:
 *
 * Дан каталог с подкаталогами, содержащими файлы с разными именами.
 Также имеется файл main_list_name.txt с именами файлов.
 Требуется вывести имена и пути к файлам в каталоге,
 имена которых отличаются от списка с main_list_name.txt.
 */

public class TaskOneDirReader {
    public static void main(String[] args) {
        String dirPath = "D:\\Work\\Test_Tasks\\Nakitel\\main_dir";

        GetCompare();

        DirRead(dirPath);
    }

    public static String compareTo = "";

    // Метод, который наполняет строку для сравнения (чтобы каждый раз не получать доступ к файлу).
    public static void GetCompare() {
        try (FileInputStream fileIS = new FileInputStream("D:\\Work\\Test_Tasks\\Nakitel\\main_list_name.txt")){
            for (int i = 0; i < fileIS.available(); i++) {
                compareTo += (char) fileIS.read();
            }
        } catch (IOException e) {
            System.out.println("I/O Error" + e);
        }
    }

    // Считывает директорию, если находит внутри ещё директории, рекурсивно вызывает себя с новым параметром.
    // Для каждого файла выполняет метод FileCompare.
    public static void DirRead(String dirPath) {
        File dir = new File(dirPath);
        boolean flag;

        if (dir.isDirectory()) {
            String list[] = dir.list();
            for (int i = 0; i < list.length; i++) {
                File f = new File(dirPath + "\\" + list[i]);
                if (f.isDirectory()) {
                    DirRead(f.getPath());
                } else {
                    flag = FileCompare(f);
                    if (flag) {
                        System.out.println(f.getName() + " - " + f.getPath());
                    }
                }
            }
        } else {
            System.out.println(dirPath + "is NOT a directory");
        }
    }

    // Сравнивает имя файла с именами из строки compareTo и возвращает булевое значение.
    public static boolean FileCompare(File f) {
        int j=0;

        for (int i = 0; i < compareTo.length(); i++) {
            if (f.getName().charAt(j) == compareTo.charAt(i)){
                j++;
                if (j==f.getName().length()){
                    return true;
                }
            } else {
                j = 0;
            }
        }
        return false;
    }
}
