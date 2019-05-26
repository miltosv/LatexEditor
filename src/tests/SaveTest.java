package tests;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Command;
import controller.LatexEditorController;
import controller.SaveCommand;
import model.Document;

public class SaveTest {
	
	private Document doc;
	private Document doc2;
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
		com = new SaveCommand(controller);
	}

	@Test(expected=NullPointerException.class)
	public void test_SaveCommand() {
		doc=new Document("Test for the SaveCommand","Empty");
		changes[0]="";
		changes[1] = "C:\\Users\\stell\\test.tex";
		com.execute(doc, changes);
		String info = changes[1];
		doc2=new Document("","empty");

		try {
			String content = new String(Files.readAllBytes(Paths.get(info)));
			doc2.setContents(content);
			controller.setDocument(doc2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		assertEquals("Save fail, contents aren't equals!",doc2.getContents(),"Test for the SaveCommand");
	}

}
