public class EmailNotifier implements BlogObserver{
	@Override
	public void update() {
		System.out.println("Sóc una notificació de correu electrònic a " + _user.getMail());
	}

	private Blog _subject;
	private User _user;
}
