package hust.soict.hedspi;

import java.util.Scanner;

public class ScannerUtils {
    private ScannerUtils() {}

    public static int nextInt(Scanner scanner) {
        int nextInt;
        while (!scanner.hasNextInt()) {
            System.out.println("Enter the Number :");
            scanner.next();
        }
        nextInt = scanner.nextInt();
        return nextInt;
    }

    public static int nextInt(int from, int to, Scanner scanner) {
        int nextInt;
        System.out.println("Enter Int from "+from +" to " +to+" : ");
        do {
            nextInt = nextInt(scanner);
            if (nextInt < from || nextInt > to){
                System.out.println("Enter again.Invalid range: ");
            }
        } while (nextInt < from || nextInt > to);
        return nextInt;
    }
}