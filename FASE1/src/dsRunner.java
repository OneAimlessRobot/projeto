import dataStructures.*;
import artAuctions.*;
import artAuctions.auxiliar.*;
import artAuctions.enums.*;
import java.io.*;

public class dsRunner {
	
	public static void main(String[] args) throws IOException, EmptyQueueException {

		Integer[] nums= CollectionAlgorithms.randIntArrAux(0, 100, 10);

		InvertibleQueue<Integer> queueTwo,queueThree;
		queueTwo=new InvertibleQueueInList<>();
		queueThree=new InvertibleQueueInList<>();

		for(int i=0;i<nums.length;i++) {
			
			queueTwo.enqueue(nums[i]);
		}

		for(int i=0;i<nums.length;i++) {
			
			queueThree.enqueue(nums[i]);
		}

		
		
		System.out.println(queueTwo);
		queueThree.invert();
		System.out.println("Invertida!:\n"+queueThree);
	}
	
	private static void initFiles() {
		
		for(FilePath filepath: FilePath.values()) {
			
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
		
		for(FilePath filepath: FilePath.values()) {
			
			File file= new File(filepath.getValue());

	        if (!file.delete()) {
	            System.out.println("Problemas ao apagar este ficheiro (talvez já não exista?):\n"+filepath.getValue()+"\n");
		        
	        }
		}
		
		
		
	}
}
