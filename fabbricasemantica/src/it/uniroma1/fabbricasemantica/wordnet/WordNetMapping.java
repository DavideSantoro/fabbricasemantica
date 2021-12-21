package it.uniroma1.fabbricasemantica.wordnet;

import java.util.Optional;
import java.util.TreeSet;

/**
 * Classe che crea la mappatura tra due diverse versioni di WordNet
 *
 */
public class WordNetMapping 
{
	/**
	 * Rappresenta la versione di WordNet sorgente
	 */
	private WordNet wnSorgente;
	
	/**
	 * Rappresenta la versione di WordNet destinazione
	 */
	private WordNet wnDestinazione;
	
	/**
	 * Costruisce un'istanza WordNetMapping
	 * @param wnSorgente la WordNet sorgente
	 * @param wnDestinazione la WordNet destinazione
	 */
	public WordNetMapping(WordNet wnSorgente, WordNet wnDestinazione)
	{
		this.wnSorgente = wnSorgente;
		this.wnDestinazione = wnDestinazione;
	}
	
	/**
	 * Metodo che prende in input un Synset nella versione sorgente e restituisce un Optional contenente il SynsetPairing
	 * @param src Synset della versione sorgente
	 * @return un Optional contenente il SynsetPairing
	 */
	public Optional<SynsetPairing> getMapping(Synset src)
	{
		
		//Si verifica che la versione della WordNet sorgente sia diversa rispetto a quella della WordNet destinazione
		if(!(wnSorgente.getVersion().equals(wnDestinazione.getVersion())))
		{
			Synset destinazione = confrontaSynset(src, wnDestinazione.raccoltaSynset); //Delega la costruzione del Synset destinazione al metodo confrontaSynset
			if(destinazione != null) return Optional.of(new SynsetPairing(src,destinazione)); //Se la destinazione non è null, restituisce un Optional di SynsetPairing
			return Optional.empty(); //Altrimenti restituisce un Optional vuoto
		}

		//Se le versioni sono uguali allora il Synset viene accoppiato con sé stesso
		return Optional.of(new SynsetPairing(src,src));
	}

	/**
	 * Metodo che confronta il Synset sorgente con tutti i Synset appartenenti alla versione destinazione
	 * @param src SynsetSorgente
	 * @param raccoltaSynset TreeSet in cui sono contenuti tutti i Synset appartenenti ad una determinata versione
	 * @return il Synset destinazione, ovvero il Synset che possiede glossa e sinonimi uguali a quelli del Synset sorgente
	 */
	public Synset confrontaSynset(Synset src, TreeSet<Synset> raccoltaSynset)
	{
		//Si controlla se il Synset sorgente abbia la stessa glossa e gli stessi sinonimi di un altro Synset
		for(Synset s : raccoltaSynset)
			if((src.getGloss()).equals(s.getGloss()) 
				&& (src.getSynonyms()).containsAll(s.getSynonyms()) 
				&& ((src.getSynonyms()).size()) == ((s.getSynonyms()).size()))
				return s;
		
		return null; //Se non è stato trovato nessun Synset uguale allora ritorna null
	}
}
