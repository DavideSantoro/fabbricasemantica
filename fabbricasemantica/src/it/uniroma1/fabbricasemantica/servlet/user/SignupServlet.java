package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;


/**
 * Classe che rappresenta la servlet invocata all'indirizzo "signup.jsp"
 */
@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	
	/**
	 * Metodo in cui viene implementata la logica che permette di di registrare l'utente al sistema
	 * nel caso in cui abbia inserito i dati correttamente
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementare la logica per la registrazione
		//si prelevano tutti i dati che ha inserito l'utente
		String email = request.getParameter("email");
		String password = request.getParameter("Password");
		String conferma = request.getParameter("Ripeti Password");
		String checkbox1 = request.getParameter("checkboxItaliano");
		String checkbox2 = request.getParameter("checkboxInglese");
		String select1 = request.getParameter("altraLingua1");
		String select2 = request.getParameter("altraLingua2");
		
		//si inizializza il livello delle due lingue opzionali a null
		String lvSelect1 = null;
		String lvSelect2 = null;

		//se l'utente non ha inserito qualche campo obbligatorio allora viene visualizzato un messaggio di errore
		if (email.isEmpty() || password.isEmpty() || conferma.isEmpty() || (checkbox1 == null && checkbox2 == null)) GestioneUser.messaggioDiErrore(response, "Alcuni campi non sono stati compilati", "signup.html"); 
		//altrimenti si procede con gli altri controlli
		else {
	
		if (checkbox1 != null) checkbox1 = "italiano";
		if (checkbox2 != null) checkbox2 = "inglese";
		
		//se l'utente non ha inserito la lingua opzionale rimane null sia il campo relativo alla lingua
		//che il campo relativo al livello della lingua
		//altrimenti si separa il livello dalla lingua tramite il metodo substring
		if (select1.equals("...")) select1 = null;
		else
		{ 
			lvSelect1 = select1.substring(select1.length() - 3, select1.length() - 1);
			select1 = select1.substring(0, select1.length() - 5);
		}
		
		if (select2.equals("...")) select2 = null;
		else
		{
			lvSelect2 = select2.substring(select2.length() - 3, select2.length() - 1);
			select2 = select2.substring(0, select2.length() - 5);
		}
		
		Path p = Paths.get(request.getServletContext().getRealPath(GestioneUser.PERCORSO_DATABASE));
		File db = p.toFile();
		boolean b = false; //si inizializza un booleano a false
		try(BufferedReader br = new BufferedReader(new FileReader(db)))
		{
			while (br.ready())
			{
				String linea = br.readLine();
				String[] infoUtente = linea.split("\t");
				//se esiste già un nome utente uguale a quello inserito dall'utente
				//viene visualizzato un messaggio di errore e si interrompono i controlli
				if (infoUtente[0].equals(email)) 
				{
					GestioneUser.messaggioDiErrore(response, "Nome utente già esistente", "signup.html");
					b = true;
					break;
				}
				
			}
			
			//se invece il nome utente è disponibile e la password è uguale alla conferma si salvano i dati 
			if (password.equals(conferma) & !b)
			{
				PrintWriter pw = new PrintWriter(new FileWriter(db, true));
				pw.println(email + "\t" + password + "\t" + checkbox1 + "\t" + checkbox2 + "\t" + 
						   select1 + "\t" + lvSelect1 + "\t" + select2 + "\t" + lvSelect2);
				pw.close();
				response.sendRedirect("home.html");
				
			}
			
			//altrimenti viene visualizzato un messaggio di errore che segnala che la password e la conferma sono diverse
			else if (!(password.equals(conferma)) && !b) GestioneUser.messaggioDiErrore(response, "La password non corrisponde alla conferma", "signup.html");
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		} }
		

	}

}
