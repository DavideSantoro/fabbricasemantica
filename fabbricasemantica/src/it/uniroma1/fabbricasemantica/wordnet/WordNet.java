package it.uniroma1.fabbricasemantica.wordnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe che rappresenta una specifica versione di WordNet (dizionario evoluto della lingua inglese),
 * implementa l'interfaccia Iterable per far sì che possa essere iterabile sui Synset
 *
 */
public class WordNet implements Iterable<Synset>
{
	/**
	 * TreeSet che rappresenta l'insieme dei Synset di una versione di WordNet
	 */
	protected TreeSet<Synset> raccoltaSynset = new TreeSet<Synset>(); 
	
	/**
	 * Percorso degli aggettivi
	 */
	public static String percorsoAggettivi;
	
	/**
	 * Percorso degli avverbi
	 */
	public static String percorsoAvverbi;
	
	/**
	 * Percorso dei nomi
	 */
	public static String percorsoNomi; 
	
	/**
	 * Percorso dei verbi
	 */
	public static String percorsoVerbi;
	
	/**
	 * Stringa che rappresenta la versione di WordNet
	 */
	private String versione;
	
	/**
	 * Lista che contiene i riferimenti alle istanze WordNet
	 */
	private static List<WordNet> listaIstanzeWordNet = new ArrayList<>();
	
	/**
	 * Lista dei Synset
	 */
	private List<Synset> listaSynset = raccoltaSynset.stream().collect(Collectors.toList());
		
	/**
	 * Metodo che prende in input un oggetto Path ed analizza ciascuna riga del file di testo
	 * estrapolando le informazioni utili per costruire ciascun Synset
	 * @param p il percorso corrispondente al file che si vuole analizzare
	 */
	public void costruisciSynset(Path p)
	{
		//Inizializzazione del simbolo del discorso a null
		String simboloDiscorso = null;
		//Stringa dell'istanza Path
		String stringaPercorso = p.toString();
		
		//A seconda dell'ultimo carattere della stringa del path si compie l'assegnazione al simbolo del discorso
		switch(stringaPercorso.charAt(stringaPercorso.length()-1))
		{
			case 'n' : simboloDiscorso = "n"; break;
			case 'b' : simboloDiscorso = "v"; break;
			case 'j' : simboloDiscorso = "a"; break;
			case 'v' : simboloDiscorso = "r"; break;
			default : simboloDiscorso = null; break;
		}
			//Costrutto try-catch che permette di non gestire l'eccezione che potrebbe essere sollevata dalla chiusura di un file 
			try(BufferedReader br = new BufferedReader(new FileReader(p.toFile())))
			{
				//Ciclo eseguito finché sono presenti linee di testo all'interno del file
				while (br.ready())
				{
					//Stringa di una linea che contiene le informazioni sul synset
					String linea = br.readLine();
					//Permette di saltare la parte introduttiva del file e di posizionarsi sulla linea relativa al synset
					while(linea.startsWith(" ")) linea = br.readLine();
					//Splitta la linea in maniera tale da avere le informazioni del synset organizzate in un array
					String[] arraySynset = linea.split(" ");
					//Set che ospiterà i sinonimi del synset che saranno passati in input durante la costruzione dell'oggetto
					Set<String> sinonimi = new HashSet<>();
					//Set che conterrà gli esempi d'uso dei sinonimi
					Set<String> setEsempi = new HashSet<>();
					//Indice corrispondente alla posizione del primo sinonimo all'interno della linea splittata
					int i = 4;
					//Ciclo che permette di prelevare dall'array i sinonimi. Per farlo, controlla che la stringa successiva non sia un carattere speciale
					while (Character.isDigit(arraySynset[i+1].charAt(0)) || Character.isLetter(arraySynset[i+1].charAt(0)))
					{
						sinonimi.add(arraySynset[i]); //Aggiunge il sinonimi al Set di appoggio
						i += 2; //L'indice è aumentato di 2 in maniera tale da saltare l'intero e passare al sinonimo successivo (se presente)
					}
					//Mappa di appoggio utile per inserire le relazioni
					Map<String,List<String>> mappaRelazioni = new HashMap<>();
					//Salvataggio in una variabile r della posizione successiva alla i-esima, alla quale corrisponderà un carattere speciale
					int r = i + 1;
					//Ciclo eseguito finché alla posizione r corrisponde un carattere che indica una relazione
					while(!(arraySynset[r].equals("|")) && !(Character.isDigit(arraySynset[r].charAt(0))) && !(Character.isLetter(arraySynset[r].charAt(0))))
					{
						//Crea una lista con il valore nel caso in cui la chiave non ne contenga già uno; in caso contrario il valore viene aggiunto alla lista
						mappaRelazioni.merge(arraySynset[r], new ArrayList<>(Arrays.asList(arraySynset[r+1] + simboloDiscorso)), (lista1,lista2) ->
						{
							lista1.add(lista2.get(0));
							return lista1;
						});
						r += 4; //Si aumenta l'indice di 4 per vedere se è presente un altro carattere speciale		
					}
												
					//Si aumenta l'indice finché non si ottiene la posizione del carattere '|' che precede la glossa e gli esempi
					while (linea.charAt(i) != '|') i++;
					//Sottostringa della linea che comprende la definizione ed eventualmente gli esempi
					String glossa = linea.substring(i+2);
					//Indice j inizializzato a 0
					int j = 0;
					//Si aumenta l'indice j finché non si trova il carattere '"' che indica l'inizio di un esempio
					while (j < glossa.length() && glossa.charAt(j) != '\"' ) j++;
					//Se l'indice j non è pari alla lunghezza vuol dire che è stato trovato il carattere '"', e quindi che è presente almeno un esempio
					if (j != glossa.length())
						{
							String esempi = glossa.substring(j); //Sottostringa della parte relativa agli esempi
							String[] arrayEsempi = esempi.split(";"); //Array contenente gli esempi
							for(int k = 0; k < arrayEsempi.length; k++) setEsempi.add((arrayEsempi[k].replace('\"', ' ')).trim()); //Si copiano i dati nel set di appoggio
							if(j > 1) glossa = glossa.charAt(j-1) == ':' ? glossa.substring(0, j-1) : glossa.substring(0, j-2); //Se è presente una definizione viene divisa dagli esempi tenendo conto di un'eventuale errore nel posizionamento dei due punti
							else glossa = ""; //Altrimenti sono presenti solo esempi e non c'è la glossa
						}
					//Se invece l'indice j è pari alla lunghezza vuol dire che è stato eseguito uno scorrimento senza trovare il carattere '"' (non ci sono esempi), quindi il set di appoggio non sarà riempito
					else if (j == glossa.length()) glossa = glossa.trim();
					//Viene costruito un nuovo Synset sulla base delle informazioni ricavate e viene aggiunto alla raccolta
					raccoltaSynset.add(new Synset(linea.substring(0,8) + simboloDiscorso, sinonimi, glossa,setEsempi,mappaRelazioni));
					
				}			
			}	
			
			//gestisce l'eccezione di I/O
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}	
	
