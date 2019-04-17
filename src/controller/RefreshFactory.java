package controller;

public class RefreshFactory {

	
	public RefreshFactory() {
		
	}
	
	public Refresh Create(String str) {
		switch(str) {
			case "Contents":
				
			return new ContentsRefresher();
		
		default: return null;
		}
	}
}
