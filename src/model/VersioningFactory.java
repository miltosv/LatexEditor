package model;

public class VersioningFactory {

	public VersioningFactory() {

	}
	
	public VersionsStrategy createStrategy(String strategy,String info) {
		
		switch(strategy) {
			case "Stable":
				return new StableVersionStrategy(info);
			case "Volatile":
				return new VolatileVersionStrategy();
			default:
				return null;
		}
		
		
	}
}
