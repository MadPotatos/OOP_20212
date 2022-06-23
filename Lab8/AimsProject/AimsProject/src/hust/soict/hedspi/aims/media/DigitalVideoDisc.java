package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title);

    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);

    }

    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category, director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);
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

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public int compareTo(Object o) {
        if (this.cost > ((DigitalVideoDisc) o).cost) {
            return 1;
        } else if (this.cost < ((DigitalVideoDisc) o).cost) {
            return -1;
        } else {
            return 0;
        }
    }

}
