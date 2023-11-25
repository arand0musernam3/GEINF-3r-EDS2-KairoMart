public class Observer {
	public static void main(String[] args) {
		// **************************
		// *  VARIABLE DECLARATION  *
		// **************************
		Blog blog = new Blog();
		User u1 = new User("u1@jmail.com", blog), u2 = new User("u2@jmail.com", blog),
			 u3 = new User("u3@jmail.com", blog);

		BrowserNotifier b = new BrowserNotifier(blog); blog.attach(b); //En aquest exemple es controlen manualment,
		//això ho podria fer el navegador mitjançant una API

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

		//L'usuari u1 desactiva les notificacions i l'usuari 3 activa totes les notificacions, email i NewsBox.
		//Es desactiven també les notificacions del navegador.
		blog.detach(b);
		u1.switchNewsBoxNotifications();
		u3.switchMailNotifications();
		u3.switchNewsBoxNotifications();
		u1.addNew("No vull més notificacions...");
	}
}