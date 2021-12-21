package it.uniroma1.fabbricasemantica.data;

/**
 * Interfaccia con un metodo di default
 */
public interface Task {
	/**
	 * Metodo che consente di ottenere la rappresentazione degli enum sotto forma di stringa 
	 * @return la stringa che rappresenta uno degli enum
	 */
	default String getTaskID() {
		return toString();
	}
	
}
