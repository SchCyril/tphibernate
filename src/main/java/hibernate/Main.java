package hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	private static final String NAME = "Christie Golden";

	public static void main(String[] args) {

		
		Book book1 = new Book("World of Warcraft", NAME);
		Book book2 = new Book("World of Warcraft1", NAME);
		Book book3 = new Book("World of Warcraft2", NAME);
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
		
		
		

		

	}
}
