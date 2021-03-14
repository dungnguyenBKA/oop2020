import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyDate {
    private int day = -1;
    private int month = -1;
    private int year = -1;

    public int getDay() {
        return day;
    }

    public boolean setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
            return true;
        }
        return false;
    }

    public int getMonth() {
        return month;
    }

    public boolean setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
            return true;
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        if (year > 0) {
            this.year = year;
            return true;
        }
        return false;
    }


    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate() {
    }

    public MyDate(String date) {

    }

    public void accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a date");
        System.out.print("day: ");
        int tmp = scanner.nextInt();
        if (!setDay(tmp)) {
            System.out.println("Day invalid, cannot create date");
            scanner.close();
            return;
        }
        System.out.print("month: ");
        tmp = scanner.nextInt();
        if (!setMonth(tmp)) {
            System.out.println("Month invalid, cannot create date");
            scanner.close();
            return;
        }

        System.out.print("year: ");
        tmp = scanner.nextInt();
        if (!setYear(tmp)) {
            System.out.println("Year invalid, cannot create date");
        }
        scanner.close();
        // check date valid
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        try {
            String date = String.format("%04d%02d%02d", year, month, day);
            LocalDate.parse(date, dateFormatter);
        } catch (Exception e) {
            System.out.println("Invalid date!!!");
            day = -1;
            month = -1;
            year = -1;
        }
    }

    public void print() {
        if (day == -1 || month == -1 || year == -1) {
            // reset
            day = -1;
            month = -1;
            year = -1;
            System.out.println("Current no date is created");
            return;
        }
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }
}
