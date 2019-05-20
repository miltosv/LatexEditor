package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StableVersionStrategy implements VersionsStrategy {
	private String stableLocations="\\src\\stables\\"; //the user doesn't need to determine where the stables are being stored, just needs to pick them
	private ArrayList<Document> Documents;
	@Override
	public void putVersion(Document doc) {
		Documents.add(doc.cloneDeep());
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(stableLocations+doc.getVersionID()); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(doc); 
              
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
	public void removeVersion() {
		Documents.remove(Documents.size()-1);

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
		
		return null;
	}

}
