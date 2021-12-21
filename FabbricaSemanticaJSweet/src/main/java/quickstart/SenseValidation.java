package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Classe che rappresenta la pagina HTML di validazione "annotationValidation"
 */
public class SenseValidation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "senseValidation.jsp";
	
	/**
	 * Stringa che identifica il nome della task
	 */
	public static final String TASK_NAME = "task=SENSE_VALIDATION";
	
	public static void main(String[] args) 
	{
		//costruzione contenitori principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 43%");
		
		//costruzione etichetta che contiene la richiesta
		HTMLLabelElement richiesta = GestioneElementi.costruisciEtichetta("Indicare se il senso che appare nel riquadro è coerente o meno con la parola fornita");
		$(richiesta).css("font-weight", "bold");
		
		//costruzione etichetta che contiene la parola
		HTMLLabelElement word = document.createElement(StringTypes.label);
		
		//costruzione etichetta che contiene l'esempio
		HTMLLabelElement example = document.createElement(StringTypes.label);
		$(example).css("font-style", "italic");
		
		//costruzione etichetta che contiene il senso
		HTMLLabelElement sense = document.createElement(StringTypes.label);
		
		//input element nascosti che consentono di salvare il testo delle etichette nel backend
		HTMLInputElement hiddenWord = GestioneElementi.costruisciHidden("hiddenWord");
		HTMLInputElement hiddenExample = GestioneElementi.costruisciHidden("hiddenExample");
		HTMLInputElement hiddenSense = GestioneElementi.costruisciHidden("hiddenSense");
		
		//chiamata a servlet per ottenere i dati ed assegnare il testo alle etichette
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sExample = json.$get("example");
			String sSense = json.$get("sense");
			$(word).text(sWord);
			$(example).text(sExample);
			$(sense).text(sSense);
			$(hiddenWord).attr("value", sWord);
			$(hiddenExample).attr("value", sExample);
			$(hiddenSense).attr("value", sSense);
			
			return null;
		});
		
		HTMLDivElement divSense = GestioneElementi.divEtichetta(sense); //contenitore dell'etichetta del senso
		
		//si modificano gli attributi del div
		GestioneElementi.setDivAttributes(new HTMLDivElement[] { divSense }, "", "400px", "outset", "#007fff", "5px", "200px");
		
		//aggiunta alla form di etichette e pulsanti
		$(form1).append(GestioneElementi.divEtichetta(richiesta), GestioneElementi.divEtichetta(word),
						GestioneElementi.divEtichetta(example), divSense, hiddenWord, hiddenExample, hiddenSense,
						GestionePulsanti.costruisciRadio("Si"), GestionePulsanti.costruisciRadio("No"));
						
		addLinksAndButtons(form1, form2, "5% 0%"); //aggiunta delle form al body
		
	}

}
