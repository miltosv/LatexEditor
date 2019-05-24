package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ AddLatexTest.class, CreateTest.class, EditTest.class,SaveTest.class,LoadTest.class})
public class AllTests {
	//The above directives simply run all tests
}
