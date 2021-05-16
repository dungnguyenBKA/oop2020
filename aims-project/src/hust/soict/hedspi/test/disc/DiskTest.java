package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;


public class DiskTest {
    public static void main(String[] args) {
        Order anOrder = Order.getInstanceOrder();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);      
        anOrder.addMedia(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);
        anOrder.addMedia(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);
       anOrder.addMedia(dvd3);
        
        System.out.print("Total cost is: ");
        System.out.println(anOrder.totalCost()); 
        
//        MyDate ADate = new MyDate();
//        ADate.accept();
//        anOrder.printOrdered();
        
        System.out.println(dvd1.search("King Power"));
        System.out.println(dvd1.search("Aladdin King"));
        System.out.println(dvd1.search("King Lion"));
        System.out.println(dvd1.search("King King"));
        
    }

}
