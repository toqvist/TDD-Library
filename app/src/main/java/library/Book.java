package library;

public class Book {

    private String title;
    private float rating;
    
    private float loanPrice;
    private boolean loaned;
    private User loanedTo;
    

    public Book (String title) {
        this.title = title;

        //Rating of 0 shows as "unrated"
        rating = 0;

        //Default prices
        loaned = false;



    }

    public String getTitle() {
        return this.title;
    }

    public boolean getLoaned () {
        return this.loaned;
    }

    public void loanTo (User user) {
        if (!loaned) {
            this.loaned = true;
            this.loanedTo = user;
        } 
        
    }

    public User getLoanedTo() {
        if (this.loanedTo != null) {
            return this.loanedTo;
        }
        User notLoaned = new User("Not loaned");
        return notLoaned;
    }
    
    public void returnBook () {
        this.loanedTo = null;
        this.loaned = false;
    }

}
