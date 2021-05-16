package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private int length;
	private final ArrayList<Track> tracks = new ArrayList<>();


	public CompactDisc(String artist, String title, String category, float cost, int id) {
		super(title, category, cost, id);
		this.artist = artist;
	}


	public void addTrack(Track tmpTrack) {

		if (tracks.contains(tmpTrack)) {
			System.out.println("already exist");
		} else {
			tracks.add(tmpTrack);
			this.artist = this.artist + ", " + artist;
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Remove track successful.");
			return;
		}

		System.out.println("Track does not exist.");
	}
	
	@Override
	public int getLength() {
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}


	public void play() {
		for (Track track : this.tracks) {
			track.play();
		}

		System.out.println("Title: " + getTitle());
		System.out.println("Artist : " + getArtist());
		System.out.println("Length : " + getLength());

	}

	private String getArtist() {
		return this.artist;
	}

	public static CompactDisc getCD(Scanner keyboard) {
		String temp;
		String titleTemp, categoryTemp, artistTemp;
		float costTemp = 0;
		int idTemp;

		
		System.out.println("Enter the title:  ");
		titleTemp = keyboard.nextLine();

		System.out.println("Enter the category: ");
		categoryTemp = keyboard.nextLine();

		System.out.println("Enter the price: ");
		temp = keyboard.nextLine();
		try {
			if (!temp.isEmpty())
				costTemp = Float.parseFloat(temp);
			if (costTemp < 0)
				costTemp = 0;
	
		} catch (NumberFormatException e) {
			System.err.println("Error occurs.");
		}

		System.out.println("Enter the artist name (enter to skip): ");
		artistTemp = keyboard.nextLine();
		
		System.out.println("Enter ID: ");
		idTemp = keyboard.nextInt();

		CompactDisc newCD = new CompactDisc(artistTemp, titleTemp, categoryTemp, costTemp, idTemp);
		// from now will be track info
		do {
			System.out.println("Do you want to add track(Y/n): ");
			temp = keyboard.nextLine();
			if (temp.equals("Y") || temp.equals("y")) {
				newCD.addTrack(Track.getTrack(keyboard));
			} else
				break;
		} while (true);

		System.out.println("Do you want to play CD(Y/n): ");
		temp = keyboard.nextLine();
		if (temp.equals("Y") || temp.equals("y"))
			newCD.play();
		keyboard.close();
		return newCD;
	}

	public int compareTo(Object obj) {
		if(!(obj instanceof CompactDisc)) { //not CompactDisc, use super()
			return super.compareTo(obj);
		}
		CompactDisc cd = (CompactDisc) obj;
		if (this.tracks.size() - cd.tracks.size() > 0) // size ->
			return 1;
		if (this.tracks.size() == cd.tracks.size()) { // size equal then
			if (this.getLength() - cd.getLength() > 0) 
				return 1;
			if (this.getLength() == cd.getLength())
				return 0;	
		}
		return -1;
	}


}
