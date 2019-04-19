package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class TestSave {

	private Document doc;
	private DocumentManager manager;
	private Command com;
	private CommandsFactory factory;
	private String changes;
	
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	public void setUp() throws Exception {
		doc = manager.createDocument("Empty");
		factory = new CommandsFactory();
		com = factory.create("SaveCommand");
		changes = "Test for the SaveCommand";
	}
	
	@Test
	public void testAcceptance() {
		com.execute(doc, changes);
		assertEquals("Save fail, contents aren't equals!","", doc.getContents());
	}

}
