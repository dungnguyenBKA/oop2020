package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	public boolean equals(Object obj) {
		Track ob = (Track) obj;
		if (ob.getTitle().equals(this.getTitle()) && ob.getLength() == this.getLength())
			return true;
		return false;
	}
	public int getLength() {
		return length;
	}
//	public void setLength(int length) {
//		this.length = length;
//	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public void play() throws PlayerException {
		if (this.getLength()>0){
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: "+ this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
