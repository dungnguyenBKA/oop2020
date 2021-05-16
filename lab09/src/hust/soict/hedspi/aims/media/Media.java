package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable{
//	private static int index = 0;
	public int compareTo(Object obj) {
		Media media = (Media) obj;
		return -media.getTitle().compareTo(this.getTitle());
	}
	private String id ;
	private String title;
	private String category;
	private float cost;
	
	public boolean equals(Object obj) {
		Media ob = (Media) obj;
		if (ob.getId().equals(this.getId()))
			return true;
		return false;
	}
	
	public String getId() {
		return id;
	}

//	public void setId() {
//		this.id = index++;
//	}
	
	public String getTitle() {
		return title;
	}

//	public void setTitle(String title) {
//		this.title = title;
//	}

	public String getCategory() {
		return category;
	}

//	public void setCategory(String category) {
//		this.category = category;
//	}

	public float getCost() {
		return cost;
	}

//	public void setCost(float cost) {
//		this.cost = cost;
//	}
//
//	public Media() {
//		this.setId();
//	}
	public	Media(String id,String title){
		this.id = id;
		this.title = title;
//		this.setId();
	}
	public	Media(String id,String title,String category){
		this(id,title);
		this.category = category;
//		this.setId();
	}
	public	Media(String id,String title,String category,float cost){
		this(id,title,category);
		this.cost = cost;
//		this.setId();
	}

}