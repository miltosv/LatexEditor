package controller;

import java.util.HashMap;
import view.Window;
import model.Document;

public class LatexEditorController {
	private Window view;
	private HashMap<String, Command> latexControllerMap = new HashMap<String,Command>();
	private CommandsFactory factory = new CommandsFactory(this);
	private Document document;
	
	
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
	
	
	public LatexEditorController(Window w) {
		latexControllerMap.put("Create", factory.create("CreateCommand"));
		latexControllerMap.put("AddLatex", factory.create("AddLatexCommand"));
		latexControllerMap.put("Edit", factory.create("EditCommand"));
		latexControllerMap.put("Load", factory.create("LoadCommand"));
		latexControllerMap.put("Save", factory.create("SaveCommand"));
		latexControllerMap.put("Versions", factory.create("VersionsCommand"));
		latexControllerMap.put("Compile",factory.create("Compile"));
		document = new Document("","Empty");
		view=w;
	}
	
	public void setDocument(Document doc) {
		document=doc;
	}
	
	private String update() {
		
		
		return document.getContents();
		
		
	}
	
	public void enact(String [] args) {
		String key=args[0];
		
		latexControllerMap.get(key).execute(document,args);
		
		view.ReFreshText(this.update());
	}
	
	
}
