package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media  {
    private String director;
    private int length;

    DigitalVideoDisc(String title) {
        super(title);
    }

    DigitalVideoDisc(String title, String category) {
        super(title, category);
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

}