	/**
	 * Costruisce un'istanza WordNet
	 * @param versione stringa della versione WordNet che si vuole caricare in memoria
	 */
	public WordNet(String versione) 
	{	 
		listaIstanzeWordNet.add(this); //Viene aggiunta alla lista l'istanza corrente
		
		this.versione = versione; //Assegnazione valore della versione
		
		//Costruzione dei percorsi
		
		percorsoAggettivi = System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "fabbricasemantica" + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "wordnet-releases" + File.separator + "releases" + File.separator + "WordNet-" + versione + File.separator + "dict" + File.separator + "data.adj";
		percorsoAvverbi = System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "fabbricasemantica" + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "wordnet-releases" + File.separator + "releases" + File.separator + "WordNet-" + versione + File.separator + "dict" + File.separator + "data.adv";
		percorsoNomi = System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "fabbricasemantica" + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "wordnet-releases" + File.separator + "releases" + File.separator + "WordNet-" + versione + File.separator + "dict" + File.separator + "data.noun";
		percorsoVerbi = System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "fabbricasemantica" + File.separator + "WEB-INF" + File.separator + "resources" + File.separator + "wordnet-releases" + File.separator + "releases" + File.separator + "WordNet-" + versione + File.separator + "dict" + File.separator + "data.verb";
		
		costruisciSynset(Paths.get(percorsoNomi)); //Caricamento in memoria dei nomi
		
		costruisciSynset(Paths.get(percorsoVerbi)); //Caricamento in memoria dei verbi
		
		costruisciSynset(Paths.get(percorsoAvverbi)); //Caricamento in memoria degli avverbi
				
		costruisciSynset(Paths.get(percorsoAggettivi)); //Caricamento in memoria degli aggettivi
				
	}

	
	/**
	 * Classe interna che rappresenta i segnalini che servono per far scorrere l'iteratore, 
	 * ovvero iterare su un oggetto Synset
	 * @author Davide Santoro
	 *
	 */
	private class SynsetIterator implements Iterator<Synset>
	{
		private int k = 0; //Indice che rappresenta la posizione del Synset all'interno della lista
		@Override
		public Synset next() { return hasNext() ? listaSynset.get(k++) : null; } //Ritorna (se presente) il Synset associato alla posizione successiva all'interno della lista
		@Override
		public boolean hasNext() { return k < listaSynset.size(); } //Restituisce un booleano che indica se il Synset successivo è presente o meno nella lista
	}
	
	/**
	 * Metodo che permette di creare un iteratore
	 * @return un oggetto iteratore
	 */
	public Iterator<Synset> iterator()
	{
		return new SynsetIterator();
	}
	
