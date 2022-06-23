package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    protected String director;
    protected int length;

    public Disc() {

    }

    public Disc(String title) {
        this.title = title;
    }

    public Disc(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Disc(String title, String category, String director) {
        this.title = title;
        this.category = category;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Disc(int id, String title, String category, String director, int length, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

}
