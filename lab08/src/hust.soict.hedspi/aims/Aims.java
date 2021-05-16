package hust.soict.hedspi.aims;

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
        Order order = null;
        int checkCreatedOrder = 0;
        do {
            aimsLec6.showMenu();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = input.nextInt();
            System.out.print("=============\n");
            switch (choice) {
                case 0:
                    System.out.println("Program end in ...");
                    break;
                case 1:
                    if (checkCreatedOrder == 0) {
                        order = new Order();
                        System.out.println("Create new order successful");
                        checkCreatedOrder = 1;
                    } else {
                        System.out.println("Order created");
                    }

                    break;
                case 2:
                    if (checkCreatedOrder == 0) {
                        System.out.println("You must create order");
                        break;
                    }
                    order.addAction();
                    break;
                case 3:
                    if (checkCreatedOrder == 0) {
                        System.out.println("You must create order");
                        break;
                    }
                    Scanner idDelete = new Scanner(System.in);
                    System.out.println("Enter id you want to delete");
                    int id = idDelete.nextInt();
                    order.removeMedia(id);
                    break;
                case 4:
                    if (checkCreatedOrder == 0) {
                        System.out.println("You must create order");
                        break;
                    }
                    order.showListMedia();
                    break;
                default:
                    System.out.println("Your choice invalid.");
                    break;
            }
        } while (choice != 0);
    }
}
