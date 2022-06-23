package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object obj) {
        // check equal title and length
        if (this.title.equals(((Track) obj).title) && this.length == ((Track) obj).length) {
            return true;
        }
        return false;
    }

}
