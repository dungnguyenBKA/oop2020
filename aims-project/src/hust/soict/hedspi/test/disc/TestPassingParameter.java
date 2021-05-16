package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DVDwrapper;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella");

		DVDwrapper o1 = new DVDwrapper(jungleDVD); 
		DVDwrapper o2 = new DVDwrapper(cinderellaDVD);
		swap(o1, o2);
		System.out.println("jungle dvd title: " + o1.c.getTitle());
		System.out.println("cinderella dvd title: " + o2.c.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}



	public static void swap(DVDwrapper o1, DVDwrapper o2) {
		DigitalVideoDisc tmp = o1.c;
		o1.c = o2.c;
		o2.c = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		int id = dvd.getId();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(id, oldTitle);
	}

}
