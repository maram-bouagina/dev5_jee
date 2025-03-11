package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ILivreDao;
import dao.LivreDaoImpl;
import metier.entities.Livre;


@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	ILivreDao metier;

	@Override
	public void init() throws ServletException {
		metier = new LivreDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("livres.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			LivreModele model = new LivreModele();
			model.setMotCle(motCle);
			List<Livre> prods = metier.livresParMC(motCle);
			model.setLivres(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("livres.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieLivre.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("titre");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Livre p = metier.save(new Livre(nom, prix));
			request.setAttribute("livre", p);
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteLivre(id);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Livre p = metier.getLivre(id);
			request.setAttribute("livre", p);
			request.getRequestDispatcher("editerLivre.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("titre");
			double prix = Double.parseDouble(request.getParameter("prix"));
			Livre p = new Livre();
			p.setIdLivre(id);
			p.setTitre(nom);
			p.setPrix(prix);
			metier.updateLivre(p);
			request.setAttribute("Livre", p);
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}