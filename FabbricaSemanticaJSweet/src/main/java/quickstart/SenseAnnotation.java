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
 * Classe che rappresenta la costruzione della pagina HTML di annotazione "senseAnnotation"
 */
public class SenseAnnotation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "senseAnnotation.jsp";
	
	/**
	 * Stringa che identifica il nome della task
	 */
	public static final String TASK_NAME = "task=SENSE_ANNOTATION";
	
	public static void main(String[] args) 
	{
		//costruzione dei contenitori principali
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 20%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10% 76%");
		
		//costruzione etichetta che contiene la richiesta
		HTMLLabelElement richiesta = GestioneElementi.costruisciEtichetta("Selezionare il senso che più si addice alla seguente parola");
		$(richiesta).css("font-weight", "bold");
		
		//costruzione etichetta che contiene la parola
		HTMLLabelElement word = document.createElement(StringTypes.label);
		
		//costruzione etichetta che contiene la descrizione
		HTMLLabelElement description = document.createElement(StringTypes.label);
		$(description).css("font-style", "italic");
		
		//input element nascosti per permettere di prelevare la parola e la descrizione nel back-end
		HTMLInputElement hiddenWord = GestioneElementi.costruisciHidden("hiddenWord");
		HTMLInputElement hiddenDescription = GestioneElementi.costruisciHidden("hiddenDescription");
				
		//costruzione delle etichette relative ai sensi
		HTMLLabelElement sense1 = document.createElement(StringTypes.label);
		HTMLLabelElement sense2 = document.createElement(StringTypes.label);
		HTMLLabelElement sense3 = document.createElement(StringTypes.label);
		HTMLLabelElement sense4 = document.createElement(StringTypes.label);
		
		GestioneElementi.setLabelAttributes(new HTMLLabelElement[] { sense1, sense2, sense3, sense4 }, "inline", "top"); //per ogni senso si modificano gli attributi

		//costruzione delle checkbox
		HTMLInputElement checkbox1 = GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
		HTMLInputElement checkbox2 = GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
		HTMLInputElement checkbox3 = GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
		HTMLInputElement checkbox4 = GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
		
		//chiamata a servlet per poter ottenere la parola, la descrizione e i sensi
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String sSense1 = json.$get("firstSense");
			String sSense2 = json.$get("secondSense");
			String sSense3 = json.$get("thirdSense");
			String sSense4 = json.$get("fourthSense");
			$(word).text(sWord);
			$(description).text(sDescription);
			$(sense1).text(sSense1);
			$(sense2).text(sSense2);
			$(sense3).text(sSense3);
			$(sense4).text(sSense4);
			$(checkbox1).attr("value", sSense1);
			$(checkbox2).attr("value", sSense2);
			$(checkbox3).attr("value", sSense3);
			$(checkbox4).attr("value", sSense4);
			$(hiddenWord).attr("value", sWord);
			$(hiddenDescription).attr("value", sDescription);
			
			return null;
		});
		
		//div che contiene gli input element nascosti
		HTMLDivElement divHidden = document.createElement(StringTypes.div);
		$(divHidden).append(hiddenWord, hiddenDescription);
		
		//div la cui funzione è quella di distanziare gli elementi
		HTMLDivElement divSpazio = document.createElement(StringTypes.div);
		$(divSpazio).css("height", "20px");
		
		//ogni checkbox viene inserita all'interno del div
		HTMLDivElement divCb1 = GestioneElementi.divCheckbox(checkbox1, sense1);
		HTMLDivElement divCb2 = GestioneElementi.divCheckbox(checkbox2, sense2);
		HTMLDivElement divCb3 = GestioneElementi.divCheckbox(checkbox3, sense3);
		HTMLDivElement divCb4 = GestioneElementi.divCheckbox(checkbox4, sense4);

		//per ogni div si settano gli attributi
		GestioneElementi.setDivAttributes(new HTMLDivElement[] { divCb1, divCb2, divCb3, divCb4 }, "1px", "99%", "solid", "#007fff", "2px", "4%");

		$(form1).append(GestioneElementi.divEtichetta(richiesta), //aggiunta etichetta richiesta
						GestioneElementi.divEtichetta(word), //aggiunta etichetta parola
						GestioneElementi.divEtichetta(description), //aggiunta etichetta descrizione
						divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden); //aggiunta di checkbox, spazio e input element nascosti
						
		addLinksAndButtons(form1, form2, "5% 0%"); //aggiunta dei pulsanti Next e Skip e dei link Home e Logout
		
	}

}
