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

public class VersionsTest {
	
	private VersionsCommand com;
	private String[] changes= null;
	private Command com2;
	private Document doc;
	private LatexEditorController controller;
	
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
	public void test_volatileVersion() {
		changes[0]= "";
		changes[1]="Enable";
		doc=new Document("test1","Empty");
		com.execute(doc,changes);
		changes[1]="test2";
		com2.execute(doc,changes);
		changes[1]="Commit";
		com.execute(doc,changes);
		assertEquals("Volatile fail, contents aren't equals!" ,com.getVManager().getPreviousVersion().getContents(),"test1");
	}
	
	@Test(expected=NullPointerException.class)
	public void test_stableVersion() {
		changes[0]= "";
		changes[1]="Stable";
		changes[2]="src\\testlocation\\test";
		doc=new Document("test1","Empty");
		com.execute(doc,changes);
		changes[1]="test2";
		com2.execute(doc,changes);
		changes[1]="Commit";
		com.execute(doc,changes);
		assertEquals("Stable fail, contents aren't equals!" ,com.getVManager().getPreviousVersion().getContents(),"test1");
	}

}
