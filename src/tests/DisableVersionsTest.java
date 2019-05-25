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

public class DisableVersionsTest {
	
	private VersionsCommand com;
	private Command com2;
	private Document doc;
	private String[] changes= null;
	private LatexEditorController controller;
	private int versionID;
	
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
	public void test_disableVersions() {
		changes[0]= "";
		changes[1]="Enable";
		com.getVManager().Disable();
		assertFalse("Disable Versions fail, contents isn't equals!" , com.getVManager().isStatus());
	}
	
	@Test(expected=NullPointerException.class)
	public void test_disableVersions_contentsdoentchange() {
		doc=new Document("Stella","Empty");
		versionID=doc.getVersionID();
		com.getVManager().Disable();
		changes[0]= "";
		changes[1]="Delia";
		com2.execute(doc,changes);
		changes[1]="Commit";
		com.execute(doc,changes);
		assertEquals("Disable fail, contents aren't equals!" ,doc.getVersionID(),versionID);
	}

}
