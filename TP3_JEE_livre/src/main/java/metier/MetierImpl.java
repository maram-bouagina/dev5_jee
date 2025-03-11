package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MetierImpl implements ImetierCatalogue {
@Override
public List<Livre> getLivresParMotCle(String mc) {
	 List<Livre> prods= new ArrayList<Livre>();
	 Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from livres where titre LIKE ?");
	ps.setString(1, "%"+mc+"%");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Livre p = new Livre();
	p.setIdLivre(rs.getLong("ID_LIVRE"));
	p.setTitre(rs.getString("titre"));
	p.setPrix(rs.getDouble("PRIX"));
	prods.add(p);
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return prods;
	}
	@Override
	public void addLivre(Livre p) {
	
	}
	}
