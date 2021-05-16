package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class TestMediaCompareTo {

    public static void main(String[] args) {
        List<Media> collection = new ArrayList<Media>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Le bao hieu", 1,4);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tong Ngoc Anh", 1,1);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Lele", 3,3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Hieu Hieu", 4,4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Hieu Hieu", 4,5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Hieu Hieu", 4,6);

        collection.add(dvd4);
        collection.add(dvd5);
        collection.add(dvd6);
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);



        Iterator iterator = collection.iterator();
        System.out.println("--------------------------");
        System.out.println("The currently in the order are: ");
        while (iterator.hasNext()){
            ((DigitalVideoDisc)iterator.next()).play();
        }
        System.out.println("================");
//        Sort the collection of DVDs - based on the compareTo()
        Collections.sort(collection);
         iterator = collection.iterator();
        System.out.println("After using sort");
        while (iterator.hasNext()){
            ((DigitalVideoDisc)iterator.next()).play();
        }
    }
}
