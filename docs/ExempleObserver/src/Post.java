public class Post {
    private User _user;
    private String _post;
    private Blog _blog;

    public Post(Blog b, User u, String msg) {
        _blog = b;
        _user = u;
        _post = msg;
    }

    public String message() {
        return _post;
    }
}
