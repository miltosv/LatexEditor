package controller;

import model.*;

public class CreateCommand implements Command {
	private DocumentManager manager; 
	private LatexEditorController controller;
	
	public CreateCommand(LatexEditorController control){
		controller=control;
		manager=new DocumentManager();
	}
	@Override
	public void execute(Document doc, String args[]) {
		String info = args[1];
		doc=manager.createDocument(info);
		controller.setDocument(doc);
		
	}

}
