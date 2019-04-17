package controller;

import model.Document;

public class RollbackToPreviousVersionCommand implements Command {

	private LatexEditorController controller;
	
	public RollbackToPreviousVersionCommand(LatexEditorController control) {
		controller=control;
	}

	
	@Override
	public void execute(Document doc, String info) {
		// TODO Auto-generated method stub
		
	}

}
