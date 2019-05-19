package controller;

import model.Document;

public class EditCommand implements Command {

	private LatexEditorController controller;
	
	public EditCommand(LatexEditorController control) {
		controller=control;
	}
	@Override
	public void execute(Document doc, String [] args)
	{
		String info = args[1];
		doc.setContents(info);	
		
		

	}

}
