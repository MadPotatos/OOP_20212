package hust.soict.hedspi.aims.utils;

import java.util.StringTokenizer;

public class MyDate {
    private int day, month, year;

    public MyDate(String Date) {
        StringTokenizer myTokens = new StringTokenizer(Date, "/");
        this.day = Integer.parseInt(myTokens.nextToken());
        this.month = Integer.parseInt(myTokens.nextToken());
        this.year = Integer.parseInt(myTokens.nextToken());
    }

    public void printDate() {
        System.out.println(day + "/" + month + "/" + year);
    }

}
