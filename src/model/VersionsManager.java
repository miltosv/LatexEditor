package model;

public class VersionsManager {
	private VersionsStrategy currentStrategy;
	private VersioningFactory factory = new VersioningFactory();
	private String strategyType;
	private Document CurrentDocument;
	private boolean status;
	
	public VersionsManager() {
		currentStrategy=factory.createStrategy("Volatile"); // Manually setting it because it is DEFAULT
		strategyType="Volatile";
		DocumentManager dcm= new DocumentManager();
		CurrentDocument=dcm.createDocument("Empty");
		status=true;
	}
	
	public void changeStrategy(String strategy) {
		if (!status) {
			return;
		}
		if (strategyType.equals(strategy)) {
			return;
		}else {
			
			VersionsStrategy newStrategy = factory.createStrategy(strategy);
			newStrategy.setEntireHistory(currentStrategy.getEntireHistory());
			currentStrategy = newStrategy;
			strategyType = strategy;
			
		}
			
	}
	public void setCurrentVersion(Document doc) {
		if (!status) {
			return;
		}
		currentStrategy.putVersion(CurrentDocument);
		CurrentDocument = doc;
		System.out.println("VersionAdded");
		
	}
	public Document getPreviousVersion() {
		if (!status) {
			return null;
		}
		return currentStrategy.getVersion();
		
	}
	public void Enable() {
		status=true;
	}
	public void Disable() {
		status= false;
	}
	

}
