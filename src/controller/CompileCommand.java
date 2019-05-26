package controller;

import java.io.IOException;

import model.Document;

public class CompileCommand implements Command {
	LatexEditorController controller;
	//String command = "cmd /c pdflatex ";
	
	public CompileCommand(LatexEditorController cont) {
		controller=cont;
	}
	@Override
	public void execute(Document doc, String[] args) {
		
		System.err.println(args[1]);
		try
		{
		  Process process = Runtime.getRuntime().exec(new String[] {"cmd","/K","pdflatex ",args[1]});
		  
		} catch (IOException e)
		{
		    e.printStackTrace();
		}

	}

}
