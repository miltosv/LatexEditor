package controller;

import model.Document;

public class EnableVersionsManagementCommand implements Command{

private LatexEditorController controller;
	
	public EnableVersionsManagementCommand(LatexEditorController control) {
		controller=control;
	}
	@Override
	public void execute(Document doc, String info) {
		// TODO Auto-generated method stub
		
	}

}
