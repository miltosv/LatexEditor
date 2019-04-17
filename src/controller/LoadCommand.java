package controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import model.Document;



public class LoadCommand implements Command {

	private LatexEditorController controller;
	public LoadCommand(LatexEditorController control) {
		controller=control;
	}
	@Override
	public void execute(Document doc, String info) {
		
		doc=new Document("","empty");
		//MAYBE DOCUMENT SHOULD HANDLE THAT TOO OR DOC MANAGER WHO KNOWS. I DON'T ~MILTOSV

		try {
			String content = new String(Files.readAllBytes(Paths.get(info)));
			doc.setContents(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
