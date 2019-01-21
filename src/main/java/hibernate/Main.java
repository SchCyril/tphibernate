package hibernate;

public class Main {

	public static void main(String[] args) {

		// Client client = new Client("Schneidenbach", "Cyril", Gender.M);
		Book book1 = new Book("World of Warcraft", "Christie Golden");
		Book book2 = new Book("World of Warcraft1", "Christie Golden");
		Book book3 = new Book("World of Warcraft2", "Christie Golden");
		Client client1 = new Client("Schneidenbach", "Cyril", Gender.M);
		Client client2 = new Client("Mattera", "Lorick", Gender.M);
		Client client3 = new Client("Payan", "Benjamin", Gender.M);

		BookDAO daob = new BookDAO();
		ClientDAO daoc = new ClientDAO();
		
		
		client1.livreAchete(book2);
		client2.livreAchete(book3);
		client3.livreAchete(book1);
		
		daob.create(book1);
		daob.create(book2);
		daob.create(book3);
		daoc.create(client1);
		daoc.create(client2);
		daoc.create(client3);
		
		

		LOGGER.trace(daob.listeBookAcheteParClient(client1).toString());
		LOGGER.trace(daoc.listeClientAchete(book1).toString());
		LOGGER.trace(daob.listeBooks());

	}
}
