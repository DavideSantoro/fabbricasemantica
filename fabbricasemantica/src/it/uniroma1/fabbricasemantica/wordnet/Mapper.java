package it.uniroma1.fabbricasemantica.wordnet;

/**
 * Classe che fornisce una mappatura tra versioni diverse di WordNet
 *
 */
public class Mapper 
{
	/**
	 * Metodo che restituisce un oggetto WordNetMapping, il quale fornisce 
	 * le mappature dalla WordNet di partenza a quella di destinazione
	 * @param ws la versione sorgente della WordNet
	 * @param wd la versione destinazione della WordNet
	 * @return un oggetto di tipo WordNetMapping
	 */
	public static WordNetMapping map(WordNet ws, WordNet wd)
	{
		return new WordNetMapping(ws,wd);
	}

	
}
