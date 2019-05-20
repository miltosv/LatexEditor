package model;
import java.util.ArrayList;
public interface VersionsStrategy {
	
	public void putVersion(Document doc);
	public Document getVersion();
	public void removeVersion();
	public void setEntireHistory(ArrayList <Document> doc);
	public ArrayList<Document> getEntireHistory();

}
