package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

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
}
