package quickstart;

import static def.dom.Globals.window;
import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che rappresenta la costruzione della homepage del progetto FabbricaSemantica "home.html"
 */
public class Home extends AnnotationValidation
{
	/**
	 * Stringa che rappresenta l'URL della pagina di login
	 */
	public static final String LOGIN_URL = "login.html";
	
	/**
	 * Stringa che rappresenta l'URL della servlet che serve per verificare se l'utente è loggato
	 */
	public static final String SERVLET_URL = "isLoggedIn.jsp";
	
	public static void main(String[] args) 
	{	
		HTMLFormElement form = GestioneElementi.costruisciForm(RANDOM_URL, "5% 45%"); //costruzione form
		
		//chiamata a servlet che permette di indirizzare l'utente alla pagina di login nel caso in cui non risulti loggato
		$.getJSON(SERVLET_URL, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String isLoggedIn = json.$get("isLoggedIn");
			if (isLoggedIn.equals("false")) window.location.href = LOGIN_URL;
			return null;
		});
		
		$(form).append(GestioneElementi.costruisciTitolo("Home"), //aggiunta titolo
					   GestionePulsanti.costruisciStart(), //aggiunta pulsante start
					   GestioneLink.costruisciLogout("5% 100%")); //aggiunta link logout
		
		costruisciPagina(form); //aggiunta della form al body
		
	}
}
