package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet che viene invocata all'indirizzo "senseValidation.jsp"
 */
@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "Sense_Validation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "senseValidation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String risposta = request.getParameter("radio"); //viene prelevata la risposta dell'utente
		if (risposta != null)
		{
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", request.getParameterValues("hiddenWord")[0] + " - " + request.getParameterValues("hiddenExample")[0] + "\t" + 
										 request.getParameterValues("hiddenSense")[0] + "\t", risposta + "\t", request);

			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom());
		}
		//se l'utente ha selezionato almeno un pulsante allora si procede con il salvataggio dei dati, altrimenti viene visualizzato un messaggio di errore
		else GestioneTask.messaggioDiErrore(response, "senseValidation.html");

	}

}
