package it.uniroma1.fabbricasemantica.wordnet;

/**
 * Enum che rappresenta le relazioni che possono intercorrere tra Synset
 *
 */
public enum Relazioni implements WordNetRelation
{
	ANTONYM("!"), HYPERNYM("@"), INSTANCE_HYPERNIM("@i"), HYPONYM("~"), INSTANCE_HYPONYM("~i"), 
	MEMBER_HOLONYM("#m"), SUBSTANCE_HOLONYM("#s"), PART_HOLONYM("#p"), MEMBER_MERONYM("%m"),
	SUBSTANCE_MERONYM("%s"), PART_MERONYM("%p"), ATTRIBUTE("="), ENTAILMENT("*"), CAUSE(">"),
	ALSO_SEE("^"), VERB_GROUP("$"), SIMILAR_TO("&"), PARTICIPLE_OF_VERB("<"), PERTAINYM("\\"),
	DOMAIN_OF_SYNSET_TOPIC(";c"), MEMBER_OF_THIS_DOMAIN_TOPIC("-c"), DOMAIN_OF_SYNSET_REGION(";r"),
	MEMBER_OF_THIS_DOMAIN_REGION("-r"), DOMAIN_OF_SYNSET_USAGE(";u"), MEMBER_OF_THIS_DOMAIN_USAGE("-u");
	
	
	/**
	 * Stringa del simbolo che identifica la relazione
	 */
	private final String simboloRelazione;
	
	/**
	 * Costruttore di default
	 * @param simboloRelazione la stringa del simbolo associata alla relazione
	 */
	Relazioni(String simboloRelazione)
	{
		this.simboloRelazione = simboloRelazione;
	}
	
	/**
	 * Implementazione del metodo astratto getRelazione() dell'interfaccia WordNetRelation
	 * @return la stringa che identifica la relazione
	 */
	@Override
	public String getRelazione()
	{
		return simboloRelazione;
	}
}
