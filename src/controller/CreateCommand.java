package controller;

import model.*;

public class CreateCommand implements Command {
	private DocumentManager manager; 
	CreateCommand(){
		manager=new DocumentManager();
	}
	@Override
	public void execute(Document doc, String info) {
		
		//Document newdocument;
		doc=manager.createDocument(info);
		//doc=newdocument;
		//System.out.println(doc.getType());

	}

}
