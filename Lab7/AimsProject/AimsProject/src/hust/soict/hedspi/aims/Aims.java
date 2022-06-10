package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;

public class Aims {
        public static void showMenu() {
                System.out.println("Order Management Application: ");
                System.out.println("--------------------------------");
                System.out.println("1. Create new order");
                System.out.println("2. Add item to the order");
                System.out.println("3. Delete item by id");
                System.out.println("4. Display the items list of order");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4");
        }

        public static void showAdd() {
                System.out.println("Choose type of item you want to add: ");
                System.out.println("1. DVD");
                System.out.println("2. Book");
                System.out.println("3. CD");
                System.out.println("0. Back");

        }

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
                                "Brad Bird", 115, 19.95f);
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
                Collections.addAll(cdList, cd1, cd2);

                // Track
                Track track1 = new Track("Take Me", 5);
                Track track2 = new Track("Asayake", 4);
                Track track3 = new Track("Swear", 3);
                Collections.addAll(trackList, track1, track2, track3);
                int choice;
                Scanner scan = new Scanner(System.in);
                do {
                        showMenu();
                        choice = scan.nextInt();
                        switch (choice) {
                                case 1:
                                        Order order = new Order(d1);
                                        orderList.add(order);
                                        break;
                                case 2:
                                        int check = 0;
                                        int choiceAdd;
                                        do {
                                                showAdd();
                                                choiceAdd = scan.nextInt();
                                                switch (choiceAdd) {
                                                        case 1:
                                                                System.out.println("Enter the id of the DVD: ");
                                                                int id = scan.nextInt();
                                                                for (DigitalVideoDisc dvd : dvdList) {
                                                                        if (dvd.getId() == id) {
                                                                                orderList.get(orderList.size() - 1)
                                                                                                .addMedia(dvd);
                                                                                System.out.println("Item added");
                                                                                check = 1;
                                                                                System.out.println(
                                                                                                "Do you want to play ? (1. Yes, 0. No)");
                                                                                int choicePlay = scan.nextInt();
                                                                                if (choicePlay == 1) {
                                                                                        dvd.play();
                                                                                } else {
                                                                                        break;
                                                                                }
                                                                                break;
                                                                        }
                                                                }

                                                                break;
                                                        case 2:
                                                                System.out.println("Enter the id of the Book: ");
                                                                id = scan.nextInt();
                                                                for (Book book : bookList) {
                                                                        if (book.getId() == id) {
                                                                                orderList.get(orderList.size() - 1)
                                                                                                .addMedia(book);
                                                                                System.out.println("Item added");

                                                                                check = 1;
                                                                                break;
                                                                        }
                                                                }

                                                                break;
                                                        case 3:

                                                                System.out.println("Enter the id of the CD: ");
                                                                id = scan.nextInt();
                                                                for (CompactDisc cd : cdList) {
                                                                        if (cd.getId() == id) {
                                                                                orderList.get(orderList.size() - 1)
                                                                                                .addMedia(cd);
                                                                                System.out.println("Item added");
                                                                                String inputTitle;
                                                                                do {
                                                                                        System.out.println(
                                                                                                        "Add track to the CD");
                                                                                        System.out.println(
                                                                                                        "Enter the title of the track(Press c to end input): ");
                                                                                        inputTitle = scan.next();
                                                                                        for (Track track : trackList) {
                                                                                                if (track.getTitle()
                                                                                                                .equals(
                                                                                                                                inputTitle)) {
                                                                                                        cd.addTrack(track);
                                                                                                        System.out.println(
                                                                                                                        "Track added");
                                                                                                        check = 1;
                                                                                                        break;
                                                                                                }

                                                                                        }

                                                                                } while (!inputTitle.equals("c"));
                                                                                System.out.println(
                                                                                                "Do you want to play ? (1. Yes, 0. No)");
                                                                                int choicePlay = scan.nextInt();
                                                                                if (choicePlay == 1) {
                                                                                        cd.play();
                                                                                } else {
                                                                                        break;
                                                                                }

                                                                                break;

                                                                        }
                                                                }
                                                                break;
                                                        case 0:
                                                                check = 1;
                                                                break;
                                                        default:
                                                                System.out.println("Invalid number");
                                                                break;

                                                }

                                                if (check == 0) {
                                                        System.out.println("Item not found");
                                                }
                                        } while (choiceAdd != 0);
                                        break;
                                case 3:
                                        System.out.println("Choose the id of the item you want to delete: ");
                                        int delete_id = scan.nextInt();
                                        orderList.get(Order.nbOrders - 1).removeMediaById(delete_id);
                                        break;
                                case 4:
                                        orderList.get(Order.nbOrders - 1).printOrder();
                                        break;
                                case 0:
                                        System.out.println("Exit the application");
                                        break;
                                default:
                                        System.out.println("Invalid choice");
                                        break;

                        }
                } while (choice != 0);

        }
}