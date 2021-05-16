package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;

public class TestMediaCompareTo {
	public static void main(String[] args) {
//		ArrayList<Media> collection = new ArrayList<Media>();
		Book book1 = new Book("4", "Hoang4", "category", 15);
		Book book2 = new Book("2", "Hoang2", "category2", 16);
		Book book3 = new Book("3", "Hoang3", "category3", 17);
		
		Collection collection = new ArrayList();
		
		collection.add(book1);
		collection.add(book2);
		collection.add(book3);
		Iterator iterator = collection.iterator();
		System.out.println("-----------------------------");
		System.out.println("The Books currently in the order are: ");
		
		while (iterator.hasNext()) {
			System.out.println(((Book)iterator.next()).getTitle());
		}
		Collections.sort((ArrayList)collection);
		iterator = collection.iterator();
		System.out.println("-----------------------------");
		System.out.println("The Books in sorted order are: ");
		while (iterator.hasNext()) {
			System.out.println(((Book)iterator.next()).getTitle());
		}
		System.out.println("-----------------------------");
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("1", "title", "category", 14, 34, "hoang");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("2", "title2", "category2", 17, 34, "hoang");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("3", "title3", "category3", 16, 34, "hoang");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("4", "title4", "category4", 10, 34, "hoang");
		Collection collection2 = new ArrayList();
		collection2.add(dvd1);
		collection2.add(dvd2);
		collection2.add(dvd3);
		collection2.add(dvd4);
		iterator = collection2.iterator();
		System.out.println("-----------------------------");
		System.out.println("The DigitalVideoDisc currently in the order are: ");
		
		while (iterator.hasNext()) {
			DigitalVideoDisc dvd = (DigitalVideoDisc)iterator.next();
			System.out.println(dvd.getTitle() + "\t" + dvd.getCost());
		}
		Collections.sort((ArrayList)collection2);
		iterator = collection2.iterator();
		System.out.println("-----------------------------");
		System.out.println("The DigitalVideoDisc in sorted by cost order are: ");
		while (iterator.hasNext()) {
			DigitalVideoDisc dvd = (DigitalVideoDisc)iterator.next();
			System.out.println(dvd.getTitle() + "\t" + dvd.getCost());
		}
		System.out.println("-----------------------------");
		
		//Sort CD
		Track track = new Track("Hoang", 15);
		Track track1 = new Track("Hoang1", 15);
		Track track2 = new Track("Hoang2", 10);
		Track track5 = new Track("Hoang3", 15);
		
		CompactDisc cd1 = new CompactDisc("1", "title1", "category1", 14, "Hoang", "Hieu");
		cd1.addTrack(track5);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("2", "title2", "category1", 14, "Hoang", "Hieu");
		cd2.addTrack(track5);
		CompactDisc cd3 = new CompactDisc("3", "title3", "category1", 14, "Hoang", "Hieu");
		cd3.addTrack(track5);
		cd3.addTrack(track1);
		CompactDisc cd4 = new CompactDisc("4", "title4", "category1", 14, "Hoang", "Hieu");
		cd4.addTrack(track);
		cd4.addTrack(track1);
		cd4.addTrack(track5);
		cd4.addTrack(track2);
		Collection collection3 = new ArrayList();
		collection3.add(cd1);
		collection3.add(cd2);
		collection3.add(cd3);
		collection3.add(cd4);
		iterator = collection3.iterator();
		System.out.println("-----------------------------");
		System.out.println("The CompactDisc currently in the order are: ");
		
		while (iterator.hasNext()) {
			CompactDisc cd = (CompactDisc)iterator.next();
			System.out.println(cd.getTitle() + "\t" + cd.getLength()+ "\t" + cd.numberTracks());
		}
		Collections.sort((ArrayList)collection3);
		iterator = collection3.iterator();
		System.out.println("-----------------------------");
		System.out.println("The CompactDisc in sorted by number of track , length order are: ");
		while (iterator.hasNext()) {
			CompactDisc cd = (CompactDisc)iterator.next();
			System.out.println(cd.getTitle() + "\t" + cd.getLength()+ "\t" + cd.numberTracks());
		}
		System.out.println("-----------------------------");
		
		// test content book
//		book1.setContentString("As he took up office, "
//				+ "Trump immediately managed to hobble Obamacare – one of the biggest "
//				+ "achievements of his previous, President Obama. The action made public opinion "
//				+ "break out, and people not only in the USA but also in the world called him the "
//				+ "cruel guy. Obamacare was an act that make health insurance available for US citizens, "
//				+ "especially the poor, and its official name of the law is the Affordable Care Act. "
//				+ "However, President Trump considered this act completely the opposite with one of "
//				+ "important American values, independence, which means that the America, regardless "
//				+ "of the rich of the poor, must be self-reliant and depends on no one to feed and "
//				+ "finance them. As a result, he got rid of this law and was strongly censured.");
//		
//		System.out.println(book1);
		
	}
}
