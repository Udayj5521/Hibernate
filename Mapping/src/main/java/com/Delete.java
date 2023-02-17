package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();


		Person p = em.find(Person.class, 1);

		VoterId v = em.find(VoterId.class, p.getVoterId().getVid());
		
		et.begin();
		em.remove(p);
		em.remove(v);
		et.commit();
	}

}
