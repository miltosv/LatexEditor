package model;

import java.util.ArrayList;

public class VolatileVersionStrategy implements VersionsStrategy {
	private ArrayList<Document> Documents;
	
	public VolatileVersionStrategy() {
		Documents=new ArrayList<Document>();
	}
	
	@Override
	public void putVersion(Document doc) {
		Documents.add(doc.cloneDeep());

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
			this.removeVersion();
			return doc;
			 
		}
		return null;
		
	}
	
	@Override
	public void setEntireHistory(ArrayList<Document> doc) {
		for (Document dc : doc) {
			Documents.add(dc.cloneDeep());		//DeepClone Might not be needed here
		}

	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		
		return Documents;
	}



}
