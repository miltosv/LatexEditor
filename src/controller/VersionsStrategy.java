package controller;
import model.Document;
import java.util.ArrayList;
public interface VersionsStrategy {
	
	public void putVersion(Document doc);
	public void removeVersion();
	public void setEntireHistory(ArrayList <Document> doc);
	public ArrayList<Document> getEntireHistory();

}
