package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "isLoggedIn.jsp"
 */
@WebServlet(name="AuthenticationServiceServlet", urlPatterns="/isLoggedIn.jsp")
public class AuthenticationServiceServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	
	/**
	 * Metodo all'interno del quale viene implementata la logica utile a fare i controlli 
	 * per vedere se l'utente è loggato o meno al sistema
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean isLoggedIn = session.getAttribute("username") != null;
		//il getWriter scriverà l'informazione da restituire al chiamante, in questo caso true o false 
		if (isLoggedIn) response.getWriter().write("{\"isLoggedIn\": \"true\"}");
		else response.getWriter().write("{\"isLoggedIn\": \"false\"}");

	}

}
