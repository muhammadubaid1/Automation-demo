package framework.com.stepDefinition;

import framework.com.utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Base {

    @Before
    public void setUp() {
        initializeDriver();
    }

    @After
    public void endDriver() {
        getDriver().quit();
    }
}
