package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
    public static final int MAX_NUM_ORDERED = 10;
    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERS = 5;
    public static int nbOrders = 0;
    private List<Media> itemsOrdered = new ArrayList<Media>();
    private int qtyOrdered;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Order() {
    }

    public Order(MyDate dateOrdered) {
        this.dateOrdered = dateOrdered;
        if (nbOrders < MAX_LIMITED_ORDERS) {
            nbOrders++;
            System.out.println("Order created");
        } else {
            System.out.println("Maximum number of orders reached");
        }
    }

    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUM_ORDERED) {
            itemsOrdered.add(media);
            qtyOrdered++;
        } else {
            System.out.println("Maximum number of items ordered reached");
        }

    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            qtyOrdered--;
            System.out.println("Item deleted");
        } else {
            System.out.println("Item not found");
        }
    }

    public void removeMediaById(int id) {
        int check = 0;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                itemsOrdered.remove(media);
                qtyOrdered--;
                System.out.println("Item deleted");
                check = 1;
                break;
            }

        }
        if (check == 0) {
            System.out.println("Item not found");
        }
    }

    public float totalCost() {
        float totalCost = 0f;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void getOrder() {
        for (Media media : itemsOrdered) {

            media.printInfo();

        }
    }

    public void printOrder() {
        System.out.println("***********************Order***********************");
        System.out.println("Date: ");
        dateOrdered.printDate();
        getOrder();
        System.out.println("Total Cost: " + totalCost());
        System.out.println("***************************************************");

    }

}
