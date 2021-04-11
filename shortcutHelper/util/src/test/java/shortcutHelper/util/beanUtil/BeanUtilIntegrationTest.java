package shortcutHelper.util.beanUtil;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.util.UtilIntegrationTesting;

public class BeanUtilIntegrationTest extends UtilIntegrationTesting {
	@Autowired
	private IBeanUtil beanUtil;

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void beanNameFromClass_interfaceClass() {
		assertThat(beanUtil.getBeanNameFromClass(IBeanUtil.class), is(IBeanUtil.BEAN_ID));
	}

	@Test
	public void beanNameFromClass_implClass() {
		assertThat(beanUtil.getBeanNameFromClass(IBeanUtil.class), is(IBeanUtil.BEAN_ID));
	}

	@Test
	public void beanNameFromClass_null() {
		assertEquals(null, beanUtil.getBeanNameFromClass(null));
	}

	@Test
	public void beanNameFromClass_invalidClass() {
		assertEquals(null, beanUtil.getBeanNameFromClass(String.class));
	}

	@Test
	public void beanClassFromBeanName_null() {
		try {
			beanUtil.getInterfaceFromBeanName(null);
			fail("Exception not thrown");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	public void beanClassFromBeanName_normalValue() {
		assertEquals(IBeanUtil.class, beanUtil.getInterfaceFromBeanName(IBeanUtil.BEAN_ID));
	}

	@Test
	public void getInterfaceFromClass_interface() {
		assertEquals(IBeanUtil.class, beanUtil.getInterfaceFromClass(IBeanUtil.class));
	}

	@Test
	public void getInterfaceFromClass_abstractClass() {
		assertEquals(IDefaultBeanUtil.class, beanUtil.getInterfaceFromClass(AbstractBeanUtil.class));
	}

	@Test
	public void getInterfaceFromClass_implClass() {
		assertEquals(IDefaultBeanUtil.class, beanUtil.getInterfaceFromClass(BeanUtilImpl.class));
	}

}
