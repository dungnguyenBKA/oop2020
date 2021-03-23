public class DataTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate("third", "June", "twenty sixteen");
        MyDate date2 = new MyDate("twenty-sixth", "December", "twenty seventeen");
        MyDate date3 = new MyDate("twenty-sixth", "December", "twenty nineteen");
        MyDate myDate = new MyDate("first", "January", "nineteen nineteen");
        myDate.printFormat(MyDate.FormatDate.FORMAT_1);

        MyDate[] dateList = { date1, date3, date2, myDate};
        System.out.print("Before: \n");
        DateUtils.print(dateList);
        DateUtils.sortMyDate(dateList);
        System.out.print("After: \n");
        DateUtils.print(dateList);
    }
}
