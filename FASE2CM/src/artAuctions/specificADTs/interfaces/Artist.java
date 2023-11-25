/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/



package artAuctions.specificADTs.interfaces;

/**
* Specific type of User. Creates Works of art.
*/
public interface Artist extends ArtistReadonly {

	
	/**
	 * Adiciona uma Obra de Arte à Lista de Obras de Arte de um determinado Artista
	 * @param work
	 */
	void addWork(Work work);
	

	/**
	 * Atribui um Nome Artístico a um determinado Artist
	 * @param newName
	 */
	void setArtsyName(String newName);
	
	/**
	 * Remove todas as Obras de Arte da lista de Obras de Arte de um Artista
	 */
	void clearWorks();
	
	

}

