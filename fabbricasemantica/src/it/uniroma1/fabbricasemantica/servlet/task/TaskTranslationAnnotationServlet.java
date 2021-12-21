package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "translationAnnotation.jsp"
 */
@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "Translation Annotation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "translationAnnotation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String risposta = request.getParameter("textAreaTask"); //viene prelevato ciò che l'utente ha digitato all'interno della text area
		
		if (risposta.isEmpty() || risposta == null) GestioneTask.messaggioDiErrore(response, "translationAnnotation.html");
		//se l'utente non ha inserito nessuna risposta allora viene visualizzato un messaggio di errore, altrimenti si procede con il salvataggio dei dati
		else
		{
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", request.getParameter("hiddenWord") + " - " + request.getParameter("hiddenDescription") + "\t", risposta + "\t", request);
			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom());
		}
		
		
		
	}

}
