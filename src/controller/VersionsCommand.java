package controller;

import model.*;

public class VersionsCommand implements Command {
	private LatexEditorController controller;
	private VersionsManager VManager;
	
	
	public VersionsCommand(LatexEditorController ctrl) {
		controller = ctrl;
		VManager = new VersionsManager();
	}
	@Override
	public void execute(Document doc, String[] args) {
		

	}

}
