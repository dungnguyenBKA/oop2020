package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    private  String title;
    private int length;
    public Track(String title){
        this.title = title;
    }
    public Track(String title, int length){
        this.title=title;
        this.length=length;
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());

    }
}
