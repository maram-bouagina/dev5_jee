package dao;

import java.util.List;

import metier.entities.Livre;

public interface ILivreDao {
	public Livre save(Livre l);

	public List<Livre> livresParMC(String mc);

	public Livre getLivre(Long id);

	public Livre updateLivre(Livre l);

	public void deleteLivre(Long id);
}
