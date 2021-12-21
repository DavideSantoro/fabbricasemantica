package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "logout.jsp"
 */
@WebServlet(name="LogoutServlet", urlPatterns="/logout.jsp")
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;

	/**
	 * Metodo all'interno del quale l'utente viene rimosso dalla sessione e viene indirizzato alla pagina di login
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO disconnettere l'utente dal sistema
		HttpSession session = request.getSession();
		session.setAttribute("username", null); //si setta l'attributo username a null
		response.sendRedirect("login.html"); //si indirizza l'utente alla pagina di login
	}

}
