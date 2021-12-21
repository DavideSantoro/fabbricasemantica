package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;

/**
 * Classe che rappresenta la costruzione della pagina HTML di login "login"
 */
public class Login extends User
{
	/**
	 * Stringa che rappresenta l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "login.jsp";
	
	public static void main(String[] args) 
	{			
		HTMLFormElement form = GestioneElementi.costruisciForm(SERVLET_URL, "5% 45%"); //costruzione form
		
		addTitleAndInput(form, "Login"); //aggiunta del titolo, dell'input login e dell'input password

		$(form).append(GestionePulsanti.costruisciLogin(), //aggiunta pulsante login
					   GestioneLink.costruisciSignup()); //aggiunta link logout
		
		costruisciPagina(form); //aggiunta della form al body

	}
	

}
