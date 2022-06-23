package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> trackList = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (trackList.contains(track)) {
            System.out.println("Track already exists");
        } else {
            trackList.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (trackList.contains(track)) {
            trackList.remove(track);
        } else {
            System.out.println("Track does not exist");
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : trackList) {
            length += track.getLength();
        }
        return length;
    }

    public void printInfo() {
        System.out.println("CompactDisc: " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getArtist()
                + " - " + getCost() + " - " + getLength());
        // print all tracks
        System.out.println("The track in the " + getTitle() + " :");
        for (Track track : trackList) {

            System.out.println(track.getTitle() + " - " + track.getLength());
        }
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());

        for (Track track : trackList) {
            track.play();
        }

    }

    public int compareTo(Object o) {
        // compare number of tracks
        if (this.trackList.size() > ((CompactDisc) o).trackList.size()) {
            return 1;
        } else if (this.trackList.size() < ((CompactDisc) o).trackList.size()) {
            return -1;
        } else {
            // compare length
            if (this.getLength() > ((CompactDisc) o).getLength()) {
                return 1;
            } else if (this.getLength() < ((CompactDisc) o).getLength()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
