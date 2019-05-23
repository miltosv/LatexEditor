package controller;

import java.util.HashMap;
import view.Window;
import model.Document;

public class LatexEditorController {
	private Window view;
	private HashMap<String, Command> latexControllerMap = new HashMap<String,Command>();
	private CommandsFactory factory = new CommandsFactory(this);
	private Document document;
	//private RefreshFactory Rfactory = new RefreshFactory();
	//private Refresh contentR;
	
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
//		latexControllerMap.put("EnableVersions", factory.create("EnableVersionsCommand"));
//		latexControllerMap.put("DisableVersions", factory.create("DisableVersionsCommand"));
//		latexControllerMap.put("ChangeStrategy", factory.create("ChangeStrategyCommand"));
//		latexControllerMap.put("Rollback", factory.create("RollbackToPreviousVersionCommand"));
		document = new Document("","Empty");
		view=w;
	}
	
	public void setDocument(Document doc) {
		document=doc;
	}
	
	private String update() {
		
		//System.err.println("xxxxxxxx" + document.getContents());
		return document.getContents();
		
		
	}
	
	public void enact(String [] args) {
		String key=args[0];
		//System.out.println(key);
		//System.out.println(args[1]);
		//System.err.println("enact"+document);
		latexControllerMap.get(key).execute(document,args);
		
		view.ReFreshText(this.update());
		//System.out.println(document.getContents());
	}
	
	
}
