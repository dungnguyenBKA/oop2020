package hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media implements Comparable<Media> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return id == media.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, cost);
    }

    @Override
    public int compareTo(Media o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
