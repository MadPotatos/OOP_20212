package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
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

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<Order>();
        List<Media> mediaList = new ArrayList<Media>();
        MyDate d1 = new MyDate("5/28/2022");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "animation",
                "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Justice League", "superheroes", "Zach Synder", 240, 22.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Up", "animation",
                "Pete Docter", 96, 14.5f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Incredibles", "animation",
                "Brad Bird", 115, 19.95f);

        Book book1 = new Book(5, "It", "horror", 12, "Stephen King");
        Book book2 = new Book(6, "The Shining", "horror", 9, "Stephen King");
        Book book3 = new Book(7, "Dragon", "horror", 15.5f, "Lovecraft");
        Book book4 = new Book(8, "The Pillow Book", "biography", 12, "Sei Shonagon");
        Collections.addAll(mediaList, dvd1, dvd2, dvd3, dvd4, book1, book2, book3, book4);
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
                    System.out.println("Choose the id of the item you want to add: ");
                    int add_id = scan.nextInt();
                    for (Media media : mediaList) {
                        if (media.getId() == add_id) {
                            orderList.get(orderList.size() - 1).addMedia(media);
                            System.out.println("Item added");
                            check = 1;
                            break;
                        }
                    }
                    if (check == 0) {
                        System.out.println("Item not found");
                    }
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