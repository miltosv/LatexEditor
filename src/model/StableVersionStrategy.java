package model;

import java.io.*;
import java.util.ArrayList;

public class StableVersionStrategy implements VersionsStrategy {
	private String stableLocations; 
	private ArrayList<Document> Documents;
	
	
	
	
	
	public StableVersionStrategy() {
		Documents=new ArrayList<Document>();
	}
	
	public StableVersionStrategy(String location)
	{
		System.err.println(location);
		Documents=new ArrayList<Document>();
		stableLocations=location;
	}
	
	
	
	@Override

	public void putVersion(Document doc) {
		Document newDoc=doc.cloneDeep();
		newDoc.setVersionID(newDoc.getVersionID()+1);
		Documents.add(newDoc);
		this.writeToFile();

	}


	private void writeToFile() {
		
		try {
			FileOutputStream fos = new FileOutputStream(stableLocations+".ser");
			 ObjectOutputStream out = new ObjectOutputStream(fos);
	         out.writeObject(Documents);
	         out.close();
	         fos.close();
		}catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
		
	}
	
	private void readFromFile() {
		try
        {
            FileInputStream fis = new FileInputStream(stableLocations+".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Documents = (ArrayList<Document>) ois.readObject();
 
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
		
		
	}
	
	
	
	@Override
	public void removeVersion() {
		Documents.remove(Documents.size()-1);
		/*
		try {
			FileOutputStream file = new FileOutputStream(stableLocations+java.time.LocalDateTime.now()); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
          
			// Method for serialization of object 
			out.writeObject(Documents); 
          
			out.close(); 
        	file.close(); 
          
        	System.out.println("Object has been serialized"); 
		}
		catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 

		*/
		this.writeToFile();

	}

	@Override
	public void setEntireHistory(ArrayList<Document> doc) {
		for(Document dc : doc) {
			this.putVersion(dc);
		}

	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		return Documents;
	}



	@Override
	public Document getVersion() {
		Document doc = Documents.get(Documents.size()-1);
		this.removeVersion();
		return doc;
	}

}
