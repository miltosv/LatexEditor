package model;

public class VersionsManager {
	private VersionsStrategy currentStrategy;
	private VersioningFactory factory = new VersioningFactory();
	private String strategyType;
	private Document CurrentDocument;
	
	public VersionsManager() {
		currentStrategy=factory.createStrategy("Volatile"); // Manually setting it because it is DEFAULT
		strategyType="Volatile";
		DocumentManager dcm= new DocumentManager();
		CurrentDocument=dcm.createDocument("Empty");
	}
	
	public void changeStrategy(String strategy) {
		if (strategyType.equals(strategy)) {
			return;
		}else {
			
			VersionsStrategy newStrategy = factory.createStrategy(strategy);
			newStrategy.setEntireHistory(currentStrategy.getEntireHistory());
			currentStrategy = newStrategy;
			
		}
			
	}
	public void setCurrentVersion(Document doc) {
		currentStrategy.putVersion(CurrentDocument);
		CurrentDocument = doc;
		
	}
	
	
	

}
