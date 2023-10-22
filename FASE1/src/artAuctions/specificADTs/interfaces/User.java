package artAuctions.specificADTs.interfaces;

import java.io.Serializable;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


public interface User extends Serializable {
	

	String getName();
	String getLogin();
	String getEmail();
	int getAge();
}
