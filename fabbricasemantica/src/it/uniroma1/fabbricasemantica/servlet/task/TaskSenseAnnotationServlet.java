package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet che viene invocata all'indirizzo "senseAnnotation.jsp"
 */
@WebServlet(name = "TaskSenseAnnotationServlet", urlPatterns = "/senseAnnotation.jsp")
public class TaskSenseAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "Sense Annotation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "senseAnnotation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String[] arraySenses = request.getParameterValues("checkboxSenses"); //array che contiene le stringhe associate alle checkbox selezionate dall'utente
		//se è stata inserita almeno una risposta, ciascuna stringa associata alla checkbox spuntata viene salvata e separata da uno \t
		if (arraySenses != null)
		{
			String risposta = "";
			for (int i = 0; i < arraySenses.length; i++) risposta += arraySenses[i] + "\t";
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", request.getParameterValues("hiddenWord")[0] + " - " + request.getParameterValues("hiddenDescription")[0] + "\t", risposta, request);
			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom());
		}
		//altrimenti viene visualizzato un messaggio di errore
		else GestioneTask.messaggioDiErrore(response, "senseAnnotation.html");

	}

}
