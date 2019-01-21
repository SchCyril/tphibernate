package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClientDAO {
	public void create(Client entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(entity);
		DatabaseHelper.commitTxAndClose(em);

	}

	public void update(Client entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(entity);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void delete(Client entity) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(em.find(Client.class, entity.getId()));
		DatabaseHelper.commitTxAndClose(em);
	}

	// Quels clients ont acheté un certain livre

	public List<Client> listeClientAchete(Book book) {
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Client> query = em.createQuery(
				"select c " + "from Client c " + "inner join c.books b " + "where b.id =:id " + "order by b.title",
				Client.class);
		query.setParameter("id", book.getId());

		return query.getResultList();

	}

}
