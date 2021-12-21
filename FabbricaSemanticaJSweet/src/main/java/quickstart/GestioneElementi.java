package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import java.util.ArrayList;
import java.util.Arrays;
import def.dom.DataTransfer;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQuery;
import jsweet.util.StringTypes;

/**
 * Classe che dispone di metodi statici utili alla configurazione e alla costruzione
 * degli elementi che compongono la struttura delle pagine HTML
 */
public class GestioneElementi 
{
	/**
	 * Metodo che serve per la costruzione di una form
	 * @param servlet stringa corrispondente all'URL a cui va inviato il messaggio per fare il submit
	 * @param margine stringa associata all'attributo che permette di modificare la posizione della form all'interno della pagina
	 * @return un HTMLFormElement che rappresenta il contenitore principale
	 */
	public static HTMLFormElement costruisciForm(final String servlet, String margine)
	{
		//creazione della form
		HTMLFormElement form = document.createElement(StringTypes.form); 
		form.action = servlet; //si imposta a quale URL inviare i dati
		form.method = "POST"; 
		$(form).css("margin", margine); //posizione della form
		
		return form;
	}
	
	/**
	 * Metodo che serve a costruire il titolo di una pagina HTML
	 * @param titolo stringa corrispondente al titolo della pagina
	 * @return un HTMLDivElement che contiene un HTMLLabelElement con il testo uguale al titolo
	 */
	public static HTMLDivElement costruisciTitolo(String titolo)
	{	
		HTMLLabelElement labelTitle = costruisciEtichetta(titolo); //costruzione etichetta
		$(labelTitle).css("font-weight", "bold")
		 			 .css("font-size", "23px"); //modifiche del font
		
		return divEtichetta(labelTitle);
	}
	
	/**
	 * Metodo che serve a costruire lo spazio di testo in cui l'utente può inserire la sua email
	 * @return un HTMLDivElement che contiene l'HTMLInputElement email
	 */
	public static HTMLDivElement costruisciEmail()
	{
		//costruzione e configurazione dell'elemento email
		HTMLInputElement emailAddress = document.createElement(StringTypes.input);
		emailAddress.type = "email";
		emailAddress.name = "email";
		
		//costruzione del contenitore
		HTMLDivElement divEmailAddress = document.createElement(StringTypes.div);
		divEmailAddress.className = "form-group";
		$(divEmailAddress).append(costruisciEtichetta("Email"), emailAddress);
		
		return divEmailAddress;
		
	}
	
	/**
	 * Metodo che serve a costruire lo spazio di testo in cui l'utente può inserire la sua password
	 * @param contenuto stringa che serve a settare il testo della label associata all'elemento password
	 * @return un HTMLDivElement che contiene l'HMTLInputElement password configurato
	 */
	public static HTMLDivElement costruisciPassword(String contenuto)
	{
		//costruzione e configurazione dell'elemento password
		HTMLInputElement password = document.createElement(StringTypes.input);
		password.type = "password";
		password.name = contenuto;
		
		//costruzione del contenitore
		HTMLDivElement divPassword = document.createElement(StringTypes.div);
		divPassword.className = "form-group";
		$(divPassword).append(costruisciEtichetta(contenuto), password);
		
		return divPassword;
	}
	
	/**
	 * Metodo che serve a costruire la checkbox che può essere spuntata dall'utente
	 * @param nome stringa associata al nome della checkbox
	 * @param altezza stringa associata all'attributo che consente di modificare l'altezza della checkbox
	 * @param larghezza stringa associata all'attributo che consente di modificare la larghezza della checkbox
	 * @return un HTMLInputElement che rappresenta la checkbox configurata
	 */
	public static HTMLInputElement costruisciCheckbox(String nome, String altezza, String larghezza)
	{
		//costruzione e configurazione checkbox
		HTMLInputElement checkbox = document.createElement(StringTypes.input);
		checkbox.type = "checkbox";
		checkbox.name = nome;
		
		$(checkbox).css("width", larghezza)
				   .css("height", altezza); //si modifica l'altezza e la larghezza della checkbox
		
		return checkbox;
	}
	
