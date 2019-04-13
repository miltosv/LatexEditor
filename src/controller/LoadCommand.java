package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class LoadCommand implements Command {

	@Override
	public void execute() {

		//MAYBE DOCUMENT SHOULD HANDLE THAT TOO OR DOC MANAGER WHO KNOWS. I DON'T ~MILTOSV

		try {
			String content = new String(Files.readAllBytes(Paths.get("filepath")));
			doc.setContents(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
