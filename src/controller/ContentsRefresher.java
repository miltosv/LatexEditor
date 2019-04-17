package controller;

import model.Document;

public class ContentsRefresher implements Refresh {

	//private LatexEditorController controller;
	//public Updater(LatexEditorController control) {
	//	controller=control;
	//}
	
	
	@Override
	public String refresh(Document doc) {
		return doc.getContents();

	}

	

}
