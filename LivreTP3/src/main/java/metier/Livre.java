package metier;
import java.io.Serializable;
public class Livre implements Serializable{
private Long idLivre;
private String nomLivre;
private double prix;
public Livre() {
super();
}
public Livre(String nomLivre, double prix) {
super();
this.nomLivre = nomLivre;
this.prix = prix;
}
public Long getIdLivre() {
return idLivre;
}
public void setIdLivre(Long idProduit) {
this.idLivre = idLivre;
}
public String getNomLivre() {
return nomLivre;
}
public void setNomLivre(String nomLivre) {
this.nomLivre = nomLivre;
}
public double getPrix() {
return prix;
}
public void setPrix(double prix) {
this.prix = prix;
}
@Override
public String toString() {
	return "Produit [idLivre=" + idLivre + ", nomProduit=" + nomLivre + ", prix=" + prix + "]";
}

}
