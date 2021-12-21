package it.uniroma1.fabbricasemantica.data;

import java.util.stream.Collectors;


import it.uniroma1.fabbricasemantica.wordnet.Relazioni;
import it.uniroma1.fabbricasemantica.wordnet.Synset;
import it.uniroma1.fabbricasemantica.wordnet.WordNet;
import it.uniroma1.fabbricasemantica.wordnet.WordNetTranslation;


/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * */
public class StandardDataProvider implements DataProvider<String> {
	/**
	 * Istanza della versione 3.1 di WordNet
	 */
	WordNet wn = WordNet.getInstance("3.1");
	
	/**
	 * Istanza che serve per ottenere le traduzioni
	 */
	WordNetTranslation wnt = new WordNetTranslation();
	
	/**
	 * Lista dei synset della versione 3.1 di WordNet
	 */
	java.util.List<Synset> listSynset = wn.stream().collect(Collectors.toList());
	
	/**
	 * Lista delle chiavi presenti nella mappa dell'istanza di WordNetTranslation
	 */
	java.util.List<String> listKeys = wnt.getTranslations().keySet().stream().collect(Collectors.toList());

	/**
	 * Metodo che, a seconda del task, fornisce delle informazioni specifiche prelevate da WordNet
	 */
	@Override 
	public String getData(Task task) {
		Synset synsetTA = listSynset.get((int) (Math.random() * 117790));
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			return "{" +
					"\"word\": \"" + synsetTA.getSynonyms().stream().findFirst().get() + "\"," +
					"\"description\": \"" + synsetTA.getGloss() + "\"" +
					"}";
		}else if (task == StandardTask.WORD_ANNOTATION) {
			return "{\"description\": \"" + listSynset.get((int) (Math.random() * 117790)).getGloss() + "\"}";
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			Synset synsetDA = listSynset.get((int) (Math.random() * 117790));
			//ciclo eseguito finché non viene trovato un synset che abbia almeno un iperonimo
			while (!wn.getRelatedSynsets(synsetDA, Relazioni.HYPERNYM).stream().findFirst().isPresent()) synsetDA = listSynset.get((int) (Math.random() * 117790));
			Synset hypernym = wn.getRelatedSynsets(synsetDA, Relazioni.HYPERNYM).stream().findFirst().get();
			return "{" + 	
					"\"word\": \"" + synsetDA.getSynonyms().stream().findFirst().get() + "\"," +
					"\"hypernym\": \"" + hypernym.getSynonyms().stream().findFirst().get() + "\"" +
					"}";
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			Synset synsetSA = listSynset.get((int) (Math.random() * 117790));
			String word = synsetSA.getSynonyms().stream().findFirst().get();
			//ciclo eseguito finché non si trova un synset che abbia almeno un esempio
			//contenente la parola e almeno 4 sinonimi
			while (wn.getExamples(word).isEmpty() || wn.getSynsets(word).size() <= 3 || synsetSA.getExamples().isEmpty())
			{
				synsetSA = listSynset.get((int) (Math.random() * 117790));
				word = synsetSA.getSynonyms().stream().findFirst().get();
			}
			java.util.List<Synset> synsetSenses = wn.getSynsets(word);
			return "{" + 
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + synsetSA.getExamples().stream().findFirst().get() + "\"," +
					"\"firstSense\": \"" + synsetSenses.get(0).getGloss() + "\"," +
					"\"secondSense\": \"" + synsetSenses.get(1).getGloss() + "\"," +
					"\"thirdSense\": \"" + synsetSenses.get(2).getGloss() + "\"," +
					"\"fourthSense\": \"" + synsetSenses.get(3).getGloss() + "\"" +
					"}";
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			String word = listKeys.get((int) (Math.random() * 4120));
			//ciclo eseguito finché non si trova un synset che abbia almeno due esempi
			while (wn.getSynsets(word).size() < 2) word = listKeys.get((int) (Math.random() * 4120));
			java.util.List<Synset> listSynset = wn.getSynsets(word);
			//ritorna parola, descrizione e traduzione della parola
			//per le ultime due traduzioni ritorna la traduzione della parola se quest'ultima è presente
			//nel dizionario, altrimenti una traduzione casuale
			return "{" +
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + listSynset.stream().findAny().get().getGloss() + "\"," +
					"\"firstTranslation\": \"" + wnt.getTranslations().get(word) + "\"," +
					"\"secondTranslation\": \"" + wnt.getTranslations().getOrDefault(listSynset.get(0), wnt.getTranslations().get(listKeys.get((int) (Math.random() * 4120)))) + "\"," +
					"\"thirdTranslation\": \"" + wnt.getTranslations().getOrDefault(listSynset.get(1), wnt.getTranslations().get(listKeys.get((int) (Math.random() * 4120)))) + "\"" +
					"}";
		}else if (task == StandardTask.SENSE_VALIDATION) {
			Synset synsetWordSV = listSynset.get((int) (Math.random() * 117790));
			//ciclo eseguito finché non c'è almeno un esempio nel synset
			while (!synsetWordSV.getExamples().stream().findFirst().isPresent()) synsetWordSV = listSynset.get((int) (Math.random() * 117790));
			String word = synsetWordSV.getSynonyms().stream().findFirst().get();
			Synset synsetSenseSV = wn.getSynsets(word).stream().findAny().get();
			return "{" + 
					"\"word\": \"" + word + "\"," +
					"\"example\": \"" + synsetWordSV.getExamples().stream().findFirst().get() + "\"," +
					"\"sense\": \"" + synsetSenseSV.getGloss() + "\"" +
					"}";
		}else if (task == StandardTask.MY_ANNOTATION) {
			Synset mySynset = listSynset.get((int) (Math.random() * 117790));
			//ciclo eseguito finché non si trova un sinonimo la cui lunghezza sia esattamente di 5 caratteri
			while (mySynset.getSynonyms().stream().findFirst().get().length() != 5) mySynset = listSynset.get((int) (Math.random() * 117790));
			return "{" +
					"\"word\": \"" + mySynset.getSynonyms().stream().findFirst().get().toLowerCase() + "\"," +
					"\"description\": \"" + mySynset.getGloss() + "\"" +
					"}";
		}
		return null; 
	}
	

}
