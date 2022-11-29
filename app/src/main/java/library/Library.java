package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Searches by all criteria at once
    public ArrayList<Book> generalSearch(String query) {

        ArrayList<Book> results = new ArrayList<Book>();

        for (Book book : books) {

            boolean titleMatch = book.getTitle().contains(query);
            boolean authorMatch = book.getAuthor().contains(query);
            boolean genreMatch = book.hasGenre(query);
            
            boolean releaseDateMatch = false;
            if (query.chars().count() >= 2 ) {
                releaseDateMatch = book.getReleaseDate().contains(query);
            }
            

            boolean scoreMatch = false;            
            try {

                if (Math.round(book.getScore()) == Integer.parseInt(query)) {
                    scoreMatch = true;
                }
                
            } catch (Exception e) {
            }

            if (titleMatch || authorMatch || genreMatch ||
                    releaseDateMatch || scoreMatch) {

                results.add(book);

            }
        }

        return results;
    }

}
