import java.util.ArrayList;

public class User {

	public User(String mail, Blog blog) {
		_mail = mail;
		_blog = blog;
		_news_notifier = null;
		_email_notifier = null;
	}

	public void switchNewsBoxNotifications() {
		if (_news_notifier == null) {
			_news_notifier = new NewsBoxNotifier(_blog, this);
			_blog.attach(_news_notifier);
		}
		else {
			_blog.detach(_news_notifier);
			_news_notifier = null;
		}
	}

	public void switchMailNotifications() {
		if (_email_notifier == null) {
			_email_notifier = new EmailNotifier(_blog, this);
			_blog.attach(_email_notifier);
		}
		else {
			_blog.detach(_email_notifier);
			_email_notifier = null;
		}
	}

	public String getMail() {
		return _mail;
	}

	private String _mail;

	private NewsBoxNotifier _news_notifier;
	private EmailNotifier _email_notifier;

	private Blog _blog;
}
