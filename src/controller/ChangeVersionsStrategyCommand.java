package controller;

import model.Document;

public class ChangeVersionsStrategyCommand implements Command{
private LatexEditorController controller;
	
	public ChangeVersionsStrategyCommand(LatexEditorController control) {
		controller=control;
	}
	@Override
	public void execute(Document doc, String info) {
		// TODO Auto-generated method stub
		
	}

}
