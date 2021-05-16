package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable {
    public CompactDisc(String title) {
        super(title);
    }

    private String artist;

    public String getArtist() {
        return artist;
    }

    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category) {
        super(title, category);
    }

    //    public CompactDisc(String title,String category)
    public void addTrack(Track track) {
        String title = track.getTitle();
        int i = 1;
        for (Track track1 : tracks) {
            String titleTrack1 = track1.getTitle();
            if (titleTrack1.equals(title)) {
                System.out.println("Existed in DB");
                return;
            }
        }
        tracks.add(track);
        System.out.println("Added to tracks");
        int choice;
//        do {
//            Scanner input = new Scanner(System.in);
//            showMenu();
//            choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    track.play();
//                    break;
//                case 2:
//                    break;
//                default:
//                    break;
//            }
//        } while (choice != 2);
    }
    public int getTotalTrack(){
        return this.tracks.size();
    }
    public void showMenu() {
        System.out.println("Track Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Delete");
        System.out.println("2. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    }

    public int getLength() {
        int lengthOfCd = 0;
        for (Track track : tracks) {
            int lengthOfTrack = track.getLength();
            lengthOfCd += lengthOfTrack;
        }
        return lengthOfCd;
    }

    public void removeTrack() {
        Scanner inputTitle = new Scanner(System.in);
        System.out.println("Delete Application: ");
        System.out.println("--------------------------------");

        System.out.println("Enter the title to delete");
        String titleWantToDelete = inputTitle.nextLine();
        for (Track track : tracks) {
            String trackTitle = track.getTitle();
            if (trackTitle.equals(titleWantToDelete)) {
                System.out.print("Existed in DB. Information:\n");
                System.out.printf("%-20s %-20s\n", "Title", "Length");
                System.out.printf("%-20s %-20s\n", track.getTitle(), track.getLength());
                int choice;
                do {
                    showMenu();
                    Scanner input = new Scanner(System.in);
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            tracks.remove(track);
                            System.out.println("Delete track");
                            choice = 2;
                            break;
                        case 2:
                            System.out.println("Process end ...");
                            return;
                        default:
                            break;
                    }
                } while (choice != 2);
                break;
            }
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public void play() {
        System.out.printf("%-20s %-20s\n", "Title", "Length");
        tracks.forEach(track -> {
            System.out.printf("%-20s %-20s\n", track.getTitle(), track.getLength());
        });
    }
    @Override
    public int compareTo(Media o) {
        CompactDisc objectConvert  = (CompactDisc) o;
        int currentSumOfTracks = this.getTotalTrack();
        int objectConvertSumOfTracsk = objectConvert.getTotalTrack();
        if (currentSumOfTracks > objectConvertSumOfTracsk) {
            return 1;
        } else if (currentSumOfTracks < objectConvertSumOfTracsk) {
            return -1;
        }
        int currentLength = this.getLength();
        int convertedLength = objectConvert.getLength();
        if (currentLength > convertedLength) {
            return 1;
        } else if (currentLength < convertedLength) {
            return -1;
        }
        return this.getTitle().compareTo(objectConvert.getTitle());
    }
}
