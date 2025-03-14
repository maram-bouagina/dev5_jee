package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Livre;

import util.JPAutil;

public class LivreDaoImpl implements ILivreDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE_livre");

	@Override
	public Livre save(Livre p) {

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();

		return p;
	}

	@Override
	public List<Livre> livresParMC(String mc) {
		List<Livre> livs = entityManager.createQuery("select l from Livre l where l.titre like :mc")
				.setParameter("mc", "%" + mc + "%").getResultList();
		return livs;
	}

	@Override
	public Livre getLivre(Long id) {
		return entityManager.find(Livre.class, id);
	}

	@Override
	public Livre updateLivre(Livre l) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(l);
		tx.commit();
		return l;
	}

	@Override
	public void deleteLivre(Long id) {
		Livre produit = entityManager.find(Livre.class, id);

		entityManager.getTransaction().begin();
		entityManager.remove(produit);
		entityManager.getTransaction().commit();

	}

}