
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    static String[] strDay = {"zero","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth","fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second","twenty-third",
            "twenty-fourth","twenty-fifth","twenty-sixth","twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"};
    static String[] strMonth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    static String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };
    static String nameArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety" };

    public MyDate() {
        Calendar currentDate = Calendar.getInstance();
        this.day = currentDate.get(Calendar.DAY_OF_MONTH);
        this.month = currentDate.get(Calendar.MONTH);
        this.year = currentDate.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.year = year;
            this.month = month-1;
            this.day = day;
            print();
        }
        else
            System.out.println("INVALID YEAR, MONTH OR DAY!");
    }

    public static boolean isValidDate(int day, int month, int year) {
        Calendar cDate = Calendar.getInstance();
        cDate.set(year, month-1, 1);
        return ((year >= 1) && (year <= 9999)) && ((month >= 1) && (month <= 12)) && ((day >= 1) && (day <= cDate.getActualMaximum(Calendar.DAY_OF_MONTH)));
    }

    public MyDate(String strDate) {
        Date tmpDate;
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd yyyy");
        Calendar cDate = Calendar.getInstance();
        formatter.setLenient(false);
        System.out.println(strDate);
        try {
            tmpDate = formatter.parse((strDate.replaceAll("st|nd|rd|th", "")).trim());
        } catch (ParseException e) {
            System.out.println("Invalid date or wrong format");
            return;
        }
        cDate.setTime(tmpDate);
        this.day = cDate.get(Calendar.DAY_OF_MONTH);
        this.month = cDate.get(Calendar.MONTH);
        this.year = cDate.get(Calendar.YEAR);
        print();
    }

    public MyDate(String day, String month, String year) {
        for(int i=0;i<=31;i++) {
            if(strDay[i].equals(day))
                this.day = i;
        }
        for(int i=0;i<12;i++) {
            if(strMonth[i].equals(month))
                this.month = i;
        }

        String[] yearList = year.split("\\s");
        int yNumber = 0;
        switch (yearList.length) {
            case 4:
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[0])) yNumber += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[2])) yNumber += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[3])) yNumber += i;
                break;
            case 3:
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[0])) yNumber += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[1])) yNumber += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i*100;
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[2])) yNumber += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[2])) yNumber += i;
                break;
            case 2:
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[0])) yNumber += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) yNumber += i*100;
                for(int i=0;i<10;i++) if(nameArray[i].equals(yearList[1])) yNumber += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) yNumber += i;
                break;
            default:
                break;
        }
        this.year = yNumber;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        Calendar cDate = Calendar.getInstance();
        cDate.set(year, month, 1);
        if(day < 1 || day > cDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){
            System.out.println("INVALID DAY");
            return;
        }

        this.day = day;
    }

    public int getMonth() {
        return month+1;
    }

    public void setMonth(int month) {
        if(month<1 || month > 12) {
            System.out.println("INVALID MONTH");
            return;
        }

        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year< 1 || year > 9999) {
            System.out.println("INVALID YEAR");
            return;
        }
        this.year=year;
    }

    public void accept() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the date: ");
        String strDate = keyboard.nextLine();
        Date tmpDate;
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd yyyy");
        Calendar cDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            tmpDate = formatter.parse((strDate.replaceAll("st|nd|rd|th", "")).trim());
        } catch (ParseException e) {
            System.out.println("INVALID DATE WRONG FORMAT");
            return;
        }
        cDate.setTime(tmpDate);
        this.day = cDate.get(Calendar.DAY_OF_MONTH);
        this.month = cDate.get(Calendar.MONTH);
        this.year = cDate.get(Calendar.YEAR);
        keyboard.close();
        print();
    }

    public void print() {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month, day);
        String dateFormat;

        switch (day) {
            case 1:
                dateFormat = "MMMMM d'st' yyyy";
                break;
            case 2:
                dateFormat = "MMMMM d'nd' yyyy";
                break;
            case 3:
                dateFormat = "MMMMM d'rd' yyyy";
                break;
            default:
                dateFormat = "MMMMM dd'th' yyyy";
                break;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime()));
    }


    enum FormatDate {
        /**
         * Format date, default is "MMM d yyyy"
         */
        FORMAT_DEFAULT,
        /**
         * Format date "MMM d yyyy"
         */
        FORMAT_1,
        /**
         * Format date "d/M/yyyy"
         */
        FORMAT_2,
        /**
         * Format date "yyyy-MM-dd"
         */
        FORMAT_3
    }

    public void printFormat(FormatDate formatDate) {
        String dateFormat = "";
        switch (formatDate) {
            case FORMAT_1 -> {
                dateFormat = "MMM dd yyyy";
            }

            case FORMAT_2 -> {
                dateFormat = "d/M/yyyy";
            }

            case FORMAT_3 -> {
                dateFormat = "dd-MMM-yyyy";
            }

            default -> {
                dateFormat = "yyyy-MM-dd";
            }
        }

        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month, day);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        System.out.println(formatter.format(fDate.getTime()));
    }

    public void printFormat() {
        printFormat(FormatDate.FORMAT_DEFAULT);
    }
}