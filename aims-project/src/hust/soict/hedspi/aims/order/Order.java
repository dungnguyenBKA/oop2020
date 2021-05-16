package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	public static int MAX_LIMITTED_ORDERS = 5;
	public static final int MAX_NUMBERS_ORDERED = 10;

	private static int nbOrders = 0;
	private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    private final MyDate dateOrdered;

	private Order() {
		dateOrdered = new MyDate();
	}

	public static Order getInstanceOrder() {
		if (nbOrders < MAX_LIMITTED_ORDERS) {
			nbOrders++;
			return new Order();
		} else {
			System.out.println("The numbers of orders reached limit (5) .");
			return null;
		}
	}

	public int listSize() {
		return itemsOrdered.size();
	}

	public static int size() {
		return nbOrders;
	}

	public void addMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("Added Items " + media.getTitle());
        } else {
			System.out.println("Order is full or Items already added.");
        }
	}

	public void addMedia(int type, Scanner keyboard) {
	
		int numberOfTracks;
		int printOrNot;

		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("Order is full. Cannot add more.");
			extracted();
		}
		
		switch (type)
		{
		case 1:
			DigitalVideoDisc newDisc = DigitalVideoDisc.getDisc(keyboard);
			itemsOrdered.add(newDisc);
			break;
		case 2:
			Book newBook = Book.getBook(keyboard);
			itemsOrdered.add(newBook);
			break;
		case 3:
			CompactDisc newCompactDisc = CompactDisc.getCD(keyboard);
			itemsOrdered.add(newCompactDisc);
			System.out.println("Enter number of track to add: ");
			numberOfTracks = keyboard.nextInt();
			Track tmp = new Track();
			for(int i = 0; i < numberOfTracks; i++) {
				newCompactDisc.addTrack(tmp);
				System.out.println("Do you wish to play this track (1/0): ");
				printOrNot = keyboard.nextInt();
				if (printOrNot == 1) {
					tmp.play();
				}
			}
		}
	}

	private void extracted() {
	}

	public void removeMedia(int index) {
		if (itemsOrdered.size() <= 0) {
			System.out.println("Empty!!");
			extracted();
		}
		if (index < itemsOrdered.size())
			itemsOrdered.remove(index);
	}

	public float totalCost() {
        float ttCost = 0;
		Media mediaItem;
        for (Media media : itemsOrdered) {
            mediaItem = media;
            ttCost += mediaItem.getCost();
        }
		return ttCost;
	}

	public void printOrdered() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.print("\nOrdered Items:\n");

		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.printf("Item num%s", i + 1);
			itemsOrdered.get(i).print();
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("***************************************************");
	}

    // check if it is empty and print order
	public static boolean checkOrders() {
		if (nbOrders == 0) {
			System.out.println("None order found.");
			return true;
		}
		System.out.println("Order list: ");
		for (int i = 0; i < nbOrders; i++)
			System.out.printf("Order %d\n", i + 1);
		return false;
	}

}