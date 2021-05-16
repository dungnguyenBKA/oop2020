package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.ScannerUtils;
import hust.soict.hedspi.aims.order.Order;

public class Aims {

    static int choice;
    static int type = 0;
    static int n = 0;
    static int itemId = 0;
    static Scanner keyboard = new Scanner(System.in);
    static Order[] orderList = new Order[Order.MAX_LIMITTED_ORDERS];

    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("________________________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("________________________________");
        System.out.println("Please choose a number:");
    }

    public static void main(String[] args) {
        try {
            do {
                showMenu();

                try {
                    choice = ScannerUtils.nextInt(0, 4, keyboard);;
                } catch (Exception e) {
                    choice = 0;
                    System.out.println("Sorry sir, some bugs spotted!!, exit program...");
                }

                System.out.println("Choice: " + choice);
                switch (choice) {
                    case 1:
                        createOrder();
                        break;
                    case 2:
                        addItem();
                        break;
                    case 3:
                        deleteItemByID();
                        break;
                    case 4:
                        showItemsOfOrder();
                        break;
                    default:
                        break;
                }
            } while (choice != 0);

            keyboard.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createOrder() {
        orderList[n++] = Order.getInstanceOrder();
        System.out.println("Order created.");
    }

    public static void addItem() {
        if (Order.checkOrders())
            return; // if empty, exit
        int orderId;
        System.out.println("Choose order id: ");

        orderId = ScannerUtils.nextInt(1, Order.size(), keyboard);

        System.out.println("1. Digital Video Disc.");
        System.out.println("2. Book.");
        System.out.println("3. Compact Disc");
        System.out.println("Choose type of media to add: ");
        type = ScannerUtils.nextInt(1, 3, keyboard);


        orderList[orderId - 1].addMedia(type, keyboard);
        System.out.println("Add successful");
    }

    public static void deleteItemByID() {
        if (Order.checkOrders())
            return;
        int orderId;
        System.out.println("Choose order id: ");
        orderId = ScannerUtils.nextInt(1, Order.size(), keyboard);

        if (orderId == 0)
            return; // we set 0 as exit id

        if (orderList[orderId - 1].listSize() == 0) {
            System.out.println("Order is empty. Nothing to delete.");
            return;
        }

        orderList[orderId - 1].printOrdered();

        System.out.println("Choose the item you want to delete: ");
        itemId = ScannerUtils.nextInt(1, orderList[orderId - 1].listSize(), keyboard);

        orderList[orderId - 1].removeMedia(itemId - 1);
        System.out.println("Delete successful.");
    }

    public static void showItemsOfOrder() {
        if (Order.checkOrders())
            return;
        int orderId;

        System.out.println("Choose order id: ");
        orderId = ScannerUtils.nextInt(1, Order.size(), keyboard);
        if (orderId == 0)
            return;

        orderList[orderId - 1].printOrdered();
    }
}
