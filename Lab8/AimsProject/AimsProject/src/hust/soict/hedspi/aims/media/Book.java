package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();
    String content;
    List<String> contentTokens = new ArrayList<String>();
    Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book() {

    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost, String author) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        addAuthor(author);
        this.id = id;
    }

    public void addAuthor(String authorName) {
        // author not on list
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " da duoc them vao danh sach");
        } else {
            System.out.println(authorName + " da ton tai trong danh sach");
        }
    }

    public void removeAuthor(String authorName) {
        // author on list
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " da duoc xoa khoi danh sach");
        } else {
            System.out.println(authorName + " khong ton tai trong danh sach");
        }

    }

    public void printInfo() {
        System.out.println("Book: " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getAuthors()
                + " - " + getCost());
    }

    public void processContent() {
        // split by spaces or punctuation
        String[] words = content.split("\\s|\\p{Punct}");
        // sort token and set to contentTokens
        for (String word : words) {
            if (word.length() > 0) {

                contentTokens.add(word);

            }
        }
        Collections.sort(contentTokens);
        // count word frequency and set to wordFrequency

        for (String word : contentTokens) {
            if (wordFrequency.containsKey(word)) {
                int count = wordFrequency.get(word);
                count++;
                wordFrequency.put(word, count);
            } else {
                wordFrequency.put(word, 1);
            }
        }

    }

    public String toString() {
        // return Book id, title, category, cost, authors, content and word frequency
        StringBuilder sb = new StringBuilder();
        sb.append("Book: " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getAuthors()
                + " - " + getCost() + "\n");
        sb.append("Content length: " + contentTokens.size() + "\n");
        sb.append("Word Frequency: \n");
        sb.append(wordFrequency.toString());
        return sb.toString();

    }

}
