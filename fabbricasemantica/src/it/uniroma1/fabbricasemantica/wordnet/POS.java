package it.uniroma1.fabbricasemantica.wordnet;

/**
 * Enum che rappresenta le quattro parti del discorso
 *
 */
public enum POS
{
	ADJECTIVE('a'), ADVERB('r'), NOUN('n'), VERB('v');
	
	/**
	 * Carattere che indica la parte del discorso di un Synset
	 */
	private final char parteDelDiscorso;
	
	/**
	 * Costruttore con visibilità di default
	 * @param parteDelDiscorso il carattere associato al POS
	 */
	POS(char parteDelDiscorso)
	{
		this.parteDelDiscorso = parteDelDiscorso;
	}
	
	/**
	 * Metodo di accesso al carattere
	 * @return il carattere associato alla parte del discorso
	 */
	public char getParte() { return parteDelDiscorso; }
}