	/**
	 * Metodo che serve a costruire il contenitore della checkbox
	 * @param checkbox HTMLInputElement che viene appeso al contenitore 
	 * @param label HTMLLabelElement associato alla checkbox
	 * @return un HTMLDivElement che contiene l'HTMLInputElement configurato
	 */
	public static HTMLDivElement divCheckbox(HTMLInputElement checkbox, HTMLLabelElement label)
	{
		//costruzione dell'elemento che conterrà la checkbox
		HTMLDivElement divCheckbox = document.createElement(StringTypes.div);
		divCheckbox.className = "form-group";
		$(divCheckbox).append(checkbox, label);
		
		return divCheckbox;
	}
	
	/**
	 * Metodo che serve per costruire un'etichetta testuale
	 * @param testo stringa corrispondente al contenuto dell'etichetta
	 * @return un HTMLLabelElement che rappresenta l'etichetta configurata
	 */
	public static HTMLLabelElement costruisciEtichetta(String testo)
	{
		//costruzione di una label
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = testo;
		return label;
	}
	
	/**
	 * Metodo che serve per costruire il contenitore dell'etichetta
	 * @param etichetta HTMLLabelElement che viene appeso al contenitore
	 * @return un HTMLDivElement che contiene l'HTMLLabelElement configurato
	 */
	public static HTMLDivElement divEtichetta(HTMLLabelElement etichetta)
	{
		//costruzione del contenitore della label
		HTMLDivElement divLabel = document.createElement(StringTypes.div);
		divLabel.className = "form-group";
		$(divLabel).append(etichetta);
		
		return divLabel;
	}
	
	/**
	 * Metodo che serve per settare degli attributi CSS di ciascuna label presente nell'array passato come parametro
	 * @param arrayLabel array di HTMLLabelElement che contiene i riferimenti alle etichette testuali di cui si vogliono settare gli attributi
	 * @param display stringa associata all'attributo che permette di modificare il display della label
	 * @param align stringa associata all'attributo che permette di modificare l'allineamento testuale della label
	 */
	public static void setLabelAttributes(HTMLLabelElement[] arrayLabel, String display, String align)
	{
		for (int i = 0; i < arrayLabel.length; i++)
		{
			$(arrayLabel[i]).css("display", display)
							.css("vertical-align", align); //per ogni etichetta nell'array si setta il display e l'allineamento
		}
	}
	
	/**
	 * Metodo che serve per settare degli attributi CSS di ciascun Div presente nell'array passato come parametro
	 * @param arrayDiv array di HTMLDivElement che contiene i riferimenti ai contenitori di cui si vogliono settare gli attributi
	 * @param margine stringa associata all'attributo che consente di modificare la posizione del Div all'interno della pagina
	 * @param lunghezza stringa associata all'attributo che consente di modificare la lunghezza del Div
	 * @param stile stringa associata all'attributo che consente di modificare lo stile del Div
	 * @param colore stringa associata all'attributo che consente di modificare il colore del Div
	 * @param spessore stringa associata all'attributo che consente di modificare lo spessore del Div
	 * @param altezza stringa associata all'attributo che consente di modificare l'altezza del Div
	 */
	public static void setDivAttributes(HTMLDivElement[] arrayDiv, String margine, String lunghezza, String stile, String colore, String spessore, String altezza)
	{
		for (int i = 0; i < arrayDiv.length; i++)
		{
			$(arrayDiv[i]).css("margin", margine)
				  		  .css("border-width", spessore)
				  		  .css("border-style", stile)
				  		  .css("border-color","#007fff")
				  		  .css("width", lunghezza)
				  		  .css("height", altezza); //si settano gli attributi per ogni Div nell'array
		}
 
	}
	
