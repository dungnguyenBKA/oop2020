package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Book extends Media  {

	private List<String> authors = new ArrayList<>();
	private String content;
	private final List<String> contentTokens = new ArrayList<>();
	private final Map<String, Integer> wordFrequency = new TreeMap<>();


	public Book(int id,String title, String category, float cost) {
		super(title, category, cost, id);
	}

	public Book() {
		super();
	}

	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
		ArrayList<T> newList = new ArrayList<T>();

		for (T element : list) {
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}
		return newList;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		authors.remove(authorName);
	}

	public void ShowBook(Book book) {
		int i;
		for (i = 0; i < book.authors.size(); i++) {
			System.out.println(book.authors.get(i));
		}
	}

	public static Book getBook(Scanner keyboard) {
		Book newBook = new Book();
		String temp;
		System.out.println("Enter the title:  ");
		newBook.setTitle(keyboard.nextLine());

		System.out.println("Enter the category: ");
		newBook.setCategory(keyboard.nextLine());

		System.out.println("Enter the price: ");
		temp = keyboard.nextLine();
		try {
			if (!temp.isEmpty())
				newBook.setCost(Float.parseFloat(temp));
		} catch (NumberFormatException e) {
			System.err.println("Error occurs.");
		}

		do {
			System.out.println("Enter the author name (enter to skip): ");
			temp = keyboard.nextLine();
			if (!temp.isEmpty())
				newBook.addAuthor(temp);
			else {
				keyboard.close();
				return newBook;
			}
		} while (true);

	}
	
	public String getContentString() {
		return content;
	}

	public void setContentString(String content) {
		this.content = content;
		this.processContent();
	}
	
	public String toString() {
		int i = 1;
		String outString = "Id: "+this.getId()+"\n";
		outString += "Title: "+ this.getTitle()+ "\n";
		outString += "Category: "+this.getCategory()+"\n";
		outString += "Cost: "+this.getCost()+"\n";
		outString += "List Authous: \n";
		for(String author: this.authors) {
			outString += "Author"+ (i++) + ": "+ author+"\n";
		}
		outString += "Content Length: " + this.contentTokens.size()+ "\n";
		outString += "Word Frequency: \n";
		for(Entry<String, Integer> entry: wordFrequency.entrySet()) {
			String key = entry.getKey();
            Integer value = entry.getValue();
			outString += String.format("%-20s%d\n",key,value);
		}
		outString +="-----\n";
		return outString;
	}
	
	public void processContent() {
		this.contentTokens.clear();
		this.wordFrequency.clear();
		String[] outputString = this.content.split("[ ?.,;\"'!]+"); //[ ?.,;"'!]
		for(String output: outputString) {
			int dem = 0;
			for(String content: contentTokens)
				if(content.equals(output)) {
					wordFrequency.put(output, wordFrequency.get(output)+1);
					dem = 1;
					break;
				}
			if(dem == 0) {
				contentTokens.add(output);
				wordFrequency.put(output,1);
			}
		}
		Collections.sort(contentTokens);
	}
}
