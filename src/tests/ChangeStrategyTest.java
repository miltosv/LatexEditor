import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.VersionsManager;

public class ChangeStrategyTest {
	
	private VersionsManager manager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		manager = new VersionsManager();
	}

	@Test
	public void test_changeStrategy() {
		manager.changeStrategy("Stable","");
		assertEquals("Volatile to Stable fail, strategy isn't equals!" , manager.getStrategyType(),"Stable");
	}

}
