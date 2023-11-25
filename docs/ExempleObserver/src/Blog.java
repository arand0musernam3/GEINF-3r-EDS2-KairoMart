import java.util.ArrayList;

public class Blog implements Subject {

	public Blog() {
		_posts = new ArrayList<>();
		_observers = new ArrayList<>();
		_users = new ArrayList<>();
	}

	public void attach(BlogObserver o) {
		_observers.add(o);
	}

	public void detach(BlogObserver o) {
		_observers.remove(o);
	}

	public void notifyUsers() {
		for (BlogObserver o : _observers) {
			o.update();
		}
	}

	public String getLatestPost() {
		return _posts.getLast();
	}

	public void addPost(String post) {
		_posts.add(post);
		notifyUsers();
	}


	private ArrayList<String> _posts;
	private ArrayList<User> _users;
	private ArrayList<BlogObserver> _observers;
}