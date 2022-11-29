package library;

import java.util.ArrayList;

public class Book {

    private String title;
    
    private float score;
    private ArrayList<Rating> ratings = new ArrayList<Rating>();
    
    private float loanPrice;
    private boolean loaned;
    private User loanedTo;

    private ArrayList<Comment> comments = new ArrayList<Comment>();
    

    public Book (String title, float loanPrice) {
        
        this.title = title;
        this.loanPrice = loanPrice;

        //Rating of 0 shows as "unrated"
        score = 0;

        //Default values
        loaned = false;

    }

    public String getTitle() {
        return this.title;
    }

    public float getLoanPrice () {
        return this.loanPrice;
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

    public float getScore () {
        this.score = calculateScore();
        return this.score;
    }

    private float calculateScore () {
        
        float calculatedScore = 0;

        
        int numerator = 0;
        int denominator = 0;
        for (int i = 0; i < ratings.size(); i++) {
            
            numerator += (int) ratings.get(i).getScore();
            denominator++;
        }

        calculatedScore = numerator/denominator;
        return calculatedScore;
    }

    public void addRating (User user, byte score) {

        if (score > 5) score = 5;
        if (score < 1 ) score = 1;

        Rating rating = new Rating(user, score);
        ratings.add(rating);
    }

    public void addComment (User user, String message) {
        Comment newComment = new Comment(user, message);
        comments.add(newComment);
    }

    public ArrayList<Comment> getComments () {
        return this.comments;
    }

}
