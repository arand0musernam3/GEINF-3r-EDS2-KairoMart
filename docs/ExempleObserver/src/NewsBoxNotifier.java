public class NewsBoxNotifier implements BlogObserver{

	public NewsBoxNotifier(Blog blog, User user) {
		_subject = blog;
		_user = user;
	}
	@Override
	public void update() {
		System.out.print(" - Notificació PUSH a " + _user.getMail() + "! Hi ha un nou post al blog:\n\t" +
				_subject.getLatestPost().substring(0, Math.min(10, _subject.getLatestPost().length())));
		if (_subject.getLatestPost().length() > 10)
			System.out.println("...");
		else System.out.println();
	}

	private Blog _subject;
	private User _user;
}
