package library;

public class Comment {

    private User user;
    private String message;

    public Comment (User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getuser() {
        return this.user;
    }

    public String getMessage () {
        return this.message;
    }


}
