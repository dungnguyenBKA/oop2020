package hust.soict.hedspi.aims.utils;

public class DateUtils {
	
	public static int CompareDate(MyDate data1, MyDate data2) {
		if(data1.getYear() > data2.getYear())
			return 1;
		else if(data1.getYear() == data2.getYear())
			if(data1.getMonth() > data2.getMonth())
				return 1;
			else if(data1.getMonth() ==  data2.getMonth())
				if(data1.getDay() > data2.getDay())
					return 1;
				else if (data1.getDay() == data2.getDay())
					return 0;
				else 
					return -1;
			else 
				return -1;
		else 
			return -1;
	}
	
	public static void SortDate(MyDate[] mydate) {
		for(int i = 0 ; i< mydate.length -1 ; i++) 
			for(int j = i+1; j < mydate.length ; j++) {
				if(CompareDate(mydate[i], mydate[j])==1) {
					MyDate tmp = mydate[i];
					mydate[i] = mydate[j];
					mydate[j] = tmp;
				}		
			}
	}

}
