package model;

public class VersionsManager {
	private VersionsStrategy currentStrategy;
	private VersioningFactory factory = new VersioningFactory();
	private String strategyType;
	//private Document CurrentDocument;
	private boolean status;
	
	public VersionsManager() {
		currentStrategy=factory.createStrategy("Volatile",""); // Manually setting it because it is DEFAULT
		strategyType="Volatile";
		//CurrentDocument = new Document("\n ","empty");
		status=true;
	}
	
	public void changeStrategy(String strategy,String info) {
		if (!status) {
			return;
		}
		if (strategyType.equals(strategy)) {
			return;
		}else {
			
			VersionsStrategy newStrategy = factory.createStrategy(strategy, info);
			newStrategy.setEntireHistory(currentStrategy.getEntireHistory());
			currentStrategy = newStrategy;
			strategyType = strategy;
			
		}
			
	}
	public void setCurrentVersion(Document doc) {
		if (!status) {
			
			return;
		}
		currentStrategy.putVersion(doc);
		//CurrentDocument = doc.cloneDeep();
		System.err.println("VersionAdded");
		
	}
	public Document getPreviousVersion() {
		if (!status) {
			return null;
		}
		System.out.println(currentStrategy.getVersion().getContents()+ " "+"previous");
		return currentStrategy.getVersion();
		
	}
	public void Enable() {
		status=true;
	}
	public void Disable() {
		status= false;
	}
	

}
