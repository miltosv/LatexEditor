package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
		Documents.add(doc.cloneDeep());
		
		try
        {    
			int ID = doc.getVersionID();
			doc.setVersionID(ID+1);
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(stableLocations+doc.getVersionID()+".ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(doc); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
        	 ex.printStackTrace(); 
        } 
		/*
		try {
			FileOutputStream file = new FileOutputStream(stableLocations+java.time.LocalDateTime.now()+".ser"); 
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
		

	}

	@Override
	public void removeVersion() {
		Documents.remove(Documents.size()-1);
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
