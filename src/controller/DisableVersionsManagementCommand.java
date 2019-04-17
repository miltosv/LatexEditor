package controller;

import model.Document;

public class DisableVersionsManagementCommand implements Command {
	private LatexEditorController controller;
	
	public DisableVersionsManagementCommand(LatexEditorController control) {
		controller=control;
	}

	@Override
	public void execute(Document doc, String info) {
		// TODO Auto-generated method stub
		
	}

}
