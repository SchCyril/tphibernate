package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="book_seq")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq")
	private Integer id;
	private String title;
	private String author;
	@ManyToMany(mappedBy = "books")
	private List<Client> clients = new ArrayList <Client>();
	
	public Book() {
		
	}

	public Book(String title, String author) {

		this.title = title;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", clients=" + "]";
	}
	
	

}
