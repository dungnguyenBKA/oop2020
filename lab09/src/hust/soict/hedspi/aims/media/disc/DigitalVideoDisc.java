package hust.soict.hedspi.aims.media.disc;

public class DigitalVideoDisc extends Disc implements Playable,Comparable{
		
	public int compareTo(Object obj) {
		if(!(obj instanceof DigitalVideoDisc)) {
			return super.compareTo(obj);
		}
		DigitalVideoDisc dvd = (DigitalVideoDisc) obj;
		if (this.getCost() - dvd.getCost() > 0)
			return 1;
		if (this.getCost() == dvd.getCost()) {
			return 0;
		}
		return -1;
	}
	
	public DigitalVideoDisc(String id,String title, int length, String director){
		super(id,title,length,director);
	}
	public DigitalVideoDisc(String id,String title, String category, float cost) {
		super(id,title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public DigitalVideoDisc(String id,String title,String category, int length, String director){
		super(id,title,category,length,director);
	}
	public DigitalVideoDisc(String id,String title,String category, float cost,int length, String director){
		super(id,title, category,cost,length,director);
	}
		
	public boolean search(String title) {
		String[] output = title.toLowerCase().split(" ");
		String[] input = this.getTitle().toLowerCase().split(" ");
		for(int i = 0 ;i < output.length ; i++)
			for(int j = 0 ; j< input.length ; j++)
				if(output[i].equals(input[j]))
					return true;			
		return false;	
	}
	public void play() {
		System.out.println("-------------");
		System.out.println("Playing DVD: " +  this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		System.out.println("-------------");
	}
		
}