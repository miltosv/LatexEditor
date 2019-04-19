package tests;

import static org.junit.Assert.assertEquals;


import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class TestEdit {
	private Document doc;
	private DocumentManager manager;
	private String changes;
	private Command com;
	private CommandsFactory factory;
	
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	public void setUp() throws Exception {
		doc = manager.createDocument("Empty");
		factory = new CommandsFactory();
		com = factory.create("EditCommand");
		changes="Test for EditCommand";
	}
	
	public void testAcceptance() {		
		com.execute(doc,changes);
		assertEquals("Edit fail, contents aren't equals!", changes, doc.getContents());
	}
}
