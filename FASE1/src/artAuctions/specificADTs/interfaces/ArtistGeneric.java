package artAuctions.specificADTs.interfaces;

import dataStructures.Iterator;

/**
* Generic Artist. Has the 'getters'.
*/
public interface ArtistGeneric extends UserGeneric {

	
	/**
	 * Devolve o nome Artístico de um Artista
	 * @return
	 */
	String getArtsyName();
	
	/**
	 * Imprime no ecrã o Login, o Nome, o Nome Artístico, a Idade e o email de um Artista
	 * @return
	 */
	String printArtist();
	
	/**
	 * Retorna o número de Obras de Arte autoradas por um determinado Artista. 
	 * Usa o size da lista de Works do Artista.
	 * @return
	 */
	int getNumOfWorks();
	
	Iterator<WorkGeneric> works();
	
}