	/**
	 * Metodo che serve per costruire un'area di testo
	 * @param testo stringa contenuta nell'etichetta associata all'area di testo
	 * @param altezza stringa associata all'attributo che permette di modificare l'altezza dell'area di testo
	 * @param larghezza stringa associata all'attributo che permette di modificare la larghezza dell'area di testo
	 * @return un HTMLDivElement che contiene l'HTMLTextAreaElement configurato
	 */
	public static HTMLDivElement costruisciTextArea(String testo, String altezza, String larghezza)
	{
		//Costruzione e configurazione della text area
		HTMLTextAreaElement textAreaTask = document.createElement(StringTypes.textarea);
		textAreaTask.name = "textAreaTask"; 
		textAreaTask.className =  "form-control";
		textAreaTask.placeholder = "Inserisci qui la tua risposta";
		$(textAreaTask).css("width", larghezza)
					   .css("height", altezza); //si modifica l'altezza e la larghezza della text area
		
		//Costruzione del contenitore
		HTMLDivElement divTask = document.createElement(StringTypes.div);
		divTask.className = "form-group";
		HTMLLabelElement label = GestioneElementi.costruisciEtichetta(testo);
		$(label).css("white-space", "nowrap") //permette di inserire il testo dell'etichetta su un'unica riga
		        .css("font-weight", "bold"); //modifica del font
		$(divTask).append(label, textAreaTask);
		
		return divTask;
		
	}
		
	/**
	 * Metodo che permette di creare un elenco con delle opzioni
	 * @param nome stringa corrispondente al nome dell'HTMLSelectElement
	 * @return un HTMLDivElement che contiene l'HTMLSelectElement configurato
	 */
	public static HTMLDivElement costruisciSelect(String nome)
	{
		//costruzione dell'elenco
		HTMLSelectElement selezione = document.createElement(StringTypes.select);
		selezione.name = nome;
		HTMLOptionElement primaOpzione = document.createElement(StringTypes.option);
		primaOpzione.text = "...";
		selezione.add(primaOpzione); //aggiunta della prima opzione
		
		//si delega ad un metodo la costruzione delle opzioni che vengono aggiunte all'elenco
		ArrayList<HTMLOptionElement> listaOpzioni = creaOpzioni(new ArrayList<>(Arrays.asList("Francese","Russo","Spagnolo","Tedesco")));
		for (HTMLOptionElement o : listaOpzioni) selezione.add(o); 
		
		//costruzione del contenitore
		HTMLDivElement divSelezione = document.createElement(StringTypes.div);
		divSelezione.className = "form-group";
		$(divSelezione).append(selezione);
		
		return divSelezione;
	}
	
	/**
	 * Metodo che serve per costruire un elemento non visibile all'interno della pagina
	 * @param nome stringa associata al nome dell'HTMLInputElement nascosto
	 * @return un HTMLInputElement con type hidden configurato
	 */
	public static HTMLInputElement costruisciHidden(String nome)
	{
		//creazione e configurazione di un elemento nascosto
		HTMLInputElement inputHidden = document.createElement(StringTypes.input);
		inputHidden.type = "text";
		inputHidden.hidden = true;
		inputHidden.name = nome;
		
		return inputHidden;
	}
	
	/**
	 * Metodo che serve per costruire un elemento che può subire l'azione di trascinamento
	 * @return un HTMLDivElement configurato affinché possa essere trascinabile
	 */
	public static HTMLDivElement costruisciDrag()
	{
		HTMLDivElement divLettera = document.createElement(StringTypes.div);
		//attributi che consentono di cambiare la grafica dell'elemento che deve essere trascinato
		$(divLettera).css("border-width", "5px")
       				 .css("border-style", "solid")
       				 .css("border-color","#ffffff")
       				 .css("font-size","50px")
       				 .css("margin", "8% 8%")
       				 .css("font-family", "Comic Sans")
       				 .css("text-align", "center")
       				 .css("display","inline")
       				 .css("vertical-align","top")
       				 .attr("draggable", "true") // si imposta l'attributo draggable a true per rendere l'elemento trascinabile
       				 .on("dragstart", (event, data) -> {  // funzione associata all'evento che notifica l'inizio del trascinamento
       					 // struttura che contiene i dati che vogliamo siano disponibili all'oggetto incaricato del drop
       					 DataTransfer dataTransfer = (DataTransfer) event.originalEvent.$get("dataTransfer"); 
       					 dataTransfer.setData("char", $(event.target).text()); // imposta l'operazione di trascinamento sui dati e sul tipo specificati
       					 dataTransfer.effectAllowed = "move"; // segnala che l'azione di drag è da intendersi come spostamento
       					 return null;
       				 })
       				 .on("dragend", (event,data) -> { //funzione associata all'evento che notifica la fine del trascinamento
       					 DataTransfer dataTransfer = (DataTransfer) event.originalEvent.$get("dataTransfer");
       					 event.preventDefault(); //nega il comportamento di default del browser
       					 //se il trascinamento ha avuto successo si modificano gli attributi del div trascinato
       					 if (!dataTransfer.dropEffect.equals("none"))
       					 {
       						 $(divLettera).attr("draggable", "false")
       						 			  .css("border-style", "dashed");
       					 }

       					 return null;
       				 });
		
		
		return divLettera;
	}
	
