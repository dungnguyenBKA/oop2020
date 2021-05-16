package hust.soict.hedspi.aims.media;

import java.util.*;

public class Book extends Media {

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public List<String> getContentTokens() {
        return contentTokens;
    }

    public void setContentTokens(List<String> contentTokens) {
        this.contentTokens = contentTokens;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    //    content Tokens get an array content - split by spaces
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String, Integer> wordFrequency;

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

    public void showDetailBook() {
        System.out.printf("This book have title is: %s.\n", this.getTitle());
        System.out.printf("List author of %s book are:", this.getTitle());
        for (int i = 0; i < authors.size(); i++) {
            String nameOfAuthors = authors.get(i);
            System.out.printf(" %s", nameOfAuthors);
            if (i != authors.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".\n");
            }
        }
    }

    //    get list token after split with " ".
    public void showListTokens() {
        for (String contentToken : this.contentTokens) {
            System.out.println(contentToken);
        }
    }

    //        printf map
    public String printMap(Map<String, Integer> map) {
        String dataResponse = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            dataResponse = dataResponse + "Key : " + entry.getKey() + " have : "
                    + entry.getValue() + " times appeared.\n";
        }
        return dataResponse;
    }

    //    split and sort the content from a to z.
    public String processContent() {
        List<String> list = new ArrayList<>(Arrays.asList(this.content.toLowerCase().split(" ")));
//        Collections.sort(list);
        this.setContentTokens(list);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String element : list) {
            Integer count = map.get(element);
            map.put(element, (count == null) ? 1 : count + 1);
        }
//        After sort
        System.out.println("-------------AFTER SORT-------------");
        Map<String, Integer> treemap = new TreeMap<String, Integer>(map);
        return printMap(treemap);
    }

    public int getTotalToken() {
        return this.getContentTokens().size();
    }

    public static void main(String[] args) {
        Book testBook1 = new Book("Tong Anh", "123");
        testBook1.addAuthor("phen");
        testBook1.addAuthor("phen1");
        testBook1.addAuthor("phen3");
        testBook1.setContent("tong tong tong tong ngoc ngoc anh");
        System.out.println(testBook1.toString());
    }

    @Override
    public int compareTo(Media o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Title is " + this.getTitle() + ", count token: " + this.getContent().split(" ").length + "\n Frequency token: \n" +
                this.processContent();
    }
}
