package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    private int nOrders = 0;
    int totalAdded = 0;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media mediaAdd) {
        itemsOrdered.add(mediaAdd);
        System.out.println("Added this media to list");
        totalAdded++;
        mediaAdd.setId(totalAdded);
    }


    public void removeMedia(String title) {
        itemsOrdered.forEach(media -> {
            if (media.getTitle().equals(title)) {
                System.out.println("Deleted this media have title:" + title);
                itemsOrdered.remove(itemsOrdered.indexOf(title));
            }
        });
    }

    public void removeMedia(int id) {
        if (id > totalAdded || id < 1) {
            System.out.println("Invalid number");
            return;
        }
        totalAdded--;
        itemsOrdered.remove(id - 1);
    }

    public void showListMedia() {
        System.out.println("Show list media:");
        System.out.printf("ID %-20s %-20s\n", "Title", "Category");
        itemsOrdered.forEach(media -> {
            String title = media.getTitle();
            String category = media.getCategory();
            if (category == null){
                category= "";
            }
            System.out.printf("%d %-20s %-20s\n", media.getId(), media.getTitle(), category);
        });
    }
    public float totalCost() {
        float valueReturn = 0;
        for (Media media : itemsOrdered) {
            valueReturn += media.getCost();
        }
        return valueReturn;
    }
}