	/**
	 * Metodo che restituisce un oggetto WordNet contenente il dizionario della versione passata in input
	 * @param versione stringa che rappresenta la versione associata alla WordNet che si vuole ottenere
	 * @return l'istanza WordNet associata alla versione
	 */
	public static WordNet getInstance(String versione)
	{	
		return new WordNet(versione);
	}
	
	/**
	 * Metodo che restituisce la lista dei Synset che contengono il lemma passato in input
	 * @param lemma stringa associata alla parola di cui si vuole verificare la presenza nei vari Synset
	 * @return una lista di Synset contenente tutti i Synset che, tra i sinonimi, hanno il lemma
	 */
	public List<Synset> getSynsets(String lemma)
	{
		List<Synset> listaSynset = new ArrayList<>(); //Lista che verrà eventualmente riempita i synset contenenti il lemma passato in input
		for (Synset s : raccoltaSynset) //Iterazione su ogni elemento della raccolta
			if (s.contains(lemma)) listaSynset.add(s); //Si controlla se il lemma è contenuto o meno nella lista dei sinonimi del synset
		return listaSynset;
	}
	
	
	/**
	 * Overload del metodo getSynsets
	 * @param lemma stringa associata alla parola che sarà contenuta o meno nei vari sinonimi dei Synset
	 * @param p istanza POS che stabilisce su quali Synset effettuare il controllo
	 * @return una lista di Synset che tra i sinonimi contengono il lemma
	 */
	public List<Synset> getSynsets(String lemma, POS p)
	{
		return stream().filter(s -> s.getPOS() == p) //Filtra tutti i synset che hanno il POS passato in input
				.filter(s -> s.contains(lemma)) //Filtra tutti i synset che contengono, tra i sinonimi, il lemma passato in input
				.collect(Collectors.toList()); //Raccoglie in una lista gli elementi filtrati
	}
	
	/**
	 * Metodo che restituisce una lista di stringhe che corrispondono agli esempi che contengono 
	 * la parola passata in input
	 * @param parola stringa di cui si vuole verificare la presenza all'interno dell'esempio
	 * @return una lista di stringhe contenente tutti gli esempi che rispettano le condizioni
	 */
	public List<String> getExamples(String parola)
	{
		List<String> listaEsempi = new ArrayList<>();
		for (Synset s : getSynsets(parola))
			for (String esempio : s.getExamples())
				if (esempio.contains(parola))
					listaEsempi.add(esempio);
		return listaEsempi;
		
	}
	
	/**
	 * Restituisce (se esiste) il synset corrispondente all'identificativo in input
	 * @param identificativo campo ID di ciascun Synset
	 * @return istanza Synset che ha come identificativo quello passato in input
	 */
	public Synset getSynsetFromID(String identificativo)
	{
		//Per ciascun Synset all'interno della raccolta si confronta l'identificativo con la stringa passata in input
		for(Synset s : raccoltaSynset)
			if(s.getID().equals(identificativo)) return s;
		return null;
	}
	
	
	/**
	 * Metodo di accesso alla versione
	 * @return la versione della WordNet
	 */
	public String getVersion()
	{
		return versione;
	}
	
	
	/**
	 * Restituisce uno stream di Synset
	 * @return uno stream della raccolta di tutti i Synset
	 */
	public Stream<Synset> stream()
	{
		return raccoltaSynset.stream();
	}
	
	/**
	 * Metodo che restituisce una lista di Synset correlati
	 * @param s Synset su cui effettuare il controllo della presenza della relazione passata in input
	 * @param relazione stringa che indica il tipo di relazione
	 * @return la lista dei Synset che rispettano i requisiti
	 */
	public List<Synset> getRelatedSynsets(Synset s, String relazione)
	{
		//Lista che conterrà i Synset che hanno, con il synset passato in input, la relazione passata in input (se esistente)
		List<Synset> synsetCorrelati = new ArrayList<>();
		//Controllo per verificare se il synset ha come chiave la relazione
		if(s.relazioni.containsKey(relazione))
		{
			List<String> listaOffset = s.relazioni.get(relazione); //Lista degli offset con cui è presente una relazione
			for(String stringa : listaOffset) synsetCorrelati.add(getSynsetFromID(stringa)); //Aggiunta di elementi a synsetCorrelati
		}
		return synsetCorrelati;
	}
	
	/**
	 * Overload del metodo getRelatedSynsets 
	 * @param s il Synset su cui effettuare il controllo
	 * @param w la relazione (sotto forma di WordNetRelation e non più di stringa)
	 * @return la lista dei Synset che rispettano i requisiti
	 */
	public List<Synset> getRelatedSynsets(Synset s, WordNetRelation w)
	{
		return getRelatedSynsets(s, w.getRelazione()); //Chiama il metodo getSynset passando il Synset e la stringa corrispondente alla relazione
	}
	
}