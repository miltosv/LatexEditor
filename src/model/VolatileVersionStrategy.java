package model;

import java.util.ArrayList;

public class VolatileVersionStrategy implements VersionsStrategy {
	private ArrayList<Document> Documents;
	
	public VolatileVersionStrategy() {
		Documents=new ArrayList<Document>();
	}
	
	@Override
	public void putVersion(Document doc) {
		//System.err.println(doc.getContents());
		Document docToAdd=doc.cloneDeep();
		docToAdd.setVersionID(docToAdd.getVersionID()+1);
		Documents.add(docToAdd);
		System.out.print(docToAdd.getContents()+" " +"put version\n");
		
		
		//System.out.println("ADDED");

	}

	
	@Override
	public void removeVersion() {
		if (!(Documents.isEmpty())){
			Documents.remove(Documents.size()-1);
		}

	}

	public Document getVersion() {
		
		Document doc;
		if (!(Documents.isEmpty()))
		{
			doc = Documents.get(Documents.size()-1);
			System.out.println(doc.getContents() +" "+ "getversion");
			this.removeVersion();
			return doc;
			 
		}
		return new Document(" ","Empty");
		
	}
	
	@Override
	public void setEntireHistory(ArrayList<Document> doc) {
		for (Document dc : doc) {
			//Documents.add(dc.cloneDeep());		//DeepClone Might not be needed here
			this.putVersion(dc);
		}

	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		
		return Documents;
	}



}
