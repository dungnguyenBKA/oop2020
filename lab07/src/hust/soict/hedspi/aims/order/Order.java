package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void typeWantToAdd() {
        System.out.println("=============CHOICE TYPE YOU WANT TO ADD=============");
        System.out.println("1.Book");
        System.out.println("2.CD");
        System.out.println("3.DVD");
        System.out.println("4.Exit");
        System.out.printf("Your choice: ");
    }

    public void addAction() {
        Scanner inputChoice = new Scanner(System.in);
        int choice;
        do {
            typeWantToAdd();
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addCompactDisk();
                    break;
                case 3:
                    addDigitalVideoDisk();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }

    public void actionAfterAdd() {
        System.out.println("===============MENU AFTER ADD===============");
        System.out.println("1. Show detail that media");
        System.out.println("2. Exit");
        System.out.println("Your choice");
    }

    public void addBook() {
        Scanner inputTitle = new Scanner(System.in);
        Scanner inputNumbersAuthors = new Scanner(System.in);
        System.out.println("Input the title of book");
//        get input title for book
        String title = inputTitle.nextLine();
//        create book
        Book bookOutput = new Book(title);
        System.out.println("This book have how many authors");
        int numbersAuthors = inputNumbersAuthors.nextInt();
        for (int i = 0; i < numbersAuthors; i++) {
            Scanner inputAuthorName = new Scanner(System.in);
            System.out.printf("Name of author %d is:", i + 1);
            String authorName = inputAuthorName.nextLine();
            bookOutput.addAuthor(authorName);
        }

        int choice;
        do {
            actionAfterAdd();
            Scanner inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1: {
                    bookOutput.showDetailBook();
                    break;
                }
                case 2: {
                    break;
                }
                default:
                    break;
            }
        } while (choice != 2);
        this.addMedia(bookOutput);
    }

    public void addCompactDisk() {
        Scanner inputTitle = new Scanner(System.in);
        Scanner inputCategory = new Scanner(System.in);
        System.out.println("Title of this CD");
        String title = inputTitle.nextLine();
        System.out.println("Category of this CD");
        String category = inputCategory.nextLine();
        CompactDisc createDisk = new CompactDisc(title, category);
        Scanner inputNumbersTrack = new Scanner(System.in);
        System.out.println("Hove many track you want to add for this disk");
        int numberTracks = inputNumbersTrack.nextInt();
        System.out.println("========" + numberTracks);
        for (int i = 0; i < numberTracks; i++) {
            Scanner inputTitleTrack = new Scanner(System.in);
            Scanner inputLengthTrack = new Scanner(System.in);
            System.out.printf("Title of track %d:", i + 1);
            String titleTrack = inputTitleTrack.nextLine();
            System.out.printf("Length of track %d:", i + 1);
            int lengthOfTrack = inputLengthTrack.nextInt();
            Track newTrack = new Track(titleTrack, lengthOfTrack);
            createDisk.addTrack(newTrack);
        }
        int choice;
        do {
            actionAfterAdd();
            Scanner inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1: {
                    System.out.printf("The title of this Compact disk is %s, the category is %s\n", title, category);
                    createDisk.play();
                    break;
                }
                case 2: {
                    break;
                }
                default:
                    break;
            }
        } while (choice != 2);
        this.addMedia(createDisk);

    }

    public void addDigitalVideoDisk() {
        Scanner inputTitle = new Scanner(System.in);
        Scanner inputCategory = new Scanner(System.in);
        System.out.println("Title of this DVD");
        String title = inputTitle.nextLine();
        System.out.println("Category of this DVD");
        String category = inputCategory.nextLine();
        DigitalVideoDisc createDigitalVideoDisc = new DigitalVideoDisc(title, category);
        this.addMedia(createDigitalVideoDisc);
        int choice;
        do {
            actionAfterAdd();
            Scanner inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1: {
                    System.out.printf("The title of this Digital Video disc is %s, the category is %s\n", title, category);
                    createDigitalVideoDisc.play();
                    break;
                }
                case 2: {
                    break;
                }
                default:
                    break;
            }
        } while (choice != 2);
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
        if (itemsOrdered.size() != 0) {
            System.out.println("Show list media:");
            System.out.printf("ID %-20s %-20s\n", "Title", "Category");
            for (Media media : itemsOrdered) {
                String title = media.getTitle();
                String category = media.getCategory();
                if (category == null) {
                    category = "";
                }
                System.out.printf("%d %-20s %-20s\n", media.getId(), media.getTitle(), category);
            }
        }
        else {
            System.out.println("Don't have any data");
        }
    }

    public float totalCost() {
        float valueReturn = 0;
        for (Media media : itemsOrdered) {
            valueReturn += media.getCost();
        }
        return valueReturn;
    }
}
