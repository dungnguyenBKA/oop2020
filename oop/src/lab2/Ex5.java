package lab2;

public class Ex5 {
    public static void main(String[] args) {
        numbersOfDay("Jun", 2020);
    }

    public static void numbersOfDay(String month, int year) {
        if (year < 0) {
            System.out.println("Invalid Year");
            return;
        }

        boolean isLeafYear = false;
        if(year % 4 == 0) isLeafYear = true;
        if(year % 100 == 0 && year % 400 != 0) isLeafYear = false;

        int dayNum = 0;
        switch (month) {
            case "January", "Jan", "Jan.", "March", "Mar.", "Mar", "May", "July", "Jul", "August", "Aug.", "Aug", "October", "Oct.", "Oct", "December", "Dec.", "Dec", "1", "3", "5", "7", "8", "10", "12" -> {
                dayNum = 31;
            }
            case "June", "Jun", "April", "Apr.", "Apr", "September", "Sept.", "Sep", "November", "Nov.", "Nov", "4", "6", "9", "11" -> {
                dayNum = 30;
            }
            case "February", "Feb.", "Feb", "2" -> {
                if (isLeafYear) {
                    dayNum = 29;
                } else {
                    dayNum = 28;
                }
            }
        }

        System.out.println("Number of day: " + dayNum);
    }
}
