package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.DataProvider;
import it.uniroma1.fabbricasemantica.data.StandardDataProvider;
import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.data.Task;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Classe che rappresenta la servlet invocata all'indirizzo "nextExample.jsp"
 */
@WebServlet(name="NewExampleServlet", urlPatterns="/nextExample.jsp")
public class NewExampleServiceServlet extends BaseServlet {
	private static final long serialVersionUID = 8783416660707020469L;
	private Map<String, Task> tasks;
	private DataProvider<String> dataProvider;
	
	/**
	 *  Il metodo init() e' da considerarsi il costruttore della classe.
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		//TODO se implementata, instanziare la propria classe DataProvider
		dataProvider = new StandardDataProvider();
		tasks = Arrays.stream(StandardTask.values()).collect(Collectors.toMap(Task::getTaskID, s -> s));
		//TODO tasks.put(myTask.getTaskID(), myTask);
		
	}

	/**
	 * Metodo all'interno del quale viene implementata la logica che permette di prendere il parametro "task"
	 * che indica il task per il quale si vuole il prossimo esempio
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sTask = (String) request.getParameter("task");
		Task task = tasks.get(sTask);
		String json = dataProvider.getData(task);
		response.getWriter().write(json);
	}


}
