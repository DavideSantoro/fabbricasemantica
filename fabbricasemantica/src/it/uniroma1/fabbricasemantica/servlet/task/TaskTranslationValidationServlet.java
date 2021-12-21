package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "translationValidation.jsp"
 */
@WebServlet(name = "TaskTranslationValidationServlet", urlPatterns = "/translationValidation.jsp")
public class TaskTranslationValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "Translation Validation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "translationValidation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] arrayTranslations = request.getParameterValues("checkboxTranslations"); //array delle stringhe associate alle checkbox che sono state selezionate dall'utente
		//se l'utente ha selezionato almeno una checkbox, allora viene salvata ciascuna stringa corrispondente alla checkbox spuntata, separata da uno \t
		if (arrayTranslations != null)
		{
			String dati = "";
			for (int i = 0; i < arrayTranslations.length; i++) dati += arrayTranslations[i] + "\t";
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", request.getParameterValues("hiddenWord")[0] + " - " + request.getParameterValues("hiddenDescription")[0] + "\t", dati, request);
			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom());
		}
		//altrimenti viene visualizzato un messaggio di errore
		else GestioneTask.messaggioDiErrore(response, "translationValidation.html");

	}

}
