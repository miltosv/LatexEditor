package controller;

import java.util.HashMap;

public class LatexEditorController {
	private HashMap<String, Command> latexControllerMap = new HashMap<String,Command>();
	private CommandsFactory factory = new CommandsFactory();
	
	public LatexEditorController() {
		latexControllerMap.put("CreateCommand", factory.create("CreateCommand"));
		latexControllerMap.put("AddLatexCommand", factory.create("AddLatexCommand"));
		latexControllerMap.put("RollbackToPreviousVersionCommand", factory.create("RollbackToPreviousVersionCommand"));
		latexControllerMap.put("EditCommand", factory.create("EditCommand"));
		latexControllerMap.put("LoadCommand", factory.create("LoadCommand"));
		latexControllerMap.put("SaveCommand", factory.create("SaveCommand"));
		latexControllerMap.put("EnableVersionsManagementCommand", factory.create("EnableVersionsManagementCommand"));
		latexControllerMap.put("DisableVersionsManagementCommand", factory.create("DisableVersionsManagementCommand"));
		latexControllerMap.put("ChangeVersionsStrategyCommand", factory.create("ChangeVersionsStrategyCommand"));
	}
	
	
	
	public void enact(String key) {
		latexControllerMap.get(key).execute();
		
	}
}
