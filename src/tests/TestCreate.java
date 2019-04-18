package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Command;
import controller.CommandsFactory;
import controller.CreateCommand;
import model.Document;

public class TestCreate {
	private Document doc;
	private Command comFac;
	private CommandsFactory factory;
	private CreateCommand create;
	
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	public void setUp() throws Exception {
		doc = new Document();
		comFac = new CommandsFactory("CreateCommand");
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
