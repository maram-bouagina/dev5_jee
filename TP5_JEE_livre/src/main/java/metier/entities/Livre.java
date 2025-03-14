package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name = "livres") 
public class Livre implements Serializable {
	@Id  
	@Column (name="ID_LIVRE") 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idLivre;
	
	private String titre;
	private double prix;

	public Livre() {
		super();
	}

	public Livre(String titre, double prix) {
		super();
		this.titre = titre;
		this.prix = prix;
	}

	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String nomLivre) {
		this.titre = nomLivre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [idLivre=" + idLivre + ", titre=" + titre + ", prix=" + prix + "]";
	}

}
