package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BookDAO {
	public void create(Book entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);

	}

	public void update(Book entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(Book entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(em.find(Book.class, entity.getId()));
		DatabaseHelper.commitTxAndClose(em);
	}

	// Quelles livres ont été achetées par un certain client

	public List<Book> listeBookAcheteParClient(Client entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Book> query = em
				.createQuery("select b " + "from Book b " + "inner join b.clients c " + "where c.id =:id ", Book.class);
		query.setParameter("id", entity.getId());
		List<Book> books = query.getResultList();

		return books;

	}

//	// Quels livres ont été achetés

	public  List<Book> listeBooks() {

		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Book> query = em
				.createQuery("select distinct b " + "from Book b " + "inner join b.clients c ", Book.class);
		
		List<Book> books = query.getResultList();

		return books;

	}

}
