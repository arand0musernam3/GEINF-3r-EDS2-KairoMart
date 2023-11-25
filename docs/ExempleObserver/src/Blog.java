import java.util.ArrayList;

public class Blog implements Subject {

	public Blog() {
		_posts = new ArrayList<>();
		_observers = new ArrayList<>();
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
		return _posts.getLast().message();
	}

	public void addPost(Post post) {
		_posts.add(post);
		notifyUsers();
	}


	private ArrayList<Post> _posts;
	private ArrayList<BlogObserver> _observers;
}