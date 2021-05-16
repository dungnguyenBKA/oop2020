package hust.soict.hedspi.garbage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GarbageCreater {
    public static void main(String[] args) throws FileNotFoundException {
        String url = "F:\\Study\\2020-2\\OOP\\tonganh-tonganh-OOLT.20202.20184040.TongNgocAnh\\Lec5\\db.txt";
        FileInputStream fileInputStream = new FileInputStream(url);
        String saveTextData = "";
        Scanner scanner = new Scanner(fileInputStream);
        try {
            while (scanner.hasNextLine()) {
                saveTextData += "" + scanner.nextLine() + "+";
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadOnlyFileSystemException.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(saveTextData);
    }
}
