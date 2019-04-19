package tests;

import static org.junit.Assert.assertEquals;

import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class TestAddLatex {
	private Document doc;
	private DocumentManager manager;
	private String command;
	private Command com;
	private CommandsFactory factory;
	
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	public void setUp() throws Exception {
		doc = manager.createDocument("Empty");
		factory = new CommandsFactory();
		com = factory.create("AddLatexCommand");
		command= "\\chapter{...} ";
	}
	
	public void testAcceptance() {	
		com.execute(doc,command);
		assertEquals("AddLatex fail, contents aren't equals!",command , doc.getContents());
	}
}
