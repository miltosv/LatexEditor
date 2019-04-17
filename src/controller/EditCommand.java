package controller;

import model.Document;

public class EditCommand implements Command {

	private LatexEditorController controller;
	
	public EditCommand(LatexEditorController control) {
		controller=control;
	}
	@Override
	public void execute(Document doc, String info) {
		doc.setContents(info);	
		
		

	}

}
