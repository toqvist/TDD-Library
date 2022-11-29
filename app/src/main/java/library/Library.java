package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook (Book book) {
        books.add(book);
    }

}
