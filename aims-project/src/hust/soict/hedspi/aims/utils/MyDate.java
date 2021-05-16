package hust.soict.hedspi.aims.utils;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
	private int Day;
	private int Month; // Calendar using 0-11 month while LocalTime is 1-12
	private int Year;

	public MyDate() {
		Calendar curDate = Calendar.getInstance();
		this.Day = curDate.get(Calendar.DAY_OF_MONTH);
		this.Month = curDate.get(Calendar.MONTH);
		this.Year = curDate.get(Calendar.YEAR);
	}

	public MyDate(int day, int month, int year) {
		Calendar ThisDate = Calendar.getInstance();
		ThisDate.set(year, month - 1, 1);
		if (day < 1 || day > ThisDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { // getActualMaximum to get the last day
																					// of month
			System.out.println("Not a valid date.");
			return;
		}

		this.Day = day;
		this.Month = month - 1;
		this.Year = year;
	}

	public MyDate(String day, String month, String year) {
		String[] strDay = { "zero", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth",
				"ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth",
				"seventeenth", "eighteenth", "nineteenth", "twentieth", "twenty-first", "twenty-second", "twenty-third",
				"twenty-fourth", "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth",
				"thirtieth", "thirty-first" };
		String[] strMonth = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] strYear = { "twenty fifteen", "twenty sixteen", "twenty seventeen", "twenty eighteen",
				"twenty nineteen", "twenty twenty", "twenty twenty one", "twenty twenty two", "twenty twenty three",
				"twenty twenty four", "twenty twenty five" };
		for (int i = 0; i <= 31; i++) {
			if (strDay[i].equals(day))
				this.Day = i;
		}
		for (int i = 0; i < 12; i++) {
			if (strMonth[i].equals(month))
				this.Month = i;
		}
		for (int i = 0; i <= 10; i++) {
			if (strYear[i].equals(year)) {
				this.Year = i + 2015;
			}
		}
	}

	public MyDate(String Date) {
		String dateFormat = "MMMMM dd yyyy";
		Date InputDate;
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Calendar ThisDate = Calendar.getInstance();
		formatter.setLenient(false);
		try {
			if (Date.contains("1st"))
				InputDate = formatter.parse((Date.replaceAll("st", "")).trim());
			else if (Date.contains("2nd"))
				InputDate = formatter.parse((Date.replaceAll("nd", "")).trim());
			else if (Date.contains("3rd"))
				InputDate = formatter.parse((Date.replaceAll("rd", "")).trim());
			else
				InputDate = formatter.parse((Date.replaceAll("th", "")).trim()); // replaceAll(): replace all
																					// st|nd|rd|th = ""
			// trim() to remove blank before and after the str
		} catch (ParseException pe) {
			System.out.println("Not a valid date or wrong format.");
			return;
		}

		ThisDate.setTime(InputDate);
		this.Day = ThisDate.get(Calendar.DAY_OF_MONTH);
		this.Month = ThisDate.get(Calendar.MONTH);
		this.Year = ThisDate.get(Calendar.YEAR);
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Calendar ThisDate = Calendar.getInstance();
		ThisDate.set(Year, Month, 1); // set the time
		if (day < 1 || day > ThisDate.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			System.out.println("Not a valid day.");
			return;
		}

		this.Day = day;
	}

	public int getMonth() {
		return Month + 1;
	}

	public void setMonth(int month) {
		Calendar ThisDate = Calendar.getInstance();
		ThisDate.set(Year, month - 1, 1);
		if (Day > ThisDate.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			System.out.println("Not a valid month.");
			return;
		}

		this.Month = month - 1;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Calendar ThisDate = Calendar.getInstance();
		ThisDate.set(year, Month, 1);
		if (Day > ThisDate.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			System.out.println("Not a valid year.");
			return;
		}

		this.Year = year;
	}

	public void accept() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a date: ");
		String strDate = keyboard.nextLine();
		String dateFormat = "MMMMM dd yyyy";
		Date InputDate;
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Calendar ThisDate = Calendar.getInstance();
		formatter.setLenient(false);
		try {
			InputDate = formatter.parse((strDate.replaceAll("st|nd|rd|th", "")).trim());
		} catch (ParseException pe) {
			System.out.println("Invalid date or format");
			keyboard.close();
			return;
		}

		ThisDate.setTime(InputDate);
		this.Day = ThisDate.get(Calendar.DAY_OF_MONTH);
		this.Month = ThisDate.get(Calendar.MONTH);
		this.Year = ThisDate.get(Calendar.YEAR);

		System.out.println("Updated sucessfully");
		print();
		keyboard.close();
	}

//	public void print() {
//		System.out.printf("%02d/%02d/%4d\n", Day, Month + 1, Year); // Month is less than real month 1 point because of
//																	// Calendar
//																	// %02d mean that if only 1 digit, the other will be
//																	// filled with 0
//	}

	public void print() {
		Calendar fDate = Calendar.getInstance();
		fDate.set(Year, Month, Day);
		String dateFormat;

		switch (Day) {
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

	public void printFormat() {
		Calendar fDate = Calendar.getInstance();
		fDate.set(Year, Month, Day);
		String dateFormat;
		int opt;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please choose the optional date format; ");
		System.out.println("1. yyyy-MM-dd");
		System.out.println("2. d/M/yyyy");
		System.out.println("3. dd-MMM-yyyy");
		System.out.println("4. MMM d yyyy");
		System.out.println("5. mm-dd-yyyy");
		opt = keyboard.nextInt();

		switch (opt) {
		case 1:
			dateFormat = "yyyy-MM-dd";
			break;
		case 2:
			dateFormat = "d/M/yyyy";
			break;
		case 3:
			dateFormat = "dd-MMM-yyyy";
			break;
		case 4:
			dateFormat = "MMM d yyyy";
			break;
		case 5:
			dateFormat = "MM-dd-yyyy";
			break;
		default:
			dateFormat = "MMMMM dd yyyy";
			break;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		System.out.println(formatter.format(fDate.getTime()));
		keyboard.close();

	}
}
