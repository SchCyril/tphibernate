package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="client_seq")
public class Client {
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_seq")
	private Integer id;
	private String lastname;
	private String firstname;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	


	@ManyToMany
	private List<Book> books = new ArrayList<Book>();

	public Client() {

	}

	public Client(String lastname, String firstname, Gender gender) {

		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void livreAchete(Book book) {
		this.books.add(book);
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender + "]";
				
	}


}
