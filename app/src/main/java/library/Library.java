package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    public void addUser (User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers () {
        return this.users;
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

    public Book getBookById (String id) {
        for (Book book : books) {
            if (book.getID() == book.getID() ) {
                return book;
            }
        }
        return null;
    }
}
