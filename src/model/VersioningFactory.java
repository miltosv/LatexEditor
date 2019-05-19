package model;

public class VersioningFactory {

	public VersioningFactory() {

	}
	
	public VersionsStrategy createStrategy(String strategy) {
		
		switch(strategy) {
			case "Stable":
				return new StableVersionStrategy();
			case "Volatile":
				return new VolatileVersionStrategy();
			default:
				return null;
		}
		
		
	}
}
