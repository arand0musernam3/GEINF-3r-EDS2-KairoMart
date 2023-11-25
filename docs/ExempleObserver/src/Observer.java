public class Observer {
	public static void main(String[] args) {
		// **************************
		// *  VARIABLE DECLARATION  *
		// **************************
		Blog blog = new Blog();
		User u1 = new User("u1@jmail.com", blog), u2 = new User("u2@jmail.com", blog),
			 u3 = new User("u3@jmail.com", blog);

		BrowserNotifier b = new BrowserNotifier(blog); blog.attach(b); //no need to add it anywhere

		//U1 afegeix un post, no s'han activat cap mena de notificacions.
		u1.addNew("Primer post, només s'envia notificació de navegador!");
		System.out.println("*************************************************");

		//U1 es subscriu per NewsBox:
		u1.switchNewsBoxNotifications();
		u1.addNew("Test 2!");

		System.out.println("*************************************************");

		// Creem u2 i el subscrivim a notificacions de correu electrònic.
		u2.switchMailNotifications();
		u2.addNew("Ei, acabo d'arribar al blog!");
		System.out.println("*************************************************");
		
	}
}