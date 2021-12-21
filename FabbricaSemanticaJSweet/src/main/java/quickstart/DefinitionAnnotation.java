package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Classe che rappresenta la costruzione della pagina HTML di annotazione "definitionAnnotation"
 */
public class DefinitionAnnotation extends AnnotationValidation
{
	/**
	 * Stringa che rappresenta l'indirizzo della servlet a cui mandare i dati una volta fatto il submit della form
	 */
	public static final String SERVLET_URL = "definitionAnnotation.jsp";
	
	/**
	 * Stringa che corrisponde al nome del task
	 */
	public static final String TASK_NAME = "task=DEFINITION_ANNOTATION";
	
	public static void main(String[] args) 
	{
		//contenitori principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 67%"); 
		
		//label della parola e dell'iperonimo
		HTMLLabelElement word = document.createElement(StringTypes.label); 
		HTMLLabelElement hypernym = document.createElement(StringTypes.label); 
		
		//input element con type hidden per permettere nel back-end di prelevare i dati forniti 
		HTMLInputElement hiddenWord = GestioneElementi.costruisciHidden("hiddenWord");
		HTMLInputElement hiddenHypernym = GestioneElementi.costruisciHidden("hiddenHypernym");
		
		//chiamata a servlet che permette di prelevare una parola e il suo iperonimo
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sHypernym = json.$get("hypernym");
			$(word).text(sWord);
			$(hypernym).text(sHypernym);
			$(hiddenWord).attr("value", sWord);
			$(hiddenHypernym).attr("value", sHypernym);
			
			return null;
		});
		
		//aggiunta degli elementi alla prima form
		$(form1).append(GestioneElementi.divEtichetta(word), GestioneElementi.divEtichetta(hypernym), hiddenWord, hiddenHypernym,
						GestioneElementi.costruisciTextArea("Sulla base della parola fornita e del suo iperonimo, scrivere la definizione opportuna", "150px", "770px"));
		
		addLinksAndButtons(form1,form2, "5% 100%"); //aggiunta dei pulsanti Next e Skip e dei link Logout e Home al body
		
	}
	

}
