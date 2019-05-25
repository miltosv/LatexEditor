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
			FileOutputStream fos = new FileOutputStream(stableLocations);
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
			/*
			File file = new File (stableLocations);
			if (!file.exists()) {
				stableLocations=stableLocations+".ser";
			}*/
            FileInputStream fis = new FileInputStream(stableLocations);
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
		this.readFromFile();
		return Documents;
	}



	@Override
	public Document getVersion() {
		/*
		File file = new File (stableLocations);
		if (!file.exists()){
			if (Documents.isEmpty()) {
				return new Document("","Empty");
			}
			Document doc = Documents.get(Documents.size()-1);
			this.removeVersion();
			return doc;
		}else {
			this.readFromFile();
			if (Documents.isEmpty()) {
				return new Document("","Empty");
			}
			Document doc = Documents.get(Documents.size()-1);
			this.removeVersion();
			return doc;
		}
		*/
		this.readFromFile();
		if (Documents.isEmpty()) {
			return new Document("","Empty");
		}
		Document doc = Documents.get(Documents.size()-1);
		this.removeVersion();
		return doc;
	}

}
