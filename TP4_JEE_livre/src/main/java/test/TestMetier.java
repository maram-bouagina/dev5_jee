package test;

import java.util.List;

import dao.LivreDaoImpl;
import metier.entities.Livre;

public class TestMetier {
	public static void main(String[] args) {
		LivreDaoImpl pdao = new LivreDaoImpl();
		Livre liv = pdao.save(new Livre("book thief",45));
		System.out.println(liv);
		List<Livre> livs = pdao.livresParMC("five");
		for (Livre l : livs)
			System.out.println(l);

	}
}