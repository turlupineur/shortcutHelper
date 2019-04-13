package shortcutHelper.helper;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/beans/util/util.xml", "/config/beans/helper/helper.xml",
		"/config/beans/util/util-man.xml", "/config/beans/helper/helper-man.xml",
		"/config/beans/service/service-man.xml", "/config/beans/service/service.xml" })
public class HelperIntegrationTesting {
	@Before
	public void setUp() {

	}
}
