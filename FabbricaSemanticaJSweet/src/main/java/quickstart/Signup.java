package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;
import def.dom.HTMLLabelElement;

/**
 * Classe che rappresenta la costruzione della pagina HTML di registrazione "signup"
 */
public class Signup extends User
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "signup.jsp";
	
	public static void main(String[] args) 
	{			
		HTMLFormElement form = GestioneElementi.costruisciForm(SERVLET_URL, "5% 45%"); //costruzione form
		
		HTMLLabelElement label = GestioneElementi.costruisciEtichetta("Lingue Parlate"); //costruzione etichetta
		
		//costruzione e modifica attributi delle etichette relative alle lingue parlate che possono essere scelte dall'utente
		HTMLLabelElement labelIta = GestioneElementi.costruisciEtichetta("Italiano");
		HTMLLabelElement labelEng = GestioneElementi.costruisciEtichetta("Inglese");
		$(labelIta).css("background-color", "#ffffff");
		$(labelEng).css("background-color", "#ffffff");
		
		addTitleAndInput(form, "Registrazione"); //aggiunta del titolo, dell'input login e dell'input password
		
		//vengono aggiunti il resto degli elementi alla form
		$(form).append(GestioneElementi.costruisciPassword("Ripeti Password"),
					   GestioneElementi.divEtichetta(label),
					   GestioneElementi.divCheckbox(GestioneElementi.costruisciCheckbox("checkboxItaliano", "15px", "15px"), labelIta),
					   GestioneElementi.divCheckbox(GestioneElementi.costruisciCheckbox("checkboxInglese", "15px", "15px"), labelEng),
					   GestioneElementi.costruisciEtichetta("Altre Lingue Parlate (Opzionale)"),
					   GestioneElementi.costruisciSelect("altraLingua1"),
					   GestioneElementi.costruisciSelect("altraLingua2"),
					   GestionePulsanti.costruisciSignup(), GestioneLink.costruisciLogin());
		
		costruisciPagina(form); //aggiunta della form al body
	}

}
