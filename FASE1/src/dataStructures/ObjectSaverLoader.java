package dataStructures;
import java.io.*;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/

public class ObjectSaverLoader<E> {

	
	private String filepath;
	public ObjectSaverLoader(String filepath) {
		
		this.filepath=filepath;
		
	}
	
	public E load() {
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(filepath));
			
			E e= (E) ois.readObject();
			ois.close();
			return e;
			
			
			
		}
		catch (IOException e) {
			
			
			return null;
		}
		catch (ClassNotFoundException e) {
			
			return null;
		}
		
	}
	
	public void save(E intQueue) {
		try {
			ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(filepath));
			oos.writeObject(intQueue);
			oos.close();
			
			
		}
		catch(IOException ioe) {
		
			
			System.out.println("Issue in writing...");
			
		}
		
		
		
	}
}
