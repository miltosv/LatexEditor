package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.EditCommand;
import controller.LatexEditorController;
import controller.VersionsCommand;
import model.Document;

public class RollBackTest {
	
	private VersionsCommand com;
	private String[] changes= null;
	private Command com2;
	private Document doc;
	private LatexEditorController controller;
	private String contents;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		controller=new LatexEditorController();
		com = new VersionsCommand(controller);
		com2 = new EditCommand(controller);
	}

	@Test(expected=NullPointerException.class)
	public void test_rollBack() {
		changes[0]= "";
		changes[1]="Enable";
		doc=new Document("Stella","Empty");
		com.execute(doc,changes);
		changes[1]="Delia";
		com2.execute(doc,changes);
		changes[1]="Commit";
		com.execute(doc,changes);
		contents=com.getVManager().getPreviousVersion().getContents();
		changes[1]="Rollback";
		com.execute(doc,changes);
		assertEquals("Rollback fail, contents aren't equals!" ,com.getVManager().getCurrentVersion().getContents(),contents);
		
	}

}
