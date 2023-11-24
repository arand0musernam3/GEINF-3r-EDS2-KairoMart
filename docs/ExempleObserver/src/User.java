import java.util.ArrayList;

public class User {

	public User(String mail) {
		_mail = mail;
	}

	public void switchNewsBoxNotifications() {

	}

	public void switchMailNotifications() {

	}

	public String getMail() {
		return _mail;
	}

	public void addNew(String n) {
		_newsbox.add(n);
	}

	private String _mail;
	private ArrayList<String> _newsbox;

	private NewsBoxNotifier _news_notifier;
	private EmailNotifier _email_notifier;
}
