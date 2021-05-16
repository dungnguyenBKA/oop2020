package hust.soict.hedspi.aims.media.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import hust.soict.hedspi.aims.media.Media;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String contentString;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	
	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
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
//	private void printContenTokens() {
//		for(String content: this.contentTokens) {
//			System.out.print(content+" ");
//		}
//		System.out.println();
//	}
//	private void printwordFrequency() {
//		for(Entry<String, Integer> entry: wordFrequency.entrySet()) {
//			String key = entry.getKey();
//            Integer value = entry.getValue();
//			System.out.printf("%-20s%d\n",key,value);
//		}
//	}
	
	public void addAuthor(String authorName) {
		if(this.authors.contains(authorName))
			System.out.println("Tac gia: '" + authorName + "' da ton tai");
		else 
			this.authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if(!this.authors.contains(authorName))
			System.out.println("Tac gia: '" + authorName + "' khong ton tai");
		else 
			this.authors.remove(authorName);
	}
	
	public void processContent() {
		this.contentTokens.clear();
		this.wordFrequency.clear();
		String[] outputString = this.contentString.split("[ ?.,;\"'!]+"); //[ ?.,;"'!]
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
		Collections.sort((ArrayList<String>)contentTokens);
	}

	public Book(String id,String title, String category, float cost,ArrayList<String> listauthor) {
		super(id,title, category, cost);
		this.authors = listauthor;
	}
	
	public Book(String id,String title, String category, float cost) {
		super(id,title, category, cost);
	}

	public Book(String id,String title, String category,ArrayList<String> authors) {
		super(id,title, category);
		this.authors = authors;
	}

	public Book(String id,String title,ArrayList<String> authors) {
		super(id,title);
		this.authors = authors;
	}

	
	
//	public Book() {
//		super();
//	}
//	public Book(String title){
//		super(title);
//	}
//	public	Book(String title,String category){
//		super(title, category);
//	}
//	public	Book(String title,String category,ArrayList<String> authors){
//		super(title, category);
//		this.authors = authors;
//		
//	}	

}