package hust.soict.hedspi.aims.media;

@SuppressWarnings("rawtypes")
public abstract class Media implements Comparable {
	protected int id;
	protected String title;
	String category;
	float cost;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Media() {
		super();
		this.id = 9999;
	}

	public Media(String title, int id) {
		
		this.title = title;
		this.id = id;
	}

	public Media(String title, String category, int id){
		this.title = title;
		this.category = category;
	}

	public Media(String title, String category, float cost, int id) {
		this(title, id);
		this.category = category;
		this.cost = cost;
	}
	
//---------------------------------------
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String categoryString) {
		this.category = categoryString;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void print() {
		System.out.printf("Title: %s.\nCategory: %s.\nCost: %s.\n", title, category, cost);
	}

//---------------------------------------
	@Override
	public boolean equals(Object obj) throws NullPointerException, ClassCastException{
		if(obj == null) {
			throw new NullPointerException("Obj Null");
		}else {
			if(obj instanceof Media) {
				Media media = (Media) obj;
				if(media.getCost() == this.getCost() && this.getTitle() == media.getTitle())
					return true;
				else {
					return false;
				}
			}else {
				throw new ClassCastException("Obj not Media");
			}
		}
	}
	
	public int compareTo(Object obj) {
		if(obj == null) {
			throw new NullPointerException("Obj Null");
		}else {
			if(obj instanceof Media) {
				Media media = (Media) obj;
				return -media.getTitle().compareTo(this.getTitle());				
			}else {
				throw new ClassCastException("Obj not Media");
			}
		}		
	}
	
}
