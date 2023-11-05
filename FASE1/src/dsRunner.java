import dataStructures.*;
import artAuctions.auxiliarForTesting.*;
import artAuctions.enums.*;
import java.io.*;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


public class dsRunner {
	
	public static void main(String[] args) throws IOException, EmptyQueueException {

		initFiles();
		Integer[] nums= CollectionAlgorithms.randIntArrAux(0, 10, 10);
		
		List<Integer> list2;
		
		ObjectSaverLoader<List<Integer>> loader1=new ObjectSaverLoader<>(TestFilePath.VECTORFILE.getValue());
	    
		FilteredIterator<Integer> fit;
		
	    if((list2=loader1.load())==null) {
	    	
	    	list2=new DoubleList<>();
	    	
	    }
	    for(int i=0;i<nums.length;i++) {
			
			list2.addFirst(nums[i]);
		}
		System.out.println(list2);
		
		fit=list2.filteredIterator((Integer)2);

		System.out.print("[ ");
		int numOfDesired=0;
		while(fit.hasNext()) {
			Integer value=fit.next();
			if(value!=null) {
			System.out.print("NumOfDesired: "+(++numOfDesired)+" "+value+" ");
			}
			
		}

		System.out.println(" ]");
		
		
	
	}
	
	private static void initFiles() {
		
		for(TestFilePath filepath: TestFilePath.values()) {
			
			File file= new File(filepath.getValue());
			try {
				if(!file.exists()) {
				file.createNewFile();
				}
			} catch (IOException e) {
				System.out.println("Problemas em criar ficheiros novos!!!");
			}
			
		}
		
		
		
	}

	private static void deleteFiles() {
		
		for(TestFilePath filepath: TestFilePath.values()) {
			
			File file= new File(filepath.getValue());

	        if (!file.delete()) {
	            System.out.println("Problemas ao apagar este ficheiro (talvez já não exista?):\n"+filepath.getValue()+"\n");
		        
	        }
		}
		
		
		
	}
}
