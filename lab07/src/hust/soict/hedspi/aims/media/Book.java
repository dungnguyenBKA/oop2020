package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }
    private List<String> authors = new ArrayList<String>();
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public void addAuthor(String authorName) {
        int checkAuthorInList = authors.indexOf(authorName);
        if (checkAuthorInList == -1) {
            System.out.println("Adding to list...");
            authors.add(authorName);
        } else System.out.println("This author existed in author list.");
    }
    public Book(String title,
         String category,
         List<String> authors) {
        super(title, category);
        this.authors = authors; //TODO: check author condition
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void removeAuthor(String authorName) {
        int indexOfAuthor = authors.indexOf(authorName);
        if (indexOfAuthor == -1) {
            System.out.println(authorName + " not existed in list");
            return;
        }
        authors.remove(indexOfAuthor);
        System.out.println("Deleted");
    }
    public void showDetailBook(){
        System.out.printf("This book have title is: %s.\n", this.getTitle());
        System.out.printf("List author of %s book are:", this.getTitle());
        for (int i=0; i< authors.size(); i++){
            String nameOfAuthors = authors.get(i);
            System.out.printf(" %s", nameOfAuthors);
            if (i != authors.size() -1 ){
                System.out.print(", ");
            } else {
                System.out.print(".\n");
            }
        }
    }
    public static void main(String[] args) {
//        Book testBook1 =- ew
    }
}
