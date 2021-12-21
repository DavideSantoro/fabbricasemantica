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
 * Classe che rappresenta la costruzione della pagina HTML di annotazione "myAnnotation"
 */
public class MyAnnotation extends AnnotationValidation
{
	/**
	 * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
	 */
	public static final String SERVLET_URL = "myAnnotation.jsp";
	
	/**
	 * Stringa che identifica il nome del task
	 */
	public static final String TASK_NAME = "task=MY_ANNOTATION";
		
	public static void main(String[] args) 
	{	
		//costruzione delle form
		HTMLFormElement form1 = GestioneElementi.costruisciForm(SERVLET_URL, "5% 23%");
		HTMLFormElement form2 = GestioneElementi.costruisciForm(RANDOM_URL, "-10.5% 75%");
		
		//costruzione etichetta della richiesta
		HTMLLabelElement richiesta = GestioneElementi.costruisciEtichetta("Comporre la parola associata alla definizione trascinando le lettere nei riquadri bianchi all'interno dei riquadri blu");
		$(richiesta).css("font-weight", "bold")
					.css("white-space", "nowrap");
		
		//costruzione etichetta della descrizione
		HTMLLabelElement description = document.createElement(StringTypes.label);
		$(description).css("font-style", "italic");
		
		//costruzione degli elementi che possono essere trascinati
		HTMLDivElement divPrimaLettera = GestioneElementi.costruisciDrag();
		HTMLDivElement divSecondaLettera = GestioneElementi.costruisciDrag();
		HTMLDivElement divTerzaLettera = GestioneElementi.costruisciDrag();
		HTMLDivElement divQuartaLettera = GestioneElementi.costruisciDrag();
		HTMLDivElement divQuintaLettera = GestioneElementi.costruisciDrag();
		
		//si inizializza un array il cui ordine viene poi modificato 
		int[] arrayInteri = new int[] { 0,1,2,3,4 };
		for (int i = 4; i > 0; i--)
		{
			int randomInt = (int) Math.floor(Math.random() * i); //genera un numero casuale più piccolo di i
			int lastInt = arrayInteri[i]; //si salva l'intero che si trova nella posizione i
			arrayInteri[i] = arrayInteri[randomInt]; //si scambia l'elemento alla posizione i con l'elemento alla posizione random
			arrayInteri[randomInt] = lastInt; //si scambia l'elemento alla posizione random con l'elemento che si trovava alla posizione i 
		}
		
		//chiamata a servlet che permette di prelevare i dati
		$.getJSON(REST_URL, TASK_NAME, (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description");
			$(description).text(sDescription);
			$(divPrimaLettera).text(sWord.charAt(arrayInteri[0]) + "");
			$(divSecondaLettera).text(sWord.charAt(arrayInteri[1]) + "");
			$(divTerzaLettera).text(sWord.charAt(arrayInteri[2]) + "");
			$(divQuartaLettera).text(sWord.charAt(arrayInteri[3]) + "");
			$(divQuintaLettera).text(sWord.charAt(arrayInteri[4]) + "");;
			
			return null;
		});
		
		//costruzione di un div vuoto con lo scopo di inserire margine tra l'elemento trascinabile e l'elemento di destinazione
		HTMLDivElement divSpazio = document.createElement(StringTypes.div);
       	$(divSpazio).css("height","5px");
		$(divSpazio).css("width", "90px");
		$(divSpazio).css("margin", "5% 10%");		
		
		//costruzione di input element nascosti per salvare il testo dei dati trascinati
		HTMLInputElement hiddenInput1 = GestioneElementi.costruisciHidden("hidden1");
		HTMLInputElement hiddenInput2 = GestioneElementi.costruisciHidden("hidden2");
		HTMLInputElement hiddenInput3 = GestioneElementi.costruisciHidden("hidden3");
		HTMLInputElement hiddenInput4 = GestioneElementi.costruisciHidden("hidden4");
		HTMLInputElement hiddenInput5 = GestioneElementi.costruisciHidden("hidden5");
		
		//costruzione degli elementi che possono subire il drop
		HTMLDivElement divDestinazione1 = GestioneElementi.costruisciDrop(hiddenInput1);
		HTMLDivElement divDestinazione2 = GestioneElementi.costruisciDrop(hiddenInput2);
		HTMLDivElement divDestinazione3 = GestioneElementi.costruisciDrop(hiddenInput3);
		HTMLDivElement divDestinazione4 = GestioneElementi.costruisciDrop(hiddenInput4);
		HTMLDivElement divDestinazione5 = GestioneElementi.costruisciDrop(hiddenInput5);
		
		//aggiunta degli input element nascosti al div
		HTMLDivElement divInputHidden = document.createElement(StringTypes.div);
		$(divInputHidden).append(hiddenInput1, hiddenInput2, hiddenInput3, hiddenInput4, hiddenInput5);
		
		//aggiunta elementi alla prima form
		$(form1).append(divInputHidden, GestioneElementi.divEtichetta(richiesta), 
						$(GestioneElementi.divEtichetta(description)).css("margin","3% 0%"), 
						divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5, divSpazio,
						divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera,
						$(GestionePulsanti.costruisciNext()).css("margin-top", "23px"),
						GestionePulsanti.costruisciRestart(new HTMLDivElement[] { divPrimaLettera, divSecondaLettera, divTerzaLettera, divQuartaLettera, divQuintaLettera }, new HTMLDivElement[] { divDestinazione1, divDestinazione2, divDestinazione3, divDestinazione4, divDestinazione5 }),
						$(GestioneLink.costruisciHome()).css("margin-top", "15px"));
       
	   //aggiunta elementi alla seconda form
       $(form2).append($(GestionePulsanti.costruisciSkip()).css("margin-top", "22px"), GestioneLink.costruisciLogout("4% 100%"));
       
       costruisciPagina(form1, form2); //aggiunta delle form al body
	}
	
	
}
