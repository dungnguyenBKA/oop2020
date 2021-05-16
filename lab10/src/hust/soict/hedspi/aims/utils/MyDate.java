package hust.soict.hedspi.aims.utils;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {

	private int day;
	private int month;
	private int year;
	
	public static final String[] suffixes =
		     {"0th","1st",  "2nd",  "3rd",  "4th",  "5th",  "6th",  "7th",  "8th",  "9th",
		       "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th",
		       "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th",
		       "30th", "31st" };

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if (this.getMonth() == 2 && day > 0 && day < 30) 
			if (this.getYear()% 4 == 0 && this.getYear() % 100 != 0) this.day = day;
			else if (day < 29) this.day = day;
			else { 
				System.out.println("Loi gia tri Day");
				this.day = 0;
			}
		else if ((this.getMonth() == 4 ||this.getMonth() == 6 ||this.getMonth() == 9 ||this.getMonth() == 11) && day > 0 && day < 31) this.day = day;
		else if ((this.getMonth() == 1 ||this.getMonth() == 3 ||this.getMonth() == 5 ||this.getMonth() == 7||this.getMonth() == 8||this.getMonth() == 10||this.getMonth() == 12) && day > 0 && day < 32) this.day = day;
		else { 
			System.out.println("Loi gia tri Day");
			this.day = 0;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month < 1 || month >12 ) {
			System.out.println("Loi gia tri Month");
			this.month = 0;
		}
		else 
			this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if (year >= 0)
			this.year = year;
		else { 
			System.out.println("Loi gia tri Year");
			this.year = -1;
		}
	}
	public void printLocalDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println(MONTH_STRINGS[localDate.getMonthValue()]+ " "+ suffixes[localDate.getDayOfMonth()] + " " + localDate.getYear());
	}
	public void print() {
		if(this.getDay() == 0 || this.getMonth() == 0|| this.getYear() == -1)
			System.out.println("Loi gia tri ngay thang");
		else
			System.out.println(MONTH_STRINGS[this.getMonth()]+ " "+ suffixes[this.getDay()] + " " + this.getYear());
	}
	public MyDate() {
		LocalDate localDate = LocalDate.now();
		this.day = localDate.getDayOfMonth();
		this.month = localDate.getMonthValue();
		this.year = localDate.getYear();
	}
	public MyDate(int day, int month, int year) {
		 setYear(year);
		 setMonth(month);
		 setDay(day);
	}
	public void print(int key) {
//		Date date = new Date(getYear(),getMonth(),getDay());
		if(this.getDay() == 0 || this.getMonth() == 0|| this.getYear() == -1)
			System.out.println("Loi gia tri ngay thang");
		else {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, this.getYear());
			calendar.set(Calendar.MONTH, this.getMonth());
			calendar.set(Calendar.DATE, this.getDay());
			Date date = calendar.getTime();
			SimpleDateFormat simpleDateFormat;
			switch (key) {
			case 1:
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case 2:
				simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
				break;
			case 3:
				simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				break;
			case 4:
				simpleDateFormat = new SimpleDateFormat("MMM d yyyy");
				break;
			case 5:
				simpleDateFormat = new SimpleDateFormat("mm-dd-yyyy");
				break;
			default:
				simpleDateFormat = new SimpleDateFormat("MMMM dd yyyy");
				break;
			}
				
			System.out.println(simpleDateFormat.format(date));
		}
	}
	private int Find(String s, String[] str) {
		for (int i = 0 ; i < str.length ; i++)
			if (str[i].equals(s)) return i;
		return -1;
	}
	public static final String[] NUMBER_STRINGS= {
			"zero","one","two","three","four","five","six","seven",
		    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
		    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
		    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
		    "hundred","thousand","million","billion","trillion"
	};
	
	private int Convert(String[] out) {
		int[] a = new int[out.length];
		for(int i = 0 ; i < out.length ; i++) {
			a[i] = Find(out[i], NUMBER_STRINGS);
			if (a[i] == -1) return -1;
		}
		int b = 0;
		for(int i = out.length -1 ; i>=0 ; i--) 
			b += a[i] * ((int) Math.pow(10, out.length-i-1));		
		return b;		
	}
	
	public MyDate(String day, String month,String year) {
		String[] output = year.split(" ");
		if (output.length == 2) {
			String[] outStrings = output[0].split("-");
			String[] outStrings2 = output[1].split("-");
			if(outStrings.length <= 2 && outStrings2.length <= 2) {
				int a = Convert(outStrings);
				int b = Convert(outStrings2);
				this.setYear(a*100 + b);
			}
		}
		else 
			this.setYear(-1);

		this.setMonth(Find(month, MONTH_STRINGS));
		this.setDay(Find(day, DAY_STRINGS));		
	}
	public static final String[] MONTH_STRINGS = {
			"","January","February","March","April","May","June","July","August",
			"September","October","November","December"
	};
	public static final String[] DAY_STRINGS = {
			"zero","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth",
			"tenth","eleventh","twelfth","thirteenth","fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth",
			"twentieth","twenty-first","twenty-second","twenty-third","twenty-fourth","twenty-fifth","twenty-sixth","twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"
	};
	public MyDate(String str){
		 String[] output = str.split(" ");
		 int year = Integer.parseInt(output[2]);
		 int mon;
		 if (output[0].equals("January") || output[0].equals("Jan." )||output[0].equals("Jan") ) mon = 1;
	     else if( output[0].equals("February")|| output[0].equals("Feb.") ||output[0].equals("Feb") ) mon = 2;
	     else if( output[0].equals("March")|| output[0].equals("Mar." )||output[0].equals("Mar") ) mon = 3;
	     else if( output[0].equals("April")|| output[0].equals("Apr.") ||output[0].equals("Apr" )) mon = 4;
	     else if( output[0].equals("May")|| output[0].equals("May." )||output[0].equals("May" )) mon = 5;
	     else if( output[0].equals("June")|| output[0].equals("Jun." )||output[0].equals("Jun" )) mon = 6;
	     else if( output[0].equals("July")|| output[0].equals("Jul." )||output[0].equals("Jul" )) mon = 7;
	     else if( output[0].equals("August")|| output[0].equals("Aug.")||output[0].equals("Aug" )) mon = 8;
	     else if( output[0].equals("September")|| output[0].equals("Sep.") ||output[0].equals("Sep" )) mon = 9;
	     else if( output[0].equals("October")|| output[0].equals("Oct." )||output[0].equals("Oct" )) mon = 10;
	     else if( output[0].equals("November")|| output[0].equals("Nov." )||output[0].equals("Nov" )) mon = 11;
	     else if( output[0].equals("December")|| output[0].equals("Dec.")||output[0].equals("Dec" )) mon =12;
	     else mon = 0;
		 int i;
		 for (i = 0 ;i <suffixes.length ; i ++) {
			 if (output[1].equals(suffixes[i]))
				 break;
		 }
		 this.setYear(year);
		 this.setMonth(mon);
		 this.setDay(i);
	}
	public void accept() {
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.print("Moi ban nhap thang ngay nam: ");
		String strdate = scanner.nextLine();
		String[] output = strdate.split(" ");
		 int year = Integer.parseInt(output[2]);
		 int mon;
		 if (output[0].equals("January") || output[0].equals("Jan." )||output[0].equals("Jan") ) mon = 1;
	     else if( output[0].equals("February")|| output[0].equals("Feb.") ||output[0].equals("Feb") ) mon = 2;
	     else if( output[0].equals("March")|| output[0].equals("Mar." )||output[0].equals("Mar") ) mon = 3;
	     else if( output[0].equals("April")|| output[0].equals("Apr.") ||output[0].equals("Apr" )) mon = 4;
	     else if( output[0].equals("May")|| output[0].equals("May." )||output[0].equals("May" )) mon = 5;
	     else if( output[0].equals("June")|| output[0].equals("Jun." )||output[0].equals("Jun" )) mon = 6;
	     else if( output[0].equals("July")|| output[0].equals("Jul." )||output[0].equals("Jul" )) mon = 7;
	     else if( output[0].equals("August")|| output[0].equals("Aug.")||output[0].equals("Aug" )) mon = 8;
	     else if( output[0].equals("September")|| output[0].equals("Sep.") ||output[0].equals("Sep" )) mon = 9;
	     else if( output[0].equals("October")|| output[0].equals("Oct." )||output[0].equals("Oct" )) mon = 10;
	     else if( output[0].equals("November")|| output[0].equals("Nov." )||output[0].equals("Nov" )) mon = 11;
	     else if( output[0].equals("December")|| output[0].equals("Dec.")||output[0].equals("Dec" )) mon =12;
	     else mon = 0;
		 int i;
		 for (i = 0 ;i <suffixes.length ; i ++) {
			 if (output[1].equals(suffixes[i]))
				 break;
		 }
		 this.setYear(year);
		 this.setMonth(mon);
		 this.setDay(i);
		 
		}while(this.day == 0 || this.month == 0 );
		scanner.close();
	}
	
	
}
