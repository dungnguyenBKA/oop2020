package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;
import hust.soict.hedspi.aims.order.Order;

import java.util.*;

public class Aims {
    public static Order anOrder;

    public static float getTotalCostNeed() {
        return totalCostNeed;
    }

    public static void setTotalCostNeed(float totalCostNeed) {
        Aims.totalCostNeed = totalCostNeed;
    }

    private static float totalCostNeed;

    public static void main(String[] args) throws PlayerException {
//		MemoryDaemon memoryDaemon = new MemoryDaemon();
//		Thread thread = new Thread(memoryDaemon);
//		thread.start();
// Test CompareTo
        testCompareTo();
        showMenu();

    }

    public final static double probabilityOfLuck = 0.5;

    public static void testCompareTo() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("1", "dvd1", "category", 14, 34, "hoang");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("2", "dvd2", "category2", 17, 34, "hoang");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("3", "dvd3", "category3", 16, 34, "hoang");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("4", "dvd4", "category4", 10, 34, "hoang");
        Collection collection2 = new ArrayList();
        collection2.add(dvd1);
        collection2.add(dvd2);
        collection2.add(dvd3);
        collection2.add(dvd4);
        Track track = new Track("Hoang", 15);
        Track track1 = new Track("Hoang1", 15);
        Track track2 = new Track("Hoang2", 10);
        Track track5 = new Track("Hoang3", 15);

        CompactDisc cd1 = new CompactDisc("5", "cd1", "category1", 14, "Hoang", "Hieu");
        cd1.addTrack(track5);
        cd1.addTrack(track2);
        CompactDisc cd2 = new CompactDisc("6", "cd2", "category1", 14, "Hoang", "Hieu");
        cd2.addTrack(track5);
        CompactDisc cd3 = new CompactDisc("7", "cd3", "category1", 14, "Hoang", "Hieu");
        cd3.addTrack(track5);
        cd3.addTrack(track1);
        CompactDisc cd4 = new CompactDisc("8", "cd4", "category1", 14, "Hoang", "Hieu");
        cd4.addTrack(track);
        cd4.addTrack(track1);
        cd4.addTrack(track5);
        cd4.addTrack(track2);
        collection2.add(cd1);
        collection2.add(cd2);
        collection2.add(cd3);
        collection2.add(cd4);
        Iterator iterator = collection2.iterator();
        System.out.println("-----------------------------");
        System.out.println("The Media currently in the order are: ");

        while (iterator.hasNext()) {
            Media media = (Media) iterator.next();
            if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                System.out.println(cd.getTitle() + "\t" + cd.getLength() + "\t" + cd.numberTracks());
            } else {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                System.out.println(dvd.getTitle() + "\t" + dvd.getCost());
            }
        }
        Collections.sort((ArrayList) collection2);
        iterator = collection2.iterator();
        System.out.println("-----------------------------");
        System.out.println("The Media in sorted order are: ");
        while (iterator.hasNext()) {
            Media media = (Media) iterator.next();
            if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                System.out.println(cd.getTitle() + "\t" + cd.getLength() + "\t" + cd.numberTracks());
            } else {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                System.out.println(dvd.getTitle() + "\t" + dvd.getCost());
            }
        }
        System.out.println("-----------------------------");
    }

    public static void showMenu() throws PlayerException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> listOrder = new ArrayList<Order>();
        int select;
        do {
            System.out.println("Order Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("5. Get the lucky items");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    anOrder = Order.createOrder();
                    if (anOrder != null) {
                        System.out.println("Create order thanh cong");
                        listOrder.add(anOrder);
                    } else {
                        System.out.println("Ban da create qua so luong cho phep");
                        select = 0;
                    }
                    break;
                case 2:
                    if (anOrder != null) {
                        AddMedia();
                    } else {
                        System.out.println("Ban chua create Order");
                    }
                    break;
                case 3:
                    if (anOrder != null) {
                        scanner.nextLine();
                        System.out.print("Moi ban nhap Id muon xoa : ");
                        String id = scanner.nextLine();
                        anOrder.removeMedia(id);
                    } else {
                        System.out.println("Ban chua create Order");
                    }
                    break;
                case 4:
                    if (anOrder != null) {
                        if (!anOrder.isEmpty()) {
                            anOrder.printOrder();

                            anOrder.sortOrder();
                            anOrder.printOrder();
                        } else {
                            System.out.println("Order empty");
                        }
                    } else {
                        System.out.println("Ban chua create Order");
                    }
                    break;
                case 5:
                    if (anOrder != null) {
                        System.out.println(listOrder.size());
                        Order orderTest = listOrder.get(0);
                        Media testMedia = orderTest.getitemsOrdered().get(0);
                        testMedia.play();
//                        if (!anOrder.isEmpty()) {
//                            Scanner input = new Scanner(System.in);
//                            System.out.printf("Type your preset cost you want: ");
//                            float presetCost = input.nextFloat();
//                            setTotalCostNeed(presetCost);
//                            float totalCostOfOrder = anOrder.totalCost();
//                            if (totalCostOfOrder < presetCost) {
//                                System.out.println("\nYour order not enough to get lucky item. Order more to get lucky item.");
//                                break;
//                            }
//                            int luckValue = luckItem(anOrder.getitemsOrdered().size());
//                            if (luckValue != -1) {
//                                Media mediaLucky = anOrder.getMediaWithIndex(luckValue);
//                                mediaLucky.play();
//                            }
//                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat thanh cong");
                    break;
                default:
                    System.out.println("Ban nhap sai moi ban chon lai");
                    break;
            }
        } while (select != 0);
        System.out.println("******************KET THUC******************");
        scanner.close();
    }

    public static void AddMedia() throws PlayerException {
        int select;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Media : ");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DigitalVideoDisc");
        System.out.println("3. CompactDisc");
        System.out.println("Khac. No add");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 1-2-3: ");
        select = scanner.nextInt();
        switch (select) {
            case 1:
                addBook();
                break;
            case 2:
                addDVD();
                break;
            case 3:
                addCD();
                break;
        }
