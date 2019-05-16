package controller;

import java.util.ArrayList;

import model.Document;

public class VolatileVersionStrategy implements VersionsStrategy {
	private ArrayList<Document> Documents;
	
	public VolatileVersionStrategy() {
		Documents=new ArrayList<Document>();
	}
	
	@Override
	public void putVersion(Document doc) {
		Documents.add(doc);

	}

	@Override
	public void removeVersion() {
		if (!(Documents.isEmpty())){
			Documents.remove(Documents.size()-1);
		}

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
