package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Classe che dispone di metodi statici utili alla gestione di informazioni e istruzioni associate
 * ai vari task di annotazione/validazione
 */
public class GestioneTask 
{
	/**
	 * Stringa che rappresenta il percorso del database
	 */
	public static final String PERCORSO_DATABASE = File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "database.tsv";
	
	/**
	 * Metodo che serve per generare un URL casuale
	 * @return una stringa che identifica una pagina di annotazione/validazione
	 */
	public static String paginaRandom()
	{
		String pagina = null;
		int i = (int) (Math.random() * 7);
		switch(i)
		{
			case 0 : pagina = "definitionAnnotation.html"; break;
			case 1 : pagina = "myAnnotation.html"; break;
			case 2 : pagina = "senseAnnotation.html"; break;
			case 3 : pagina = "senseValidation.html"; break;
			case 4 : pagina = "translationAnnotation.html"; break;
			case 5 : pagina = "translationValidation.html"; break;
			case 6 : pagina = "wordAnnotation.html"; break;
		}
		
		return pagina;
	}
	
	/**
	 * Metodo che serve per salvare le informazioni inserite dall'utente all'interno del database
	 * @param task stringa che identifica il nome del task in cui l'utente inserisce le informazioni
	 * @param datiForniti stringa che rappresenta i dati forniti all'utente per rispondere
	 * @param datiInviati stringa che rappresenta i dati immessi dall'utente per rispondere
	 * @param request request della servlet
	 */
	public static void salvataggioDati(String task, String datiForniti, String datiInviati, HttpServletRequest request) 
	{
		Path p = Paths.get(request.getServletContext().getRealPath(PERCORSO_DATABASE));
		File db = p.toFile();
		HttpSession session = request.getSession();
		
		//scrittura dei dati all'interno del database
		try(PrintWriter pw = new PrintWriter(new FileWriter(db,true))) { pw.println(task + datiForniti + datiInviati + session.getAttribute("username")); }
		
		catch(IOException e) { e.printStackTrace(); }
	
	}
	
	/**
	 * Metodo che serve a far visualizzare un messaggio di errore
	 * @param response response della servlet
	 * @param url stringa che rappresenta l'url della pagina a cui l'utente verrà indirizzato
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void messaggioDiErrore(HttpServletResponse response, String url) throws ServletException, IOException
	{
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true); //permette la visualizzazione del messaggio di errore sempre nella pagina in cui ci si trova
		JOptionPane.showMessageDialog(dialog, "Non è stata inserita nessuna risposta"); //permette di far visualizzare la finestra di errore
		response.sendRedirect(url); //l'utente viene indirizzato all'url passato come parametro
	}
	
	

}
