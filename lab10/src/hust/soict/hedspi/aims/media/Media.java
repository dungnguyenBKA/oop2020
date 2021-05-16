package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;
import hust.soict.hedspi.aims.media.disc.Playable;

public class Media implements Comparable, Playable {
    //	private static int index = 0;
    public int compareTo(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Obj null");
        } else {
            if (obj instanceof Media) {
                Media media = (Media) obj;
                return -media.getTitle().compareTo(this.getTitle());
            } else {
                throw new ClassCastException("Obj not media");
            }
        }
    }

    private String id;
    private String title;
    private String category;
    private float cost;

    public boolean equals(Object obj) {
        Media ob = (Media) obj;
        if (ob == null) {
            throw new NullPointerException("Obj Null");
        } else {
            if (obj instanceof Media) {
                if (ob.getId().equals(this.getId()))
                    return true;
                return false;
            } else {
                throw new ClassCastException("Obj not media");
            }
        }
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
    public Media(String id, String title) {
        this.id = id;
        this.title = title;
//		this.setId();
    }

    public Media(String id, String title, String category) {
        this(id, title);
        this.category = category;
//		this.setId();
    }

    public Media(String id, String title, String category, float cost) {
        this(id, title, category);
        this.cost = cost;
//		this.setId();
    }

    @Override
    public void play() throws PlayerException {
        String id = this.getId();
        String title = this.getTitle();
        String category = this.getCategory();
        float cost = this.getCost();
        System.out.println("Detail Media:");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "ID", "Title", "Category", "Cost");
        System.out.printf("%-10s %-10s %-10s %-10.3f\n", id, title, category, cost);
    }
}