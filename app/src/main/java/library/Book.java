package library;

import java.util.ArrayList;
import java.util.UUID;

public class Book {

    String uniqueID = UUID.randomUUID().toString();
    private String title;
    private String author;
    private String releaseDate;

    private ArrayList<String> genres = new ArrayList<String>();

    
    private float loanPrice;
    private boolean loaned;
    private User loanedTo;


    private ArrayList<Comment> comments = new ArrayList<Comment>();

    private float score = 0;
    private ArrayList<Rating> ratings = new ArrayList<Rating>();
    

    public Book (String title, String author, float loanPrice, String releaseDate) {
        
        this.title = title;
        this.author = author;
        this.loanPrice = loanPrice;
        this.releaseDate = releaseDate;

        //Rating of 0 shows as "unrated"
        score = 0;

        //Default values
        loaned = false;

    }

    public String getID () {
        return this.uniqueID;
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

        if (ratings.size() == 0) {
            return 0;
        }
        
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

    public String getAuthor() {
        return this.author;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public void addGenre (String genreToAdd) {
        
        for (String genre : genres) {
            if (genre.equals(genreToAdd)) {
                return;   
            }
        }

        genres.add(genreToAdd);
    }

    public boolean hasGenre(String query) {

        for (String genre : genres) {
            if (genre.contains(query)) {
                return true;   
            }
        }
        return false;
    }

}
