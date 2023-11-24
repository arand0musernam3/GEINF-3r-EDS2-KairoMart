import java.util.ArrayList;

public class Blog {
	public void attach(BlogObserver o) {
		_observers.add(o);
	}

	public void detach(BlogObserver o) {
		_observers.remove(o);
	}

	public void notifyUsers() {
		for (BlogObserver o : _observers) {
			o.notify();
		}
	}

	public String getLatestPost() {
		return _posts.getLast();
	}

	public void addPost(String post) {
		_posts.add(post);
	}


	private ArrayList<String> _posts;
	private ArrayList<User> _users;
	private ArrayList<BlogObserver> _observers;
}