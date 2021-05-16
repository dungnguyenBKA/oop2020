package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
    public void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void main(String[] args) {
        int choice;
        Aims aimsLec6 = new Aims();
        Order orderLec6 = null;
        int checkCreatedOrder = 0;
        do {
            aimsLec6.showMenu();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Program end in ...");
                    break;
                case 1:
                    orderLec6 = new Order();
                    System.out.println("Create new order successfull");
                    checkCreatedOrder = 1;
                    break;
                case 2:
                    if (checkCreatedOrder == 0) {
                        System.out.println("You must create order");
                        break;
                    }
                    System.out.println("Enter the title of disc/book you want to add to order");
                    Scanner readTitle = new Scanner(System.in);
                    String title = readTitle.nextLine();
                    System.out.println("Enter the  category you want to add to order");
                    Scanner readCategory = new Scanner(System.in);
                    String category = readCategory.nextLine();
                    Media itemToAdd;
                    if (category.equals("")) {
                        itemToAdd = new Media(title);
                    } else {
                        itemToAdd = new Media(title, category);
                    }
                    orderLec6.addMedia(itemToAdd);
                    break;
                case 3:
                    Scanner idDelete = new Scanner(System.in);
                    System.out.println("Enter id you want to delete");
                    int id = idDelete.nextInt();
                    orderLec6.removeMedia(id);
                    break;
                case 4:
                    orderLec6.showListMedia();
                    break;
                default:
                    System.out.println("Your choice invalid.");
                    break;
            }
        } while (choice != 0);
    }
}
