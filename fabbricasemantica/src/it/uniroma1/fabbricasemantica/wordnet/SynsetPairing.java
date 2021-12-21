package it.uniroma1.fabbricasemantica.wordnet;

/**
 * Classe che rappresenta la coppia Synset sorgente e Synset destinazione 
 *
 */
public class SynsetPairing 
{
	/**
	 * Synset sorgente
	 */
	private Synset synsetSorgente;
	
	/**
	 * Synset destinazione
	 */
	private Synset synsetDestinazione;
	
	/**
	 * double che rappresenta lo score di confidenza della coppia
	 */
	private double score;
	
	/**
	 * Costruisce la coppia di Synset
	 * @param sorgente il Synset sorgente
	 * @param destinazione il Synset destinazione
	 */
	public SynsetPairing(Synset sorgente, Synset destinazione)
	{
		synsetSorgente = sorgente;
		synsetDestinazione = destinazione;
		/**
		 * Se i due Synset hanno la stessa glossa e gli stessi sinonimi allora
		 * il valore di confidenza sarà massimo (1.0)
		 */
		if((sorgente.getGloss()).equals(destinazione.getGloss()) 
			&& (sorgente.getSynonyms()).containsAll(destinazione.getSynonyms()) 
			&& ((sorgente.getSynonyms()).size()) == ((destinazione.getSynonyms()).size()))
			score = 1.0;	
	}
	
	/**
	 * Restituisce il Synset sorgente
	 * @return il primo Synset appartenente alla coppia
	 */
	public Synset getSource()
	{
		return synsetSorgente;
	}
	
	/**
	 * Restituisce il Synset destinazione
	 * @return il secondo Synset appartenente alla coppia
	 */
	public Synset getTarget()
	{
		return synsetDestinazione;
	}
	
	/**
	 * Restituisce lo score di confidenza della coppia
	 * @return un double compreso tra 0.0 e 1.0 che rappresenta l'interazione tra la coppia
	 */
	public double getScore()
	{
		return score;
	}
	

}
