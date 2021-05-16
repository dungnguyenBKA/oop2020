package hust.soict.hedspi.test.utils;
import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DataTest {
	 public static void main(String[] args) {
//	        MyDate aDate = new MyDate("february 18th 2019");
//	        aDate.print();
//	        aDate.setMonth(2);
//	        aDate.setDay(29); //not leap year => not valid
//	        aDate.setYear(2100);
//	        aDate.accept(); //Include print
//	        System.out.println(aDate.getDay()+"/"+aDate.getMonth()+"/"+aDate.getYear()); //Test get methods
		 	MyDate Date1 = new MyDate("first","February","twenty nineteen");
	        MyDate Date2 = new MyDate("first","February","twenty twenty");
	        MyDate[] dateList = {Date2,Date1};
	        Date1.print();
	        Date2.print();
	        System.out.printf("Date1 vs Date2 is: %d\n", DateUtils.compareMyDate(Date1, Date2));
	        System.out.println("Before sorting");
	        DateUtils.print(dateList);
	        DateUtils.sortMyDate(dateList);
	        System.out.println("After sorting");
	        DateUtils.print(dateList);
	 }
}
