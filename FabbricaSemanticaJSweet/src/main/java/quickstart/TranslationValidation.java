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
 * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
 */
public class TranslationValidation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "translationValidation.jsp";
	
	/**
	 * Stringa che identifica il nome della task
	 */
	public static final String TASK_NAME = "task=TRANSLATION_VALIDATION";
	
	public static void main(String[] args) 
	{
		//costruzione dei contenitori principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 62%");
		
		//costruzione etichetta richiesta
		HTMLLabelElement richiesta = GestioneElementi.costruisciEtichetta("Selezionare la traduzione più consona della parola seguente tra quelle proposte");
		$(richiesta).css("font-weight", "bold");
		
		//costruzione etichetta parola
		HTMLLabelElement word = document.createElement(StringTypes.label);
		
		//costruzione etichetta descrizione
		HTMLLabelElement description = document.createElement(StringTypes.label);
		$(description).css("font-style", "italic");
		
		//costruzione input element nascosti per permettere il salvataggio della parola e della descrizione nel back-end
		HTMLInputElement hiddenWord = GestioneElementi.costruisciHidden("hiddenWord");
		HTMLInputElement hiddenDescription = GestioneElementi.costruisciHidden("hiddenDescription");
		
		//costruzione delle etichette corrispondenti alle traduzioni e di un'etichetta il cui testo è fissato
		HTMLLabelElement translation1 = document.createElement(StringTypes.label);
		HTMLLabelElement translation2 = document.createElement(StringTypes.label);
		HTMLLabelElement translation3 = document.createElement(StringTypes.label);
		HTMLLabelElement noTranslation = GestioneElementi.costruisciEtichetta("Nessuna delle traduzioni proposte è corretta");
		
		//per ogni etichetta che contiene la traduzione si settano gli attributi
		GestioneElementi.setLabelAttributes(new HTMLLabelElement[] { translation1, translation2, translation3, noTranslation }, "inline", "top");
		
		//costruzione delle checkbox
		HTMLInputElement checkbox1 = GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
		HTMLInputElement checkbox2 = GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
		HTMLInputElement checkbox3 = GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
		HTMLInputElement checkbox4 = GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
		
		//chiamata a servlet per prelevare i dati ed assegnarli ai vari elementi
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description");
			String sTranslation1 = json.$get("firstTranslation");
			String sTranslation2 = json.$get("secondTranslation");
			String sTranslation3 = json.$get("thirdTranslation");
			$(word).text(sWord);
			$(description).text(sDescription);
			$(translation1).text(sTranslation1);
			$(translation2).text(sTranslation2);
			$(translation3).text(sTranslation3);
			$(checkbox1).attr("value", sTranslation1);
			$(checkbox2).attr("value", sTranslation2);
			$(checkbox3).attr("value", sTranslation3);
			$(checkbox4).attr("value", "Nessuna");
			$(hiddenWord).attr("value", sWord);
			$(hiddenDescription).attr("value", sDescription);
			
			return null;
		});
		
		//costruzione di un div allo scopo di aggiungere spazio tra elementi
		HTMLDivElement divSpazio = document.createElement(StringTypes.div);
		$(divSpazio).css("height", "20px");
		
		//costruzione del contenitore degli input element nascosti
		HTMLDivElement divHidden = document.createElement(StringTypes.div);
		$(divHidden).append(hiddenWord, hiddenDescription);

		//costruzione dei contenitori delle checkbox
		HTMLDivElement divCb1 = GestioneElementi.divCheckbox(checkbox1, translation1);
		HTMLDivElement divCb2 = GestioneElementi.divCheckbox(checkbox2, translation2);
		HTMLDivElement divCb3 = GestioneElementi.divCheckbox(checkbox3, translation3);
		HTMLDivElement divCb4 = GestioneElementi.divCheckbox(checkbox4, noTranslation);
		
		//per ogni div vengono settati gli attributi
		GestioneElementi.setDivAttributes(new HTMLDivElement[] { divCb1, divCb2, divCb3, divCb4 }, "1px", "76%", "solid", "#007fff", "2px", "4%");
		
		//aggiunta degli elementi alla form
		$(form1).append(GestioneElementi.divEtichetta(richiesta),
						GestioneElementi.divEtichetta(word),
						GestioneElementi.divEtichetta(description),
						divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden);
		
		addLinksAndButtons(form1, form2, "5% 0%"); //aggiunta alle form dei pulsanti Next e Skip e dei link Home e logout
		
	}

}

