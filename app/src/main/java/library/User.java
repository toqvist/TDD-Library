package library;

import java.util.ArrayList;

public class User {
    
    private String name;
    private float dollarBalance;
    private ArrayList<Book> loanedBooks = new ArrayList<Book>();

    public User (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public float getDollars () {
        return this.dollarBalance;
    }

    public void depositDollars (float amount) {
        if (amount > 0) {
            this.dollarBalance += amount;
        }
    }

    public void spendDollars (float amount) {
        if (amount < 0) {
            amount *= (-1);
        }
        this.dollarBalance -= amount;
    }

    public void returnBook (Book book) {
        boolean canReturn = false;
        for (Book loanedBook : loanedBooks) {
            if (loanedBook.getID() == book.getID() ) {
                canReturn = true;
            }
        }
        if(canReturn) {
            book.returnBook();
            loanedBooks.remove(book);
        }
    }

    public void loanBook (Book book) {
        
        if (canLoan(book)) {

            spendDollars(book.getLoanPrice());
            loanedBooks.add(book);
            book.loanTo(this);

        }
    }

    public boolean canLoan (Book book) {
        if (dollarBalance - book.getLoanPrice() >= 0 ) {
            return true;
        }

        if (book.getLoaned() == false) {
            return true;
        }

        return false;
    }

    public float getDollarBalance () {
        return this.dollarBalance;
    }

    public ArrayList<Book> getLoanedBooks () {
        return this.loanedBooks;
    }

}
