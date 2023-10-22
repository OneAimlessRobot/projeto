package artAuctions.auxiliarForTesting;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


public class AuxNumeric {

	public static int boundedRandNum(int max,int min) {
		
		if(max<min) {
			
			int tmp=max;
			max=min;
			min=tmp;
			
		}
		return (int) Math.round(Math.random()*(max-min)+min);
		
	}
	public static String randString(int size) {
		
		String result="";
		for(int i=0;i<size;i++) {
			
			char c= (char) boundedRandNum(32, 127);
			result+=c;
		}
		return result;
	}
}
