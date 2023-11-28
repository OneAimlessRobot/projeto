/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



package artAuctions.specificADTs;

import dataStructures.Entry;
import dataStructures.Iterator;

/**
* Generic Artist. Has the 'getters'.
*/
public interface ArtistReadonly extends UserReadonly {

	
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
	
	/**
	 * Lists the works of this artist
	 * @return
	 */
	Iterator<Entry<WorkReadonly,WorkReadonly>> works();
	
}
