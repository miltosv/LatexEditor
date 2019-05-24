package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.CommandsFactory;
import model.Document;
import model.DocumentManager;

public class LoadTest {

	private Document doc;
	private DocumentManager manager;
	private Command com;
	private CommandsFactory factory;
	private String changes;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		doc = manager.createDocument("Empty");
		factory = new CommandsFactory();
		com = factory.create("LoadCommand");
		changes = "Test for the LoadCommand";
	}

	@Test
	public void test() {
		com.execute(doc, changes);
		assertEquals("Load fail, contents aren't equals!","", doc.getContents());
	}

}
