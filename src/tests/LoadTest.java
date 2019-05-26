package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.LatexEditorController;
import controller.LoadCommand;
import model.Document;

public class LoadTest {

	private Document doc;
	private Command com;
	private String[] changes;
	private LatexEditorController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		controller=new LatexEditorController();
		com = new LoadCommand(controller);
	}

	@Test(expected=NullPointerException.class)
	public void test_LoadCommand() {
		changes[0]="";
		changes[1] = "src\\testlocation\\test.tex";
		doc=new Document("","empty");
		com.execute(doc, changes);
		assertEquals("Load fail, contents aren't equals!",doc.getContents(),"This is a test");
	}

}
