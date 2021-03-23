import java.util.Arrays;
import java.util.Comparator;

public class DateUtils {
    public static int compareMyDate(MyDate date1, MyDate date2) {
        if (date1.getYear() > date2.getYear())
            return 1;
        else if (date1.getYear() < date2.getYear())
            return -1;
        else {
            if (date1.getMonth() > date2.getMonth())
                return 1;
            else if (date1.getMonth() < date2.getMonth())
                return -1;
            else {
                if (date1.getDay() > date2.getDay())
                    return 1;
                else if (date1.getDay() < date2.getDay())
                    return -1;
                else
                    return 0;
            }
        }
    }

    public static void sortMyDate(MyDate[] dateList) {
//        int n = dateList.length;
//        for (int i = 0; i < n - 1; i++)
//            for (int j = 0; j < n - i - 1; j++) {
//                if (compareMyDate(dateList[j], dateList[j + 1]) > 0) {
//                    //swap
//                    MyDate tmp = new MyDate();
//                    tmp.setDay(dateList[j].getDay());
//                    tmp.setMonth(dateList[j].getMonth());
//                    tmp.setYear(dateList[j].getYear());
//                    dateList[j].setDay(dateList[j + 1].getDay());
//                    dateList[j].setMonth(dateList[j + 1].getMonth());
//                    dateList[j].setYear(dateList[j + 1].getYear());
//                    dateList[j + 1].setDay(tmp.getDay());
//                    dateList[j + 1].setMonth(tmp.getMonth());
//                    dateList[j + 1].setYear(tmp.getYear());
//                }
//            }
        Arrays.sort(dateList, new Comparator<MyDate>() {
            @Override
            public int compare(MyDate o1, MyDate o2) {
                return compareMyDate(o1, o2);
            }
        });
    }

    public static void print(MyDate[] dateList) {
        int n = dateList.length;
        for (int i = 0; i < n; i++)
            dateList[i].print();
    }
}
