package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "wordAnnotation.jsp"
 */
@WebServlet(name = "TaskWordAnnotationServlet", urlPatterns = "/wordAnnotation.jsp")
public class TaskWordAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "Word Annotation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "wordAnnotation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String risposta = request.getParameter("textAreaTask");  //viene prelevato ciò che l'utente ha inserito all'interno della text area
		if (risposta == null || risposta.isEmpty()) GestioneTask.messaggioDiErrore(response, "wordAnnotation.html");
		//se non ha inserito nessuna risposta viene visualizzato il messaggio di errore, altrimenti si salvano i dati	
		else
		{
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", request.getParameter("hiddenDescription") + "\t", risposta + "\t", request);
			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom());
		}

	}

}
