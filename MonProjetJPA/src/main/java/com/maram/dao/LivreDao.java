package com.maram.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.maram.entities.Livre;
import com.maram.util.JPAutil;

//classe contenant les méthodes génériques ajouter,  supprimer, 
//consulter par clé primaire (Id) 
public class LivreDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à  la bd 
	public void ajouter(Livre l) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(l);
		tx.commit();

	}

	// méthode modifier d'une entité à partir de la bd
	public void modifier(Livre l) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(l);
		tx.commit();

	}

	// méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Livre l) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		l= entityManager.merge(l); // important
		entityManager.remove(l);
		tx.commit();
	}

	// méthode Consulter d'une entité à partir de la bd
	public Livre consulter(Livre l, Object id) {
		return entityManager.find(l.getClass(), id);
	}

	// méthode pour lister tous les objets à partir de la bd
	public List<Livre> listerTous() {
		List<Livre> livres = entityManager.createQuery("select l from Livre l").getResultList();
		return livres;
	}

//méthode pour lister tous les client dont le nom contient un  
//texte donné en paramètre (pnom) 
	public List<Livre> listerParTitre(String titre) {
		List<Livre> livres = entityManager.createQuery("select l from Livre l where l.titre like :ltitre")
				.setParameter("ltitre", "%" + titre + "%").getResultList();

		return livres;
	}
}