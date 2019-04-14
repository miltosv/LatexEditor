package controller;

import java.util.HashMap;
import model.Document;

public class LatexEditorController {
	private HashMap<String, Command> latexControllerMap = new HashMap<String,Command>();
	private CommandsFactory factory = new CommandsFactory();
	private Document doc = new Document("","");
	
	public LatexEditorController() {
		latexControllerMap.put("Create", factory.create("CreateCommand"));
		latexControllerMap.put("AddLatex", factory.create("AddLatexCommand"));
		latexControllerMap.put("Rollback", factory.create("RollbackToPreviousVersionCommand"));
		latexControllerMap.put("Edit", factory.create("EditCommand"));
		latexControllerMap.put("Load", factory.create("LoadCommand"));
		latexControllerMap.put("Save", factory.create("SaveCommand"));
		latexControllerMap.put("ActivateTrack", factory.create("EnableVersionsManagementCommand"));
		latexControllerMap.put("DisableVersionsManagementCommand", factory.create("DisableVersionsManagementCommand"));
		latexControllerMap.put("ChangeVersionsStrategyCommand", factory.create("ChangeVersionsStrategyCommand"));
	}
	
	
	public void enact(String key,String info) {
		latexControllerMap.get(key).execute(doc,info);
		
	}
}
