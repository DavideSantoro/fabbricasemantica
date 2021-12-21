package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "login.jsp"
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;

	/**
	 * Metodo in cui viene implementata la logica che permette di sapere se, al momento del login, 
	 * l'utente risulta registrato e se le credenziali che sono state inserite sono corrette
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementare i controlli per l'utente
		//si prelevano l'username e la password che ha inserito l'utente
		String username = request.getParameter("email");
		String password = request.getParameter("Password");
		Path p = Paths.get(request.getServletContext().getRealPath(GestioneUser.PERCORSO_DATABASE));
		File db = p.toFile();
		boolean b = false; //si inizializza un booleano a false
		try(BufferedReader br = new BufferedReader(new FileReader(db)))
		{
			while (br.ready())
			{
				String linea = br.readLine();
				String[] infoUtente = linea.split("\t");
				//se l'email e la password corrispondono a quelle salvate nel database allora il login 
				//viene effettuato correttamente e si interrompono i controlli
				if (infoUtente[0].equals(username) && infoUtente[1].equals(password))
				{
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					response.sendRedirect("home.html");
					b = true;
					break;
				}
			}
			
			//altrimenti viene visualizzato un messaggio di errore
			if (!b) GestioneUser.messaggioDiErrore(response, "Le credenziali sono errate", "login.html"); 

		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
