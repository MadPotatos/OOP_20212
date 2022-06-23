package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;

public class Test {

        public static void main(String[] args) {
                // List
                List<Order> orderList = new ArrayList<Order>();
                List<DigitalVideoDisc> dvdList = new ArrayList<DigitalVideoDisc>();
                List<CompactDisc> cdList = new ArrayList<CompactDisc>();
                List<Book> bookList = new ArrayList<Book>();
                List<Track> trackList = new ArrayList<Track>();

                // Items
                MyDate d1 = new MyDate("5/28/2022");

                // DVD
                DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "animation",
                                "Roger Allers", 87, 19.95f);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Justice League", "superheroes", "Zach Synder", 240,
                                22.95f);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Up", "animation",
                                "Pete Docter", 96, 14.5f);
                DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Incredibles", "animation",
                                "Brad Bird", 115, 18.95f);
                Collections.addAll(dvdList, dvd1, dvd2, dvd3, dvd4);

                // Book
                Book book1 = new Book(5, "It", "horror", 12, "Stephen King");
                Book book2 = new Book(6, "The Shining", "horror", 9, "Stephen King");
                Book book3 = new Book(7, "Dragon", "horror", 15.5f, "Lovecraft");
                Book book4 = new Book(8, "The Pillow Book", "biography", 12, "Sei Shonagon");
                Collections.addAll(bookList, book1, book2, book3, book4);
                // CD
                CompactDisc cd1 = new CompactDisc(9, "Mint Jams", "music",
                                19.95f, "Casiopea");
                CompactDisc cd2 = new CompactDisc(10, "The Beatles", "music",
                                14.5f, "Beatles");
                CompactDisc cd3 = new CompactDisc(11, "Make up City", "music",
                                17.5f, "Casiopea");
                Collections.addAll(cdList, cd1, cd2);

                // Track
                Track track1 = new Track("Take Me", 5);
                Track track2 = new Track("Asayake", 4);
                Track track3 = new Track("Swear", 3);
                Collections.addAll(trackList, track1, track2, track3);
                cd1.addTrack(track1);
                cd1.addTrack(track2);
                cd1.addTrack(track3);

                cd2.addTrack(track3);
                cd2.addTrack(track2);

                cd3.addTrack(track1);
                cd3.addTrack(track2);

                List<CompactDisc> discs = new ArrayList<CompactDisc>();
                discs.add(cd1);
                discs.add(cd2);
                discs.add(cd3);

                System.out.println("----------------------------------------------");
                System.out.println("The CDs currently in the order are: ");
                java.util.Iterator iterator = discs.iterator();
                while (iterator.hasNext()) {
                        ((CompactDisc) iterator.next()).printInfo();

                }
                System.out.println("----------------------------------------------");
                System.out.println("The CDs in sorted order are: ");
                Collections.sort((java.util.List) discs);
                iterator = discs.iterator();
                while (iterator.hasNext()) {
                        ((CompactDisc) iterator.next()).printInfo();
                }
                System.out.println("----------------------------------------------");
        }
}
