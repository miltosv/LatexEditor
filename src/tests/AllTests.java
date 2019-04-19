package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestAddLatex.class, TestCreate.class, TestEdit.class,TestSave.class,TestLoad.class})
public class AllTests {
	//The above directives simply run all tests
}
