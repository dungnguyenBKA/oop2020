import java.util.ArrayList;

public class Order {
    private static final int MAX_NUMBERS_ORDERED = 10;
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);

    public void addDigitalVideoDisc(DigitalVideoDisc  disc){
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(disc);
        } else {
            System.out.println("max limit reached");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc  disc){
        for (DigitalVideoDisc item : itemsOrdered) {
            if(item.getTitle().equals(disc.getTitle())) {
                itemsOrdered.remove(disc);
                return;
            }
        }
    }

    public float totalCost(){
        float total = 0;
        for (DigitalVideoDisc item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }
}