//		scanner.close();
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
        System.out.print("Id: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = scanner.nextFloat();
        System.out.print("Nhap so luong authour: ");
        int soluong = scanner.nextInt();
        ArrayList<String> authors = new ArrayList<String>();
        scanner.nextLine();
        for (int i = 0; i < soluong; i++) {
            System.out.print("Author " + (i + 1) + ": ");
            String author = scanner.nextLine();
            if (authors.contains(author)) {
                System.out.println("Author da ton tai");
                i--;
                continue;
            }
            authors.add(author);
            System.out.println("Add thanh cong");
        }
//		for (String string: authors) {
//			System.out.println(string);
//		}
        Book book = new Book(id, title, category, cost, authors);
        anOrder.addMedia(book);
//		scanner.close();
    }

    public static void addDVD() throws PlayerException {
        Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
        System.out.print("Id: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = scanner.nextFloat();
        System.out.print("Length: ");
        int length = scanner.nextInt();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        DigitalVideoDisc dvdDigitalVideoDisc = new DigitalVideoDisc(id, title, category, cost, length, director);

        System.out.println("Ban co muon phat DVD? ");
        System.out.println("1. Co");
        System.out.println("Khac. Khong");
        System.out.print("Ban chon: ");
        int select = scanner.nextInt();
        if (select == 1) {
            dvdDigitalVideoDisc.play();
        } else {
            System.out.println("Ban khong phat");
        }
        anOrder.addMedia(dvdDigitalVideoDisc);
//		scanner.close();
    }

    public static void addCD() throws PlayerException {
        Scanner scanner = new Scanner(System.in);
//		scanner.nextLine();
        System.out.print("Id: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        CompactDisc compactDisc = new CompactDisc(id, title, category, cost, director, artist);
        int soluong;
        do {
            System.out.println("Add Track");
            System.out.print("Title: ");
            String title1 = scanner.nextLine();
            System.out.print("Length: ");
            int length1 = scanner.nextInt();
            Track track = new Track(title1, length1);
            compactDisc.addTrack(track);
            System.out.println("Ban muon add them track?");
            System.out.println("1. Co");
            System.out.println("Khac. Khong");
            System.out.print("Ban chon: ");
            soluong = scanner.nextInt();
            scanner.nextLine();
        } while (soluong == 1);

//		DigitalVideoDisc dvdDigitalVideoDisc = new DigitalVideoDisc(title, category, cost, length, director);

        System.out.println("Ban co muon phat CD? ");
        System.out.println("1. Co");
        System.out.println("Khac. Khong");
        System.out.print("Ban chon: ");
        int select = scanner.nextInt();
        if (select == 1) {
            compactDisc.play();
        } else {
            System.out.println("Ban khong phat");
        }
        anOrder.addMedia(compactDisc);
//		scanner.close();
    }

    public static int getRandomNumberInRage(int max, int min) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int luckItem(int arrayLength) {
        Random rand = new Random();
        double valueTest = rand.nextDouble();
        if (valueTest > probabilityOfLuck) {
            System.out.println("Lan sau may man nhe");
            return -1;
        }
        int indexLucky = getRandomNumberInRage(arrayLength, 0);
        return indexLucky;
    }
}
	
	
		
		

