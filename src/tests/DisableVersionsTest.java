package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.VersionsManager;

public class DisableVersionsTest {
	
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
	public void test_disableVersions() {
		manager.Disable();
		assertFalse("Disable Versions fail, contents isn't equals!" , manager.isStatus());
	}
	
	@Test
	public void test_disableVersions_contentsdoentchange() {
		manager.Disable();
		
		assertFalse("Disable Versions fail, contents isn't equals!" , manager.isStatus());
	}

}
