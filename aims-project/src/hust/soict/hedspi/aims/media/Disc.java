package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	int length;
	String director;

	public Disc() {
	}

	public Disc(String title, int id) {
		super(title, id);
	}

	public Disc(String title, String category, int id) {
		super(title, category, id);
	}

	public Disc(String title, String category, float cost, int id) {
		super(title, category, cost, id);
	}

	public Disc(int length, String title, int id) {
		super(title, id);
		this.length = length;
	}

	public Disc(int length, String title, String category, int id) {
		super(title, category, id);
		this.length = length;
	}

	public Disc(int length, String title, String category, float cost, int id) {
		super(title, category, cost, id);
		this.length = length;
	}
//getter, setter
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}


}
