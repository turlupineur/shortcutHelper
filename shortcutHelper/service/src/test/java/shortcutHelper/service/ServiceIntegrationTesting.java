package shortcutHelper.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/beans/service/service-man.xml", "/config/beans/service/service.xml" })
public class ServiceIntegrationTesting {
	@Before
	public void setUp() {

	}
}
