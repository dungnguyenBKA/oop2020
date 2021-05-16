package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class TestMediaCompareTo{
	@SuppressWarnings("unchecked")
	public static void main() {
		Collection<Media> medias = new ArrayList<Media>();
		DigitalVideoDisc a1 = new DigitalVideoDisc(12, "FunnyA");
		DigitalVideoDisc a2 = new DigitalVideoDisc(13, "FunnyB");
		DigitalVideoDisc a3 = new DigitalVideoDisc(14, "FunnyC");
		medias.add(a1);
		medias.add(a2);
		medias.add(a3);
		
		Iterator<Media> iterator = medias.iterator();
		 System.out.println("-------");
		 System.out.println("Current order:");
		 
		 while(iterator.hasNext()) {
			 System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		 }
		 
		 Collections.sort((ArrayList<Media>)medias);
		 iterator = medias.iterator();
		 
		 System.out.println("-------");
		 System.out.println("Sorted order:");
		 
		 while(iterator.hasNext()) {
			 System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		 }
		 
		 System.out.println("-------");
	}
}
