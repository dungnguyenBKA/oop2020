package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsTest {

    @org.junit.jupiter.api.Test
    void sortArrayDate() throws Exception {
        DateUtils test1 = new DateUtils();
        MyDate dateTest = new MyDate("one", "January", "thirteen one");
        MyDate dateTest2 = new MyDate("two", "January", "thirteen one");
        MyDate dateTest3 = new MyDate("two", "January", "thirteen one");
        MyDate dateTest4 = new MyDate("four", "February", "thirteen two");
        MyDate currentDate = new MyDate();
        MyDate[] arrayNeedSort = {dateTest, currentDate, dateTest2, dateTest3, dateTest4};
        int valueTest = test1.sortArrayDate(arrayNeedSort);
        assertEquals(1, valueTest);
    }
}