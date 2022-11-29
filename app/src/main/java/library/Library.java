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

    public ArrayList<Book> search (String query) {
        
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : books) {
            System.out.println(book.getTitle());
            if(book.getTitle().contains(query)) {
                results.add(book);
                System.out.println("added : " + book.getTitle());
            }

        }
        
        return results;
    }

}
