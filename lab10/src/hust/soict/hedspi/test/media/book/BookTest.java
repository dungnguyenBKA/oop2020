package hust.soict.hedspi.test.media.book;

import hust.soict.hedspi.aims.media.book.Book;

public class BookTest {
	public static void main(String[] args) {
		Book book1 = new Book("4", "Hoang4", "category", 15);
		book1.setContentString("As he took up office, "
				+ "Trump immediately managed to hobble Obamacare – one of the biggest "
				+ "achievements of his previous, President Obama. The action made public opinion "
				+ "break out, and people not only in the USA but also in the world called him the "
				+ "cruel guy. Obamacare was an act that make health insurance available for US citizens, "
				+ "especially the poor, and its official name of the law is the Affordable Care Act. "
				+ "However, President Trump considered this act completely the opposite with one of "
				+ "important American values, independence, which means that the America, regardless "
				+ "of the rich of the poor, must be self-reliant and depends on no one to feed and "
				+ "finance them. As a result, he got rid of this law and was strongly censured.");
		
		System.out.println(book1);
		book1.setContentString("Dai hoc Back Khoa Ha Noi");
		System.out.println(book1);
	}
}
