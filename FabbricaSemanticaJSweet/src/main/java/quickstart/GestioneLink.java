package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import jsweet.util.StringTypes;

/**
 * Classe che dispone di metodi statici utili alla configurazione e alla costruzione
 * dei redirect propri di una o più pagine HTML
 */
public class GestioneLink 
{
	/**
	 * Metodo che permette la costruzione del link che serve per tornare alla homepage di FabbricaSemantica
	 * @return un HTMLDivElement che contiene l'HMLAnchorElement home configurato
	 */
	public static HTMLDivElement costruisciHome()
	{
		//costruzione e configurazione del link per tornare alla home
		HTMLAnchorElement home = document.createElement(StringTypes.a);
		home.href = "home.html";
		home.name = "link_home";
		home.text = "Torna alla home";
		$(home).css("white-space", "nowrap");
		
		//costruzione del contenitore
		HTMLDivElement divHome = document.createElement(StringTypes.div);
		divHome.className = "form-group";
		$(divHome).append(home);
		
		return divHome;
	}
	
	/**
	 * Metodo che permette la costruzione del link che serve per indirizzare alla pagina di login
	 * @return un HTMLDivElement che contiene l'HTMLAnchorElement login configurato
	 */
	public static HTMLDivElement costruisciLogin()
	{
		//Costruzione e configurazione del link di login
		HTMLAnchorElement login = document.createElement(StringTypes.a);
		login.href = "login.html";
		login.name = "link_login";
		login.text = "Hai già un account? Accedi!";
		
		//costruzione del contenitore
		HTMLDivElement divLogin = document.createElement(StringTypes.div);
		divLogin.className = "form-group";
		$(divLogin).append(login);
		
		return divLogin;
	}
	
	/**
	 * Metodo che permette la costruzione del link che serve per indirizzare alla pagina di signup
	 * @return un HTMLDivElement che contiene l'HTMLAnchorElement signup configurato
	 */
	public static HTMLDivElement costruisciSignup()
	{
		//costruzione e configurazione del link di signup
		HTMLAnchorElement signup = document.createElement(StringTypes.a);
		signup.href = "signup.html";
		signup.name = "link_signup";
		signup.text = "Non hai un account? Registrati ora!";
		
		//costruzione del contenitore
		HTMLDivElement divSignup = document.createElement(StringTypes.div);
		divSignup.className = "form-group";
		$(divSignup).append(signup);
		
		return divSignup;
	}
	
	/**
	 * Metodo che permette la costruzione del link che serve per effettuare il logout
	 * @param margine stringa associata all'attributo che consente di cambiare il posizionamento del link all'interno della pagina
	 * @return un HTMLDivElement che contiene l'HTMLAnchorElement logout configurato
	 */
	public static HTMLDivElement costruisciLogout(String margine)
	{
		//costruzione e configurazione del link logout
		HTMLAnchorElement logout = document.createElement(StringTypes.a);
		logout.href = "logout.jsp";
		logout.name = "link_logout";
		logout.text = "Logout";
		$(logout).css("margin", margine);
		
		//costruzione del contenitore
		HTMLDivElement divLogout = document.createElement(StringTypes.div);
		divLogout.className = "form-group";
		$(divLogout).append(logout);
		
		return divLogout;
	}


}
