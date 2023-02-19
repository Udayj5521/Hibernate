package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Get {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();

		Person p = em.find(Person.class, 1);
		System.out.println("PersonId: " + p.getPid());
		System.out.println("PersonName: " + p.getName());
		System.out.println("PersonEmail: " + p.getEmail());

		VoterId v = em.find(VoterId.class, p.getVoterId().getVid());
		System.out.println("Vid: " + v.getVid());
		System.out.println("Address: " + v.getAddress());

	}

}
