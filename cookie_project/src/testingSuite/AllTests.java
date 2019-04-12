package testingSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDataInterface.class, TestdbConnect.class, TestTotalAmounts.class, TestdbConnect.class, TestTypes.class })
public class AllTests {

}
