package shortcutHelper.helper;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/beans/backend/util/util.xml", "/config/beans/backend/helper/helper.xml",
		"/config/beans/backend/util/util-man.xml", "/config/beans/backend/helper/helper-man.xml",
		"/config/beans/backend/service/service-man.xml", "/config/beans/backend/service/service.xml" })
public class HelperIntegrationTesting {
	@Before
	public void setUp() {

	}
}
