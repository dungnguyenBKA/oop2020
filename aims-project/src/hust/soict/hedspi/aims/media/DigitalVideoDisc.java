package hust.soict.hedspi.aims.media;


import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable {


	public DigitalVideoDisc() { }

	public DigitalVideoDisc(int id,String title) {
		this.id = id;
		this.title = title;
	}

	public DigitalVideoDisc(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public DigitalVideoDisc(int id, String title, String category, String director) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.director = director;
	}

	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	public boolean search(String title) {
		@SuppressWarnings("resource")
		Scanner scanStr = new Scanner(title);
		String tmp;
		String lowerTitle = this.title.toLowerCase();
		while (scanStr.hasNext()) {
			tmp = scanStr.next().toLowerCase();
			if (!lowerTitle.contains(tmp))
				return false;
		}
		scanStr.close();
		return true;
	}

	public static DigitalVideoDisc getDisc(Scanner scan) {
		DigitalVideoDisc newDisc = new DigitalVideoDisc();
		String temp;
		System.out.println("Enter the title:  ");
		newDisc.setTitle(scan.nextLine());

		System.out.println("Enter the category: ");
		newDisc.setCategory(scan.nextLine());

		System.out.println("Enter the price: ");
		temp = scan.nextLine();
		try {
			if (!temp.isEmpty())
				newDisc.setCost(Float.parseFloat(temp));
		} catch (NumberFormatException e) {
			System.err.println("Error occurs.");
		}

		System.out.println("Enter the director name (enter to skip): ");
		temp = scan.nextLine();
		if (!temp.isEmpty())
			newDisc.setDirector(temp);

		System.out.println("Enter the lenght of disc (enter to skip): ");
		temp = scan.nextLine();
		try {
			if (!temp.isEmpty())
				newDisc.setLength(Integer.parseInt(temp));
		} catch (NumberFormatException e) {
			System.err.println("Error occurs.");
		}
		return newDisc;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	
	public int compareTo(Object obj) {
		if(!(obj instanceof DigitalVideoDisc)) {
			return super.compareTo(obj);
		}
		DigitalVideoDisc dvd = (DigitalVideoDisc) obj;
		if (this.getCost() - dvd.getCost() > 0)
			return 1;
		if (this.getCost() == dvd.getCost()) {
			return 0;
		}
		return -1;
	}

}
