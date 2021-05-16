package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
//	public void setLength(float length) {
//		this.length = length;
//	}
	public String getDirector() {
		return director;
	}
//	public void setDirector(String director) {
//		this.director = director;
//	}
	
	public	Disc(String id,String title, int length, String director){
		super(id,title);
		this.length = length;
		this.director = director;
	}
	public Disc(String id,String title, String category, float cost) {
		super(id,title, category, cost);
	}
	public	Disc(String id,String title,String category, int length, String director){
		super(id,title,category);
		this.length = length;
		this.director = director;
	}
	public Disc(String id,String title, String category, float cost,int length, String director) {
		super(id,title, category, cost);
		this.length = length;
		this.director = director;
	}
	public Disc(String id,String title, String category, float cost,String director) {
		super(id,title, category, cost);
		this.director = director;
	}
}
