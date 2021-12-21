package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe che dispone di un metodo statico utile alla gestione dei controlli che vengono effettuati
 * all'interno delle pagine di login e di registrazione
 */
public class GestioneUser 
{
	/**
	 * Stringa che rappresenta il percorso del database
	 */
	public static final String PERCORSO_DATABASE = File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "database.tsv";
	
	/**
	 * Metodo che serve alla visualizzazione di un messaggio di errore
	 * @param response responde della servlet
	 * @param messaggio stringa contenuta nel messaggio che verrà visualizzato
	 * @param url stringa che rappresenta la pagina a cui l'utente verrà indirizzato
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void messaggioDiErrore(HttpServletResponse response, String messaggio, String url) throws ServletException, IOException
	{
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true); //permette la visualizzazione del messaggio di errore sempre nella pagina in cui ci si trova
		JOptionPane.showMessageDialog(dialog, messaggio); //permette di far visualizzare la finestra di errore
		response.sendRedirect(url); //l'utente viene indirizzato alla pagina che corrisponde all'url
	}
}
