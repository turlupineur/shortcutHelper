package shortcutHelper.util;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/beans/util/util.xml", "/config/beans/util/util-man.xml" })
public class UtilIntegrationTesting {
	@Before
	public void setUp() {

	}

}
