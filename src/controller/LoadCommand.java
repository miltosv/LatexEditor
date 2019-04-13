package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class LoadCommand implements Command {

	@Override
	public void execute() {
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
