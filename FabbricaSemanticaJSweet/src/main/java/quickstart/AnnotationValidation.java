package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;

/**
 * Classe astratta che presenta campi e metodi comuni a tutte le pagine di annotazione/validazione
 */
public abstract class AnnotationValidation extends Fabbrica
{
	/**
	 * Stringa che rappresenta l'indirizzo di una delle pagine di annotazione/validazione
	 */
	public static final String RANDOM_URL = generaURL();
	
	/**
	 * Stringa che rappresenta la servlet a cui vengono inviati i dati una volta fatto il submit della form
	 */
	public static final String REST_URL = "nextExample.jsp";
	
	/**
	 * Metodo che serve per aggiungere ai contenitori principali i pulsanti di Next e Skip e i link di Home e Logout
	 * @param form1 primo HTMLFormElement a cui si vogliono aggiungere elementi
	 * @param form2 secondo HTMLFormElement a cui si vogliono aggiungere elementi
	 * @param logoutMargin stringa che, una volta associata all'attributo, permette di modificare la posizione del link di logout
	 */
	public static void addLinksAndButtons(HTMLFormElement form1, HTMLFormElement form2, String logoutMargin)
	{
		$(form1).append(GestionePulsanti.costruisciNext(), GestioneLink.costruisciHome()); //aggiunta del pulsante next e del link home
		$(form2).append(GestionePulsanti.costruisciSkip(), GestioneLink.costruisciLogout(logoutMargin)); //aggiunta del pulsante skip e del link logout
		costruisciPagina(form1, form2); //aggiunta delle form al body
	}
	
	/**
	 * Metodo che permette di generare un indirizzo casuale
	 * @return una stringa che identifica una pagina di annotazione/validazione
	 */
	public static String generaURL()
	{
		String URL = null;
		int i = (int) (Math.random() * 7);
		switch(i)
		{
			case 0 : URL = "definitionAnnotation.html"; break;
			case 1 : URL = "myAnnotation.html"; break;
			case 2 : URL = "senseAnnotation.html"; break;
			case 3 : URL = "senseValidation.html"; break;
			case 4 : URL = "translationAnnotation.html"; break;
			case 5 : URL = "translationValidation.html"; break;
			case 6 : URL = "wordAnnotation.html"; break;
		}
		
		return URL;
	}
	
	
}
