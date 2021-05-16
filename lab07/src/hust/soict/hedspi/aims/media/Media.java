package hust.soict.hedspi.aims.media;

public abstract class Media {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String title;
    private String category;
    private float cost;

    public String getTitle() {
        return title;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }


}
