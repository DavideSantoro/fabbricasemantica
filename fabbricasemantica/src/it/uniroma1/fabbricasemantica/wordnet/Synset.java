package it.uniroma1.fabbricasemantica.wordnet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe che rappresenta l'insieme dei sinonimi che sono utilizzati per esprimere il concetto
 * e ulteriori informazioni riguardanti ognuno di essi
 * 
 */
public class Synset implements Comparable<Synset>
{
	/**
	 * Stringa che rappresenta l'identificativo del sysnset
	 */
	private String ID;
	
	/**
	 * Una definizione testuale della parte del discorso
	 */
	private String gloss;
	
	/**
	 * I vari sinonimi che sono utilizzati per esprimere il concetto della parte del discorso in questione
	 */
	private Set<String> sinonimi;
	
	/**
	 * Mappa utile a rappresentare le relazioni che intercorrono tra il synset in questione ed altri synset
	 */
	protected Map<String,List<String>> relazioni;
	
	/**
	 * Esempi di uso dei sinonimi del Synset
	 */
	private Set<String> esempi;
	
	/**
	 * Costruisce il Synset
	 * @param ID l'identificativo del Synset
	 * @param sinonimi i sinonimi che ne fanno parte
	 * @param gloss la definizione che esprime il concetto
	 * @param esempi gli esempi utili alla comprensione del concetto
	 * @param relazioni le relazioni che intercorrono con altri Synset
	 */
	public Synset(String ID, Set<String> sinonimi, String gloss, Set<String> esempi, Map<String,List<String>> relazioni)
	{
		this.ID = ID;
		this.sinonimi = sinonimi;
		this.gloss = gloss;
		this.esempi = esempi;
		this.relazioni = relazioni;
	}
		
	/**
	 * Rappresentazione sotto forma di stringa del Synset
	 * @return una stringa che rende visibile i vari campi del Synset
	 */
	public String toString()
	{
		return ID + " - " + sinonimi + " - " + gloss + " - " + esempi + " - " + relazioni;
	}
	
	/**
	 * Override del metodo compareTo dell'interfaccia Comparable, definisce la relazione d'ordine tra istanze Synset 
	 * e permette che nel TreeSet possano essere aggiunti elementi
	 * @param s Synset con cui si effettua il confronto
	 * @return un intero (0, 1, oppure -1) che indica il risultato della comparazione
	 */
	@Override
	public int compareTo(Synset s)
	{
		return ID.compareTo(s.ID);
	}
	
	/**
	 * Restituisce l'offset del synset
	 * @return una stringa di 8 cifre
	 */
	public String getOffset()
	{
		return ID.substring(0,8); //viene esclusa la parte del discorso
	}
	
	/**
	 * Restituisce l'identificativo del Synset (offset + parte del discorso)
	 * @return una stringa di 9 caratteri in cui i primi 8 sono delle cifre è l'ultimo è una lettera(a,v,r,n)
	 */
	public String getID()
	{
		return ID;
	}

	/**
	 * Restituisce l'insieme dei sinonimi del Synset
	 * @return un Set contenente i sinonimi del Synset
	 */
	public Set<String> getSynonyms()
	{
		return sinonimi;
	}
	
	/**
	 * Restituise l'insieme degli esempi del Synset
	 * @return un Set in cui possono essere contenuti gli esempi presenti nel Synset
	 */
	public Set<String> getExamples()
	{
		return esempi;
	}
	
	/**
	 * Restituisce la glossa del Synset
	 * @return una stringa che rappresenta la definizione del concetto
	 */
	public String getGloss()
	{
		return gloss;
	}
	
	/**
	 * Verifica se la parola passata in input è contenuta o meno nel Synset
	 * @param parola una stringa di cui si vuole verificare la presenza all'interno dei sinonimi
	 * @return un valore booleano che indica se la parola è presente o meno nei sinonimi
	 */
	public boolean contains(String parola)
	{
		return sinonimi.contains(parola);
	}
	
	/**
	 * Metodo che restituisce l'istanza enum del POS corrispondente al Synset
	 * @return il POS associato all'ultimo carattere dell'ID del Synset
	 */
	public POS getPOS()
	{
		//switch sull'ultimo carattere dell'ID che indica la parte del discorso del Synset
		switch(getID().charAt(8)) 
		{
			case 'a' : return POS.ADJECTIVE;
			case 'r' : return POS.ADVERB;
			case 'n' : return POS.NOUN;
			case 'v' : return POS.VERB;
			default : return null;
		}
	}
	
	
}
