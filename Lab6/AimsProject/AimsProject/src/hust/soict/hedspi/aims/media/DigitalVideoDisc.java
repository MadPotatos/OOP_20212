package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {

    public String director;
    public int length;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director) {
        this.title = title;
        this.category = category;
        this.director = director;
        id++;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = id;
    }

    public boolean search(String title) {
        String token_search_title[] = title.toLowerCase().split("\\s+");
        String token_dvd_title[] = this.title.toLowerCase().split("\\s+");

        for (int i = 0; i < token_search_title.length; i++) {
            int check = 0;
            for (int j = 0; j < token_dvd_title.length; j++)
                if (token_search_title[i].equals(token_dvd_title[j])) {
                    check = 1;
                    break;
                }
            if (check == 0) {
                return false;
            }
        }
        return true;
    }

    public void printInfo() {
        System.out.println("DVD: " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getDirector()
                + " - " + getLength()
                + " - " + getCost());

    }

}
