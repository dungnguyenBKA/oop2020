package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, int length) {
        super(title, category);
        this.setLength(length);
    }

    public DigitalVideoDisc(String title, float cost, int length) {
        super(title);
        this.setCost(cost);
        this.setLength(length);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    public void play() {
        System.out.printf("The title is %s,cost is %f, length is %d\n", this.getTitle(), this.getCost(), this.getLength());
    }

    @Override
    public int compareTo(Media o) {
        DigitalVideoDisc valueAfterCast = (DigitalVideoDisc) o;
        int compareCost = 0;
        if (this.getCost() > valueAfterCast.getCost()) {
            return 1;
        } else if (this.getCost() < valueAfterCast.getCost()) {
            return -1;
        }
        if (this.getLength() > valueAfterCast.getLength()) {
            return 1;
        } else if (this.getLength() < valueAfterCast.getLength()) {
            return -1;
        }
        return this.getTitle().compareTo(valueAfterCast.getTitle());
    }
}
