package io;

import model.Book;
import model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public void close() {
        sc.close();
    }

    public Book readAndCreateBook() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Data wydania: ");
        int releaseDate = getInt();
        sc.nextLine();
        System.out.println("Ilość stron: ");
        int pages = getInt();
        sc.nextLine();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = getInt();
        System.out.println("Miesiąc: ");
        int month = getInt();
        System.out.println("Dzień: ");
        int day = getInt();
        sc.nextLine();

        sc.nextLine();

        return new Magazine(title, year, publisher, month, day, language);
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
}
