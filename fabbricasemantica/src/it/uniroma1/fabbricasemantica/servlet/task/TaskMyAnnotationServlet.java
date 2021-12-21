package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet che viene invocata all'indirizzo "myAnnotation.jsp"
 */
@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stringa che rappresenta il nome del task
	 */
	private static final String TASK_NAME = "My Annotation";

	/**
	 * Metodo che serve per ricavare le informazioni presenti nella pagina "myAnnotation.html"
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Vengono prelevate le lettere dagli elementi che hanno subito il drop
		String lettera1 = request.getParameterValues("hidden1")[0];
		String lettera2 = request.getParameterValues("hidden2")[0];
		String lettera3 = request.getParameterValues("hidden3")[0];
		String lettera4 = request.getParameterValues("hidden4")[0];
		String lettera5 = request.getParameterValues("hidden5")[0];
		String risposta = lettera1 + lettera2 + lettera3 + lettera4 + lettera5;
		
		if (risposta.length() != 5) GestioneTask.messaggioDiErrore(response, "myAnnotation.html");
		//se la risposta non è lunga cinque caratteri viene visualizzato un messaggio di errore, altrimenti si procede con il salvataggio
		else 
		{
			//TODO Salvare i dati
			GestioneTask.salvataggioDati(TASK_NAME + "\t", "" + "\t", risposta + "\t", request);
			//TODO reinderizzare a un task a caso.
			response.sendRedirect(GestioneTask.paginaRandom()); 
		}
	}

}
