package metier;
import java.io.Serializable;
public class Livre implements Serializable{
private Long idLivre;
private String titre;
private double prix;
public Livre() {
super();
}
public Livre(String nomLivre, double prix) {
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
