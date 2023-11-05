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
		Integer[] nums= CollectionAlgorithms.randIntArrAux(0, 100, 10);
		List<Integer> list= new Vector<>();
		List<Integer> list2;
		for(int i=0;i<nums.length;i++) {
			
			list.addFirst(nums[i]);
		}
		ObjectSaverLoader<List<Integer>> loader1=new ObjectSaverLoader<>(TestFilePath.VECTORFILE.getValue());
	    loader1.save(list);
	    list2=loader1.load();
		System.out.println(list);
		System.out.println(list2);
	
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
