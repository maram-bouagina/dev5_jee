package metier;
import java.util.List;
public class TestMetier {
public static void main(String[] args) {
MetierImpl metier= new MetierImpl();
List<Livre> livs = metier.getLivresParMotCle("kin");
for (Livre p : livs)
//System.out.println(p.getNomProduit());
System.out.println(p);
}
}