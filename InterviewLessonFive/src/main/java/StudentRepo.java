import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class StudentRepo {

	private final EntityManagerFactory emFactory;

	public StudentRepo(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}

	public List<Student> findAll() {
		return executeForEntityManager(
				em -> em.createQuery("select u from Student u", Student.class)
						.getResultList());
	}

	public Optional<Student> findById(long id) {
		return executeForEntityManager(
				em -> Optional.ofNullable(em.find(Student.class, id)));
	}

	public void insert(Student user) {
		executeInTransaction(em -> em.persist(user));
	}

	public void update(Student user) {
		executeInTransaction(em -> em.merge(user));
	}

	public void deleteById(long id) {
		executeInTransaction(
				em -> em.createQuery("delete from Student where id = :id")
						.setParameter("id", id)
						.executeUpdate());
	}

	private <R> R executeForEntityManager(Function<EntityManager, R> function) {
		EntityManager em = emFactory.createEntityManager();
		try {
			return function.apply(em);
		} finally {
			em.close();
		}
	}

	private void executeInTransaction(Consumer<EntityManager> consumer) {
		EntityManager em = emFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			consumer.accept(em);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
}