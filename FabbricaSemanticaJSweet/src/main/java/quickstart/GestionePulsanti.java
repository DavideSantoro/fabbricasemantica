package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;

/**
 * Classe che disponde di metodi statici utili alla configurazione e alla costruzione
 * dei pulsanti propri di una o più pagine HTML
 */
public class GestionePulsanti 
{
	/**
	 * Metodo che permette la costruzione del pulsante per fare il login
	 * @return un HTMLDivElement che contiene l'HTMLInputElement login configurato
	 */
	public static HTMLDivElement costruisciLogin()
	{
		//costruzione e configurazione del pulsante login
		HTMLInputElement login = document.createElement(StringTypes.input);
		login.type = "submit";
		login.name = "login_button";
		login.className =  "btn btn-primary";
		login.value = "Login";
		$(login).css("margin", "4% 48%");
		
		//costruzione del contenitore
		HTMLDivElement divLogin = document.createElement(StringTypes.div);
		divLogin.className = "form-group";
		$(divLogin).append(login);
		
		return divLogin;
	}
	
	/**
	 * Metodo che permette la costruzione del pulsante per fare il signup
	 * @return un HTMLDivElement che contiene l'HTMLInputElement signup configurato
	 */
	public static HTMLDivElement costruisciSignup()
	{
		//costruzione e configurazione del pulsante signup
		HTMLInputElement signup = document.createElement(StringTypes.input);
		signup.type = "submit";
		signup.name = "signup_button";
		signup.className =  "btn btn-primary";
		signup.value = "Sign Up";
		$(signup).css("margin", "4% 48%");
		
		//costruzione del contenitore
		HTMLDivElement divSignup = document.createElement(StringTypes.div);
		divSignup.className = "form-group";
		$(divSignup).append(signup);
		
		return divSignup;
	}
	
	/**
	 * Metodo che permette la costruzione del pulsante grazie al quale si possono iniziare a svolgere
	 * i task di annotazione/validazione
	 * @return un HTMLDivElement che contiene l'HTMLInputElement start configurato
	 */
	public static HTMLDivElement costruisciStart()
	{
		//costruzione e configurazione del pulsante start
		HTMLInputElement start = document.createElement(StringTypes.input);
		start.type = "image";
		start.name = "start_button";
		start.className =  "btn btn-primary";
		start.src = "http://i.imgur.com/1SEMAUq.png"; //URL dell'immagine che farà parte del pulsante
		$(start).css("width","200px")
				.css("height","200px");
		
		//costruzione del contenitore
		HTMLDivElement divStart = document.createElement(StringTypes.div);
		divStart.className = "form-group";
		$(divStart).append(start);
		
		return divStart;
	}
	
	/**
	 * Metodo che permette la costruzione del pulsante attraverso cui si salvano le informazioni
	 * che l'utente ha inserito all'interno del task e si indirizza l'utente ad una pagina a caso
	 * @return un HTMLDivElement che contiene l'HTMLInputElement next configurato
	 */
	public static HTMLDivElement costruisciNext()
	{
		//costruzione e configurazione del pulsante next
		HTMLInputElement next = document.createElement(StringTypes.input);
		next.type = "submit";
		next.name = "next_button";
		next.className =  "btn btn-primary";
		next.value = "Next";
		
		//costruzione del contenitore
		HTMLDivElement divNext = document.createElement(StringTypes.div);
		divNext.className = "form-group";
		$(divNext).append(next);
		
		return divNext;
	}
	
	/**
	 * Metodo che permette la costruzione del pulsante attraverso cui l'utente viene indirizzato l'utente
	 * ad una pagina a caso senza salvare le informazioni che sono state inserite
	 * @return un HTMLDivElement che contiene l'HTMLInputElement skip configurato
	 */
	public static HTMLDivElement costruisciSkip()
	{
		//costruzione e configurazione del pulsante skip
		HTMLInputElement skip = document.createElement(StringTypes.input);
		skip.type = "submit";
		skip.name = "skip_button";
		skip.className = "btn btn-primary";
		skip.value = "Skip";
		
		//costruzione del contenitore
		HTMLDivElement divSkip = document.createElement(StringTypes.div);
		divSkip.className = "form-group";
		$(divSkip).append(skip);
		
		return divSkip;
	}
	
	
	/**
	 * Metodo che permette la costruzione del pulsante di tipo radio
	 * @param valore stringa che rappresenta il valore del pulsante e il testo dell'etichetta ad esso associata
	 * @return un HTMLDivElement che contiene l'HTMLInputElement di tipo radio configurato
	 */
	public static HTMLDivElement costruisciRadio(String valore)
	{
		//costruzione e configurazione del pulsante di tipo radio
		HTMLInputElement radio = document.createElement(StringTypes.input);
		radio.name = "radio";
		radio.type = "radio";
		radio.value = valore;
		
		//costruzione del contenitore
		HTMLDivElement divRadio = document.createElement(StringTypes.div);
		divRadio.className = "form-group";
		$(divRadio).append(radio, GestioneElementi.costruisciEtichetta(valore));
		
		return divRadio;
	}

	/**
	 * Metodo che permette la costruzione del pulsante con cui è possibile svolgere da capo
	 * il task "myAnnotation"
	 * @param divLettere array di HTMLDivElement che contiene i riferimenti agli elementi trascinabili
	 * @param divDestinazioni array di HTMLDivElement che contiene i riferimenti agli elementi che possono accettare il rilascio
	 * @return un HTMLDivElement che contiene l'HTMLInputElement restart configurato
	 */
	public static HTMLDivElement costruisciRestart(HTMLDivElement[] divLettere, HTMLDivElement[] divDestinazioni)
	{
		//costruzione e configurazione del pulsante restart
		HTMLInputElement restart = document.createElement(StringTypes.input);
		restart.type = "button";
		restart.name = "restart_button";
		restart.className =  "btn btn-primary";
		restart.value = "Restart";
		
		restart.addEventListener(StringTypes.click, event -> { //evento legato all'azione di click sul pulsante
			for (int i = 0; i < divLettere.length; i++)
			{
				$(divLettere[i]).attr("draggable", "true"); //l'elemento precedentemente trascinato torna trascinabile
				$(divLettere[i]).css("border-style", "solid"); //si modifica il contorno
			}
			for (int j = 0; j < divDestinazioni.length; j++)
			{
				$(divDestinazioni[j]).css("border-style", "dashed"); //si modifica il contorno
				$(divDestinazioni[j]).text("_"); //il testo dell'elemento destinazione torna ad essere quello di prima
			}	
			return null;
		});
		
		//costruzione del contenitore
		HTMLDivElement divRestart = document.createElement(StringTypes.div);
        $(divRestart).append(restart);
        
        return divRestart;
	}
}
