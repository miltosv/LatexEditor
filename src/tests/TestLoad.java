package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class TestLoad {

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
		com = factory.create("LoadCommand");
		changes = "Test for the LoadCommand";
	}
	
	@Test
	public void testAcceptance() {
		com.execute(doc, changes);
		assertEquals("Load fail, contents aren't equals!","", doc.getContents());
	}

}
