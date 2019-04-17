package controller;

import model.Document;

public class SaveCommand implements Command {

	private LatexEditorController controller;
	public SaveCommand(LatexEditorController control) {
		controller=control;
	}
	
	@Override
	public void execute(Document doc, String info) {
		
		doc.Save(info);

	}

}
