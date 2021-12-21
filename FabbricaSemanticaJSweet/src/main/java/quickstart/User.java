package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;

/**
 * Classe astratta con un metodo che svolge le medesime funzioni per entrambe le pagine 
 * di gestione dell'utente
 */
public abstract class User extends Fabbrica
{
	/**
	 * Metodo che serve per aggiungere al contenitore principale il titolo, l'email e la password
	 * @param form HTMLFormElement a cui si vogliono aggiungere gli elementi
	 * @param titolo stringa che rappresenta il titolo della pagina
	 */
	public static void addTitleAndInput(HTMLFormElement form, String titolo)
	{
		$(form).append(GestioneElementi.costruisciTitolo(titolo), //aggiunta titolo
					   GestioneElementi.costruisciEmail(), //aggiunta email
					   GestioneElementi.costruisciPassword("Password")); //aggiunta password
	}

}
