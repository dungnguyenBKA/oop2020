package hust.soict.hedspi.aims.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtils {
    public int compare(MyDate d1, MyDate d2) {
        int dayD1 = d1.getDay();
        int dayD2 = d2.getDay();
        int monthD1 = d1.getMonth();
        int monthD2 = d2.getMonth();
        int yearD1 = d1.getYear();
        int yearD2 = d2.getYear();
        if (yearD1 > yearD2) {
            return 1;
        } else if (yearD1 < yearD2) {
            return -1;
        } else {
            if (monthD1 > monthD1) {
                return 1;
            } else if (monthD1 < monthD2) {
                return -1;
            } else {
                if (dayD1 > dayD2) {
                    return 1;
                } else if (dayD1 < dayD2) {
                    return -1;
                }
            }
        }
        return 0;
    }

    MyDate[] deleteElementInPosition(MyDate[] arrayDate, int position) {
        for (int i = position; i < arrayDate.length - 1; i++) {
            arrayDate[i] = arrayDate[i + 1];
        }
        return arrayDate;
    }

    void sortArrayDateTest(MyDate[] arrayNeedSort) throws Exception {
        DateUtils test1 = new DateUtils();
        int valueTest = test1.sortArrayDate(arrayNeedSort);
        assertEquals(1, valueTest);
    }

    public static void swap2(MyDate date1, MyDate date2) {
        int day2 = date2.getDay();
        int month2 = date2.getMonth();
        int year2 = date2.getYear();
//        swap
        date1.setDay(day2);
        date1.setMonth(month2);
        date1.setYear(year2);


    }

    /// max to min
    public int sortArrayDate(MyDate[] arrayDate) throws Exception {
        MyDate tmp = new MyDate(arrayDate[0].getDay(), arrayDate[0].getMonth(), arrayDate[0].getYear());
        for (int i = 0; i < arrayDate.length - 1; i++) {
            for (int j = i + 1; j < arrayDate.length; j++) {
                if (compare(arrayDate[i], arrayDate[j]) == -1) {
//                    1st way
//                    tmp = arrayDate[j];
//                    arrayDate[j] = arrayDate[i];
//                    arrayDate[i] = tmp;
//                    2nd way
                    swap2(tmp, arrayDate[j]);
                    swap2(arrayDate[j], arrayDate[i]);
                    swap2(arrayDate[i], tmp);
                }
            }
        }
        System.out.println("------------");
        for (int i = 0; i < arrayDate.length - 1; i++) {
            if (compare(arrayDate[i], arrayDate[i + 1]) == -1) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        DateUtils test1 = new DateUtils();
        MyDate dateTest = new MyDate("one", "January", "thirteen one");
        MyDate dateTest2 = new MyDate("two", "January", "thirteen one");
        MyDate dateTest3 = new MyDate("two", "January", "thirteen one");
        MyDate dateTest4 = new MyDate("four", "February", "thirteen two");
        MyDate currentDate = new MyDate();
        int x1 = test1.compare(dateTest, currentDate);
        if (x1 == 1) {
            System.out.println("D1 = D2");
        }
        if (x1 == -1) {
            System.out.println("D1<d2");
        } else {
            System.out.println("D1>D2");
        }
        MyDate[] arrayNeedSort = {dateTest, currentDate, dateTest2, dateTest3, dateTest4};
        test1.sortArrayDateTest(arrayNeedSort);
        test1.sortArrayDate(arrayNeedSort);
        for (int i = 0; i < arrayNeedSort.length; i++) {
            arrayNeedSort[i].print();
        }
    }
}