	/**
	 * Metodo che serve per costruire un elemento che può subire l'azione di rilascio
	 * @param inputHidden HTMLInputElement con type hidden il cui valore verrà settato con il testo dell'elemento trascinato
	 * @return un HTMLDivElement configurato affinché possa accettare gli elementi trascinati
	 */
	public static HTMLDivElement costruisciDrop(HTMLInputElement inputHidden)
	{
		HTMLDivElement divDestinazione = document.createElement(StringTypes.div);
		//attributi che modificano la grafica dell'elemento che subisce il rilascio
		$(divDestinazione).css("border-width", "5px")
						  .css("border-style", "dashed")
						  .css("border-color","#007fff")
						  .css("display","inline")
						  .text("_")
						  .css("font-size", "50px")
						  .css("margin", "50% 8%")
						  .on("dragover", (event, data) -> { // funzione associata al periodo in cui si sta trascinando qualcosa finché non la si rilascia
							  event.preventDefault();
							  return null;
						  })
						  .on("drop", (event, data) -> { // funzione associata all'evento di rilascio di un elemento sopra l'area di drop
							  event.preventDefault();
							  $(divDestinazione).css("border-style", "solid");
							  JQuery target = $(event.target);
							  DataTransfer dataTransfer = (DataTransfer) event.originalEvent.$get("dataTransfer");
							  target.text(dataTransfer.getData("char")); // recupera i dati di trascinamento per il tipo specificato e li setta in target            
							  $(inputHidden).attr("value",dataTransfer.getData("char")); //si assegna all'input element nascosto il testo dell'elemento trascinato
	            
							  return null;
						  });
		
		return divDestinazione;
	}
	
	/**
	 * Metodo che serve per costruire le opzioni che fanno parte dell'HTMLSelectElement
	 * @param opzioni ArrayList di stringhe corrispondenti al testo che verrà associato ai vari HTMLOptionElement
	 * @return un ArrayList di HTMLOptionElement utile ad aggiungere opzioni all'elenco
	 */
	private static ArrayList<HTMLOptionElement> creaOpzioni(ArrayList<String> opzioni)
	{
		ArrayList<HTMLOptionElement> listaOpzioni = new ArrayList<>();
		for (String s : opzioni) //per ogni stringa viene creata un'opzione
		{
			HTMLOptionElement opzioneA1 = document.createElement(StringTypes.option);
			HTMLOptionElement opzioneA2 = document.createElement(StringTypes.option);
			HTMLOptionElement opzioneB1 = document.createElement(StringTypes.option);
			HTMLOptionElement opzioneB2 = document.createElement(StringTypes.option);
		    HTMLOptionElement opzioneC1 = document.createElement(StringTypes.option);
		    HTMLOptionElement opzioneC2 = document.createElement(StringTypes.option);
			
		    //viene settato il testo di ogni opzione
			opzioneA1.text = s + " (A1)";
			opzioneA2.text = s + " (A2)";
			opzioneB1.text = s + " (B1)";
			opzioneB2.text = s + " (B2)";
			opzioneC1.text = s + " (C1)";
			opzioneC2.text = s + " (C2)";
			
			//ad ogni iterazione verrà aggiunta nella lista la lingua con i vari livelli
			listaOpzioni.addAll(Arrays.asList(opzioneA1, opzioneA2, opzioneB1, opzioneB2, opzioneC1, opzioneC2));

		}
		
		return listaOpzioni;
	}
	


}
