public class BrowserNotifier implements BlogObserver{

	public BrowserNotifier(Blog blog) {
		_subject = blog;
	}

	@Override
	public void update() {
		System.out.println(" - Notificació de navegador enviada! Hi ha un nou post al blog!");
	}
	private Blog _subject;
}
