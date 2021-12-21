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
 * Classe che rappresenta la costruzione della pagina HTML di annotazione "wordAnnotation"
 */
public class WordAnnotation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "wordAnnotation.jsp";
	
	/**
	 * Stringa che identifica il nome della task
	 */
	public static final String TASK_NAME = "task=WORD_ANNOTATION";
	
	public static void main(String[] args) 
	{
		//costruzione dei contenitori principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 67%");
		
		//etichetta di testo relativa alla descrizione
		HTMLLabelElement description = document.createElement(StringTypes.label);
		$(description).css("font-style", "italic");
		
		//input element nascosto per poter salvare il testo della descrizione nel back-end
		HTMLInputElement hiddenDescription = GestioneElementi.costruisciHidden("hiddenDescription");
		
		//chiamata a servlet con cui si ottiene il dato che viene assegnato all'etichetta e all'input nascosto
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description"); 
			$(description).text(sDescription);
			$(hiddenDescription).attr("value", sDescription);
			
			return null;
		});
	
		//aggiunta di elementi alla form
		$(form1).append(GestioneElementi.divEtichetta(description), hiddenDescription,
						GestioneElementi.costruisciTextArea("Tentare di associare alla definizione data la parola corrispondente", "150px", "770px"));
	
		addLinksAndButtons(form1, form2, "5% 100%"); //aggiunta alla form dei pulsanti Next e Skip e dei link Home e Logout
		
		
	}

}
