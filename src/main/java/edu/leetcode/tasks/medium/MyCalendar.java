package edu.leetcode.tasks.medium;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;


/**
 * 2022-08-03
 */
public class MyCalendar {
    private final NavigableSet<Book> calendar = new TreeSet<>(Comparator.comparingInt(o -> o.start));

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        Book b = new Book(start, end);
        Book prev = calendar.floor(b);
        Book next = calendar.ceiling(b);

        boolean res;
        if (prev == null && next == null) {
            res = true;
        } else if (prev == null) {
            res = next.start >= end;
        } else if (next == null) {
            res = prev.end <= start;
        } else {
            res = prev.end <= start && next.start >= end;
        }


        if (res) {
            calendar.add(b);
        }
        return res;
    }

    private static class Book {
        private final int start;
        private final int end;

        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
//        MyCalendar myCalendar = new MyCalendar();
//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(15, 25));
//        System.out.println(myCalendar.book(20, 30));
//        System.out.println(myCalendar.book(21, 30));
//        System.out.println(myCalendar.book(30, 32));
//        System.out.println(myCalendar.book(31, 32));
//        System.out.println(myCalendar.book(31, 32));

        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(33, 41));
        System.out.println(myCalendar.book(39, 45));
        System.out.println(myCalendar.book(33, 42));
        System.out.println(myCalendar.book(25, 32));
        System.out.println(myCalendar.book(26, 35));
        System.out.println(myCalendar.book(19, 25));
        System.out.println(myCalendar.book(3, 8));
        System.out.println(myCalendar.book(8, 13));
        System.out.println(myCalendar.book(18, 27));
    }
}
