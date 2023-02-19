package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePerson {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		VoterId v1 = new VoterId();
		v1.setVid(10101);
		v1.setAddress("Bangalore");

		VoterId v2 = new VoterId();
		v2.setVid(20202);
		v2.setAddress("Hassan");

		VoterId v3 = new VoterId();
		v3.setVid(30303);
		v3.setAddress("Delhi");

		Person p1 = new Person();
		p1.setPid(1);
		p1.setName("Vijay");
		p1.setEmail("vijay@gmail.com");
		p1.setVoterId(v1);
		
		Person p2 = new Person();
		p2.setPid(2);
		p2.setName("Venu");
		p2.setEmail("Venu@gmail.com");
		p2.setVoterId(v2);
		
		Person p3 = new Person();
		p3.setPid(3);
		p3.setName("Rahul");
		p3.setEmail("rahul@gmail.com");
		p3.setVoterId(v3);
		
		et.begin();
		em.persist(v1);
		em.persist(v2);
		em.persist(v3);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		et.commit();
	}

}
