public class BrowserNotifier implements BlogObserver{
	@Override
	public void update() {
		System.out.println("Notificació de navegador enviada!");
	}
	private Blog _subject;
}
