package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Document;
import model.VersionsManager;

public class ChangeStrategyTest {
	private VersionsManager manager;
	private Document doc;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}
	
	@Before
	public void setUp() throws Exception {
		manager = new VersionsManager();
	}

	@Test
	public void test_changeStrategy_volatileToStable() {
		doc=new Document("LatexEditor","Empty");
		manager.setCurrentVersion(doc);
		manager.changeStrategy("Stable","C:\\Users\\stell\\Desktop\\test");
		assertEquals("Volatile to Stable fail, strategy isn't equals!" , manager.getStrategyType(),"Stable");
		assertEquals("Volatile to Stable fail, contents aren't equals!" , manager.getPreviousVersion().getContents(), "LatexEditor");
	}
		
	@Test
	public void test_changeStrategy_StableToVolatile() {
		manager.changeStrategy("Stable","");
		manager.changeStrategy("Volatile","");
		assertEquals("Stable to Volatile fail, strategy isn't equals!" , manager.getStrategyType(),"Volatile");
	}

}
