package it.uniroma1.fabbricasemantica.wordnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che permette di fornire al sistema delle traduzioni
 */
public class WordNetTranslation 
{
	/**
	 * Stringa che rappresenta il percorso in cui si trova il file da cui sono prelevate
	 * le informazioni sulle traduzioni
	 */
	private static final String PERCORSO_TRADUZIONI = System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "fabbricasemantica" + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "translations.txt";
	
	/**
	 * Mappa creata per salvare le parole in una lingua come chiavi e le rispettive traduzioni come valori
	 */
	private Map<String, String> mappaTraduzioni = new HashMap<>();
	
	/**
	 * Costruttore in cui viene popolata la mappa con le coppie "parola", "traduzione"
	 */
	public WordNetTranslation()
	{
		try(BufferedReader br = new BufferedReader(new FileReader(Paths.get(PERCORSO_TRADUZIONI).toFile())))
		{
			while (br.ready())
			{
				String linea = br.readLine();
				String[] dict = linea.split(" ");
				mappaTraduzioni.put(dict[1], dict[0]); //imposta la parola in inglese come chiave e la parola in italiano come traduzione
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter della mappa
	 * @return la mappa che contiene le traduzioni
	 */
	public Map<String,String> getTranslations()
	{
		return mappaTraduzioni;
	}

}
