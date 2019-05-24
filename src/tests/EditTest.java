package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.EditCommand;
import controller.LatexEditorController;
import model.Document;

public class EditTest {
	
	private Document doc;
	private String[] changes= null;
	private Command com;
	private LatexEditorController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		controller=new LatexEditorController();
		com = new EditCommand(controller);
	}

	@Test(expected=NullPointerException.class)
	public void test_EditCommand() {
		changes[0]= "";
		changes[1]="Test for EditCommand";
		doc=new Document("","Empty");
		com.execute(doc,changes);
		assertEquals("Create fail, contents aren't equals!", doc.getContents(),"Test for EditCommand");
	}

}
