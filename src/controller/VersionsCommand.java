package controller;

import model.*;

public class VersionsCommand implements Command {
	private LatexEditorController controller;
	private VersionsManager VManager;
	
	public VersionsCommand(LatexEditorController ctrl) {
		controller = ctrl;
		VManager = new VersionsManager();
		System.err.println("versions command");
	}
	@Override
	public void execute(Document doc, String[] args) {
		switch (args[1]) {
		case "Commit":
			VManager.setCurrentVersion(doc);
			//System.out.println(doc.getContents());
			break;
		case "Rollback":
			controller.setDocument(VManager.getPreviousVersion());
			break;
		case "Enable":
			VManager.Enable();
			break;

		case "Disable":
			VManager.Disable();
			break;

		case "Stable":
			VManager.changeStrategy(args[1],args[2]);
			break;

		case "Volatile":
			VManager.changeStrategy(args[1]," ");
			break;

		case "Undo":
			controller.setDocument(VManager.getPreviousVersion());
			break;

//		default :
			//System.out.println("none");
		}
	}
	
	public VersionsManager getVManager() {
		return VManager;
	}
	public void setVManager(VersionsManager vManager) {
		VManager = vManager;
	}

}
