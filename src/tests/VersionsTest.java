package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import controller.Command;
//import controller.EditCommand;
//import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class VersionsTest {
	
	//private String[] version;
	private VersionsManager manager;
	//private EditCommand com2;
	private Document doc;
	//private LatexEditorController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		//controller=new LatexEditorController();
		manager = new VersionsManager();
		//com2 = new EditCommand(controller);
	}

	@Test(expected=NullPointerException.class)
	public void test_volatileVersion() {
		//version[0]= "";
		//version[1]="Enable";
		doc = new Document("","Empty");
		//com.execute(doc,version);
		doc.setContents("Stella");
		manager.setCurrentVersion(doc);
		System.out.println(doc.getContents()+" "+ "after change");
		//version[0]= "";
		//version[1]="Delia";
		doc.setContents("Delia");
		//com2.execute(doc,version);
		manager.setCurrentVersion(doc);
		System.out.println(doc.getContents()+" "+ "after change");
		assertEquals("Volatile fail, contents aren't equals!" , manager.getPreviousVersion(),"Stella");
	}

}
