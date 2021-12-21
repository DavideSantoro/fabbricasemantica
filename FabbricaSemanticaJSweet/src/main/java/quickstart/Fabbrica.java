package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;

/**
 * Classe astratta che presenta metodi comuni sia alle pagine di annotazione/validazione 
 * che alle pagine che servono per la gestione dell'utente
 */
public abstract class Fabbrica 
{
	/**
	 * Metodo che serve per aggiungere i contenitori principali alla pagina HTML
	 * e per settare lo sfondo 
	 * @param form1 primo HTMLFormElement che si vuole appendere al body
	 * @param form2 secondo HTMLFormElement che si vuole appendere al body
	 */
	public static void costruisciPagina(HTMLFormElement form1, HTMLFormElement form2)
	{
		$("body").append(form1, form2) //aggiunta delle form al body
				 .css("background-color","#00ffff"); //colore di sfondo della pagina
	}
	
	/**
	 * Metodo che serve per aggiungere il contenitore principale alla pagina HTML
	 * @param form HTMLFormElement che si vuole appendere al body
	 */
	public static void costruisciPagina(HTMLFormElement form)
	{
		costruisciPagina(form, null); //viene riusato il codice chiamando l'altro metodo
	}

}
