package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({CreateTest.class,EditTest.class, AddLatexTest.class, VersionsTest.class, ChangeStrategyTest.class,DisableVersionsTest.class,RollBackTest.class, SaveTest.class, LoadTest.class})
public class AllTests {
	//The above directives simply run all tests
}
