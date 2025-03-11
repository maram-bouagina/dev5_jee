package com.maram.test;

import com.maram.dao.LivreDao;

import com.maram.entities.Livre;

public class LivreTest {
	public static void main(String[] args) {

		
		Livre c = new Livre();
		Livre c2 = new Livre();
		c.setTitre("the shining");
		c.setAuteur("Stephen King");
		c2.setTitre("throne of glass");
		c2.setAuteur("Sarah J.Mass");

		LivreDao cltDao = new LivreDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c2);
		System.out.println("Appel de la méthode listerTous");
		for (Livre cl : cltDao.listerTous())
			System.out.println(cl);
		System.out.println("Appel de la méthode listerPartitre");
		for (Livre cl : cltDao.listerParTitre("mar"))
			System.out.println(cl);
		System.out.println("Appel de la méthode listerTous apres ajout");
		for (Livre cl : cltDao.listerTous())
			System.out.println(cl);
		c2.setTitre("ACOTAR");
		cltDao.modifier(c2);
		System.out.println("Appel de la méthode listerTous apres modif");
		for (Livre cl : cltDao.listerTous())
			System.out.println(cl);
		cltDao.supprimer(c2);
		System.out.println("Appel de la méthode listerTous apres supp");
		for (Livre cl : cltDao.listerTous())
			System.out.println(cl);
		Livre cuns= new Livre();
		cuns=cltDao.consulter(c2,1);
		if(cuns!=null) {
			System.out.println("consultation: " + cuns);
		}
		else {
			System.out.println("cuns c'est null");
		}
		
	}
	
}
