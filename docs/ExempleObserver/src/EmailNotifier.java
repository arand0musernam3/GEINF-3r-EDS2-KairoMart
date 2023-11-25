public class EmailNotifier implements BlogObserver{

	public EmailNotifier(Blog blog, User user) {
		_subject = blog;
		_user = user;
	}

	@Override
	public void update() {
		System.out.print("Correu electrònic enviat a " + _user.getMail() + "! Hi ha un nou post al blog:\n" +
				_subject.getLatestPost().substring(0, 10));
		if (_subject.getLatestPost().length() > 10)
			System.out.println("...");
		else System.out.println();
	}

	private Blog _subject;
	private User _user;
}
