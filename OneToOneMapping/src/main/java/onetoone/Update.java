package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p = em.find(Person.class, 1);
//		p.setName("Vijay");
		p.setEmail("Dinga@gamil.com");

		VoterId v = em.find(VoterId.class, p.getVoterId().getVid());
		v.setAddress("Bangalore");
		
		et.begin();
		em.merge(p);
		em.merge(v);
		et.commit();
	}

}
