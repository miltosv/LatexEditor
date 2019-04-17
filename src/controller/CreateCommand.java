package controller;

import model.*;

public class CreateCommand implements Command {
	private DocumentManager manager; 
	private LatexEditorController controller;
	CreateCommand(LatexEditorController control){
		controller=control;
		manager=new DocumentManager();
	}
	@Override
	public void execute(Document doc, String info) {
		
		//Document newdocument;
		doc=manager.createDocument(info);
		controller.setDocument(doc);
		//doc=newdocument;
		//System.out.println(doc.getType());

	}

}
