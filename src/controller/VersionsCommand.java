package controller;

import model.*;

public class VersionsCommand implements Command {
	private LatexEditorController controller;
	private VersionsManager VManager;
	
	
	public VersionsCommand(LatexEditorController ctrl) {
		controller = ctrl;
		VManager = new VersionsManager();
		System.out.println("versions command");
	}
	@Override
	public void execute(Document doc, String[] args) {
		switch (args[1]) {
		case "Commit":
			VManager.setCurrentVersion(doc);
			System.out.println("Commit");
		case "Rollback":
			controller.setDocument(VManager.getPreviousVersion());
		case "Enable":
			VManager.Enable();
		case "Disable":
			VManager.Disable();
		case "Stable":
			VManager.changeStrategy(args[1]);
		case "Volatile":
			VManager.changeStrategy(args[1]);
		case "Undo":
			controller.setDocument(VManager.getPreviousVersion());
		default :
			//System.out.println("none");
		}
	}

}
