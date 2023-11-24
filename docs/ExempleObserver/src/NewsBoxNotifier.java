public class NewsBoxNotifier implements BlogObserver{
	@Override
	public void update() {
		System.out.println("Sóc una notificació PUSH a l'smartphone de " + _user.getMail());
	}

	private Blog _subject;
	private User _user;
}
