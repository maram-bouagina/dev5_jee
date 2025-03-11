package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Livre> getLivresParMotCle(String mc);

	public void addLivre(Livre l);
}
