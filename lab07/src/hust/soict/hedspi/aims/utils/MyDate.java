package hust.soict.hedspi.aims.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MyDate<arrDate> {
    public int day;
    public int month;
    public int year;
    ArrayList<String> tensNames = new ArrayList<>(Arrays.asList("hundred",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"));
    ArrayList<String> numNames = new ArrayList<>(Arrays.asList("",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"));
    ArrayList<String> monthName = new ArrayList<>(Arrays.asList("",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"));

    public void setDay(int day) {

        String month = "" + getMonth();
        String year = "" + getYear();
        String date = month + "/" + "1/" + year;
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
        convertedDate = convertedDate.withDayOfMonth(
                convertedDate.getMonth().length(convertedDate.isLeapYear()));
        int lastDayInMonth = convertedDate.getDayOfMonth();
        if (day < 1 || day > lastDayInMonth) {
            throw new ArithmeticException("Day in valid.");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new ArithmeticException("Month invalid. Month must in range 1 to 12");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new ArithmeticException("Year invalid. Year must great then 0");
        }
        this.year = year;
    }

    MyDate(int day, int month, int year) {
        setMonth(month);
        setYear(year);
        setDay(day);
    }

    //Input like a string
    MyDate(String date) throws ParseException {
        SimpleDateFormat formatter2 = new SimpleDateFormat("MMM dd yyyy");
//      format date2 from string
        Date date2 = formatter2.parse(date);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//        using Calendar to convert
        calendar.setTime(date2);
//        printf year - month- and day
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String monthFromInput = new SimpleDateFormat("M").format(calendar.getTime());
        int month = Integer.parseInt(monthFromInput);
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    //    Get current time
    public MyDate() throws ParseException {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        setYear(year);
        setMonth(month + 1);
        setDay(day);
    }

    //    Exercise lec4
    public MyDate(String day, String month, String year) throws Exception {
        String dayConvert = day.toLowerCase();
//        String monthConvert = month.toLowerCase();
        String yearConvert = year.toLowerCase();
        String[] daySplit = dayConvert.split(" ");
        String[] yearSplit = yearConvert.split(" ");
        int dozensDay = 0;
        int unitDay = 0;
        int year1, year2, year3, year4;
        int yearParse = 0;
//        Check month input right type
        int indexOfMonth = monthName.indexOf(month);
        if (
                indexOfMonth == -1
        ) {
            throw new Error("Month invalid type");
        }
//        get day
        if (daySplit.length > 1) {
            dozensDay = tensNames.indexOf(daySplit[0]);
            unitDay = numNames.indexOf(daySplit[1]);
            System.out.printf("%d %d\n", dozensDay, unitDay);
        } else {
//            check if day < 20
            if (!numNames.contains(daySplit[0])) {
                dozensDay = tensNames.indexOf(daySplit[0]);
            } else {
                unitDay = numNames.indexOf(daySplit[0]);
            }
        }
//        split year
//        first case: example twenty one twenty two
        if (yearSplit.length == 4) {
            year1 = tensNames.indexOf(yearSplit[0]);
            year2 = numNames.indexOf(yearSplit[1]);
            year3 = tensNames.indexOf(yearSplit[2]);
            year4 = numNames.indexOf(yearSplit[3]);
            System.out.printf("split year: %d %d %d %d\n", year1, year2, year3, year4);
            yearParse = year1 * 1000 + year2 * 100 + year3 * 10 + year4;
        } else if (yearSplit.length == 3) {
            /*
             * ten-num-ten(twenty one twenty)
             * ten-num-num(twenty one ten)
             * ten-ten-num(twenty twenty one)
             * num-ten-num*(year1 start from 10 -> 19, then we have: ten twenty one)/
             */
//            check year split [0] in num - or ten number
            year1 = tensNames.indexOf(yearSplit[0]);
            //year split[0] in tens name
            if (year1 != -1) {
                year2 = tensNames.indexOf(yearSplit[1]);
//                != -1 that's mean in ten name
                if (year2 != -1) {
//                    case: ten - ten - num
                    year3 = numNames.indexOf(yearSplit[2]);
                    yearParse = year1 * 1000 + year2 * 10 + year3;
                }
                //in this case we have t case minimum: ten- num-ten  or ten num num
                else {
                    year2 = numNames.indexOf(yearSplit[1]);
                    year3 = tensNames.indexOf(yearSplit[2]);
//                    1, ten- num-ten
                    if (year3 == -1) {
                        year3 = numNames.indexOf(yearSplit[2]);
                    }
                    yearParse = year1 * 1000 + year2 * 100 + year3;
                }
            }
//  last case: num - ten - num
            else {
                year1 = numNames.indexOf(yearSplit[0]);
                year2 = tensNames.indexOf(yearSplit[1]);
                year3 = numNames.indexOf(yearSplit[2]);
                yearParse = year1 * 100 + year2 * 10 + year3;
            }
        }
        /*
         *         last case: year length =2, have 4 case:
         *         num - num: thirteen fifteen (15 15)
         *         num-ten( thirteen twenty - 1320)
         *         ten-num(twenty thirteen)
         *         ten-ten(twenty twenty)
         * */
        else if (yearSplit.length == 2) {
            year1 = tensNames.indexOf(yearSplit[0]);
//            ten - num or ten ten
            if (year1 != -1) {
                year2 = tensNames.indexOf(yearSplit[1]);
//               if in ten - ten : twenty twenty
                if (year2 != -1) {
                    yearParse = year1 * 1000 + year2 * 10;
                }
                //                case ten - num
                else {
                    year2 = numNames.indexOf(yearSplit[1]);
                    yearParse = year1 * 100 + year2;
                }
            }
            //  num  num or num ten
            else {
                year1 = numNames.indexOf(yearSplit[0]);
                year2 = tensNames.indexOf(yearSplit[1]);
//                num - ten
                if (year2 != -1) {
                    yearParse = year1 * 100 + year2 * 10;
                }
//                num - num
                else {
                    year2 = numNames.indexOf(yearSplit[1]);
                    yearParse = year1 * 100 + year2;
                }
            }
        }
        int dayOutput = dozensDay * 10 + unitDay;
        setYear(yearParse);
        setMonth(indexOfMonth);
        setDay(dayOutput);
    }

    public String convertDay() {
        int day = getDay();
        String dayConvert = "";
        int remainderOfDay = day % 10;
        if (remainderOfDay == 1) {
            dayConvert = "" + day + "st";
        } else if (remainderOfDay == 2) {
            dayConvert = "" + day + "nd";
        } else if (remainderOfDay == 3) {
            dayConvert = "" + day + "rd";
        } else {
            dayConvert = "" + day + "th";
        }
        return dayConvert;
    }

    public String parseMonth() {
        int month = getMonth();
        String monthParse1 = monthName.get(month);
        String[] monthArray = monthParse1.split("");
        String monthReturn = "";
        for (int i = 0; i < 3; i++) {
            monthReturn += monthArray[i];
        }
        return monthReturn;
    }

    public void print() {
        int day = getDay();
        String dayConvert = convertDay();
        int month = getMonth();
        String monthParse = monthName.get(month);
        int year = getYear();
        System.out.printf("%s %s %d\n", monthParse, dayConvert, year);
    }

    public void printfHaveFormat() {
        System.out.println("SELECT FORMAT TO PRINTF");
        System.out.println("1.yyyy-MM-dd");
        System.out.println("2.d/M/yyyy");
        System.out.println("3.dd-MMM-yyyy");
        System.out.println("4.MMM d yyyy");
        System.out.println("5.mm-dd-yyyy");
        int day = getDay();

        int month = getMonth();

        int year = getYear();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the format you want");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                String dayParse = "";
                if (day < 10) {
                    dayParse = "0" + day + "";
                } else {
                    dayParse = day + "";
                }
                String monthParse = "";
                if (month < 10) {
                    monthParse = "0" + month + "";
                } else {
                    monthParse = "" + month;
                }
                System.out.println("1.yyyy-MM-dd");
                System.out.printf("%d-%s-%s\n", year, monthParse, dayParse);
                break;
            }
            case 2: {
                System.out.println("2.d/M/yyyy");
                System.out.printf("%d/%d/%d\n", day, month, year);
                break;
            }
            case 3: {
                String monthParse = parseMonth();
                String dayParse = "";
                if (day < 10) {
                    dayParse = "0" + day + "";
                } else {
                    dayParse = day + "";
                }
                System.out.println("3.dd-MMM-yyyy");
                System.out.printf("%s-%s-%d\n", dayParse, monthParse, year);
                break;
            }
            case 4: {
                String monthParse = parseMonth();
                System.out.println("4.MMM d yyyy");
                System.out.printf("%s %d %d", monthParse, day, year);
                break;
            }
            case 5: {
                String dayParse = "";
                if (day < 10) {
                    dayParse = "0" + day + "";
                } else {
                    dayParse = day + "";
                }
                String monthParse = "";
                if (month < 10) {
                    monthParse = "0" + month + "";
                } else {
                    monthParse = "" + month;
                }
                System.out.println("5.mm-dd-yyyy");
                System.out.printf("%s-%s-%d\n", monthParse, dayParse, year);
                break;
            }
            default:
                System.out.println("Your choice invalid. We will out now.");
        }
    }

    static String accept() {
        Scanner sc = new Scanner(System.in);
//       Get input is a string
        System.out.print("Enter string date you want to convert:");
        return sc.nextLine();

    }

    public static void main(String[] args) throws Exception {


//        String test = "December  18 2019";
////        Input is a string. Format of this is: month day year.  Example like test. MMM/DD/YYYY
//        String dateInputString = accept();
//        hust.soict.hedspi.aims.utils.MyDate inputString = new hust.soict.hedspi.aims.utils.MyDate(dateInputString);
////        printf value
//        System.out.println("Input is a string");
//        inputString.printf();
////        Input date is int value
//        System.out.println("-------------------------------------");
//        System.out.println("Input integer");
//        hust.soict.hedspi.aims.utils.MyDate dateInteger = new hust.soict.hedspi.aims.utils.MyDate(10, 10, 2020);
////        printf value when input is integer
//        dateInteger.printf();
////        Current date
//        hust.soict.hedspi.aims.utils.MyDate currentDate = new hust.soict.hedspi.aims.utils.MyDate();
//        System.out.println("-------------------------------------");
//        System.out.println("Current time");
//        currentDate.print();

        System.out.println("---------------");
        MyDate dateTest = new MyDate("one", "January", "thirteen one");
        System.out.println("---------------");
        MyDate currentDate = new MyDate();
        currentDate.print();
        currentDate.printfHaveFormat();
    }
}
