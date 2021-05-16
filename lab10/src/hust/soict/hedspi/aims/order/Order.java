package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order  {
		
		public static final int MAX_NUMBERS_ORDERED = 10;
		public static final int MAX_LIMITTED_ORDERED = 5;
		private MyDate myDate;
//		private Media luckyDisc = new Media();
		private List<Media> itemsOrdered = new ArrayList<Media>();
		
		private static int nbOrders = 0;
		
		public MyDate getMyDate() {
			return myDate;
		}

		public void setMyDate(MyDate myDate) {
			this.myDate = myDate;
		}
		
		public List<Media> getitemsOrdered(){
			return this.itemsOrdered;
		}
		
		private Order() {
			
		}
		public Media getMediaWithIndex(int index){
			return itemsOrdered.get(index);
		}
		public static Order createOrder() {
			if (nbOrders < MAX_LIMITTED_ORDERED) {
				nbOrders++;
				Order objOrder = new Order();
				objOrder.myDate = new MyDate();
				return objOrder;
			}
			return null;
		}
		
		public void printnbOrder() {
			System.out.println(nbOrders);
		}
//		public boolean check(Media media) {
//			for(int i = 0 ;i<this.itemsOrdered.size();i++)
//				if(this.itemsOrdered.get(i).equals(media))
//					return true;
//			return false;
//		}
		public void addMedia(Media media) {
			if (itemsOrdered.size() == MAX_LIMITTED_ORDERED) {
				System.out.println("Order da day");
				return;
			}
			for(int i = 0 ;i<this.itemsOrdered.size();i++)
				if(this.itemsOrdered.get(i).equals(media)) {
					System.out.println("Da ton tai "+ media.getTitle());
					return;
				}
			itemsOrdered.add(media);
			System.out.println("Them "+ media.getTitle() + " thanh cong voi id = " + media.getId());
		}
		public void removeMedia(Media media) {
			for(int i = 0 ;i<this.itemsOrdered.size();i++)
				if(this.itemsOrdered.get(i).equals(media)) {
					itemsOrdered.remove(media);
					System.out.println("Xoa "+ media.getTitle() + " thanh cong voi id = " + media.getId());
					return;
				}
			System.out.println("Khong ton tai "+ media.getTitle());
		}
		public void removeMedia(String id) {
			for(int i = 0 ; i < itemsOrdered.size();i++) {
				if(itemsOrdered.get(i).getId().equals(id)) {
					Media media = itemsOrdered.get(i);
					System.out.println("Xoa "+ media.getTitle() + " thanh cong voi id = " + media.getId());
					itemsOrdered.remove(media);
					return;
				}					
			}
			System.out.println("Khong ton tai media co Id = " + id);
		}
		
		public boolean isId(String id) {
			for(Media media: itemsOrdered) {
				if(media.getId().equals(id))
					return true;
			}
			return false;
		}
		
		
		public boolean isInitemsOrdered(Media media){
			for(Media media2: itemsOrdered) {
				if(media2.equals(media))
					return true;
			}
			return false;
		}
		
		public boolean isFull(){
			if(itemsOrdered.size() == MAX_LIMITTED_ORDERED)
				return true;
			return false;
		}
		
		public float totalCost() {
			float sum = 0;
			for(int i = 0; i < itemsOrdered.size() ; i++) 
				sum += itemsOrdered.get(i).getCost();			
			return sum;			
		}
		public boolean isEmpty() {
			if(this.itemsOrdered.size()>0) {
				return false;
			}
			return true;
		}
		public void printOrder() {
			if (!isEmpty()) {
//				this.luckyDisc = this.getALuckyItem();
				Media lucky = this.getALuckyItem();
				System.out.println("**************************Order**************************");
				System.out.print("Date: ");
				this.myDate.print();	// Them opption ngay thang o day
				System.out.println("Ordered items:");
				System.out.println("STT) Id. Type - Title - Category - Cost");
				for(int i = 0 ; i < itemsOrdered.size(); i++) {
					System.out.print((i+1)+") ");
					System.out.print(itemsOrdered.get(i).getId()+". ");
					if (itemsOrdered.get(i) instanceof Book) {
						System.out.print("Book- ");
					}
					else if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
						System.out.print("DVD- ");
					}
					else {
						System.out.print("CD- ");
					}
					System.out.print(itemsOrdered.get(i).getTitle()+ " - "+ itemsOrdered.get(i).getCategory()+": ");
					if(lucky.equals(itemsOrdered.get(i))) {
						System.out.println("0.0 $");
					}
					else {
						System.out.println(itemsOrdered.get(i).getCost() + " $");
					}
				}
				System.out.println("Total cost: " + (this.totalCost() - lucky.getCost()) + " $");
				System.out.println("*********************************************************");
			}
			else {
				System.out.println("Order empty");
			}
		}
		public void sortOrder() {
			Collections.sort((ArrayList<Media>)this.itemsOrdered);
			System.out.println("Order sorted ");
		}
		public Media getALuckyItem() {
			double phantu =  Math.random()*itemsOrdered.size();			
			return this.itemsOrdered.get((int) phantu) ;		
		}
}

