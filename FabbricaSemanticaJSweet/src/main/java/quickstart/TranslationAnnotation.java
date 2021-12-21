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
 * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
 */
public class TranslationAnnotation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "translationAnnotation.jsp";
	/**
	 * Stringa che identifica il nome della task
	 */
	public static final String TASK_NAME = "task=TRANSLATION_ANNOTATION";
	
	public static void main(String[] args) 
	{
		//costruzione form principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 67%");
		
		//costruzione etichetta parola
		HTMLLabelElement word = document.createElement(StringTypes.label);
		
		//costruzione etichetta descrizione
		HTMLLabelElement description = document.createElement(StringTypes.label);
		$(description).css("font-style", "italic");
		
		//costruzione input element nascosti per salvare la parola e la descrizione nel back-end
		HTMLInputElement hiddenWord = GestioneElementi.costruisciHidden("hiddenWord");
		HTMLInputElement hiddenDescription = GestioneElementi.costruisciHidden("hiddenDescription");
		
		//chiamata a servlet per ottenere i dati e per assegnarli alle label
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			$(word).text(sWord);
			$(description).text(sDescription);
			$(hiddenWord).attr("value", sWord);
			$(hiddenDescription).attr("value", sDescription);

			return null;
		});
		
		//aggiunta degli elementi alla form
		$(form1).append(GestioneElementi.divEtichetta(word), GestioneElementi.divEtichetta(description), hiddenWord, hiddenDescription,
						GestioneElementi.costruisciTextArea("Fornire, nella propria lingua madre, una traduzione appropriata di tale parola e della sua definizione", "150px", "770px"));
					
		addLinksAndButtons(form1, form2, "5% 100%"); //aggiunta dei pulsanti Next e Skip e dei link Home e Logout alle form
		
	}
	

}
