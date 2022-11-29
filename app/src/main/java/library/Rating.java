package library;

public class Rating {

    private User user;
    private byte score;

    public Rating (User user, byte score) {
        this.user = user;
        this.score = score;
    }

    public User getUser() {
        return this.user;
    }

    public byte getScore() {
        return this.score;
    }
}

