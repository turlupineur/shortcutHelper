package shortcutHelper.helper.shortcutFactoryHelper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.helper.HelperIntegrationTesting;
import shortcutHelper.util.beanUtil.IBeanUtil;
import shortcutHelper.util.beanUtil.IDefaultBeanUtil;

public class ShortcutFactoryHelperIntegrationTest extends HelperIntegrationTesting {
	@Autowired
	private IShortcutFactoryHelper shortcutFactoryHelper;

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createShortcutFromClass_interfaceClass() {
		String[] params = { "1", "2" };

		IShortcut shortcut = shortcutFactoryHelper.createShortcut(IShortcutFactoryHelper.class, params);

		assertNotEquals("Shortcut object is not immutable.", shortcut.getParams(), params);
		assertThat(shortcut.getParams().length, is(params.length));
		assertEquals(shortcut.getParams()[0], params[0]);
		assertEquals(shortcut.getParams()[1], params[1]);
		assertEquals(shortcut.getBeanName(), IShortcutFactoryHelper.BEAN_ID);
	}

	@Test
	public void createShortcutFromClass_implClass() {
		String[] params = { "1", "2" };

		IShortcut shortcut = shortcutFactoryHelper.createShortcut(ShortcutFactoryHelperImpl.class, params);

		assertNotEquals("Shortcut object is not immutable.", shortcut.getParams(), params);
		assertThat(shortcut.getParams().length, is(params.length));
		assertEquals(shortcut.getParams()[0], params[0]);
		assertEquals(shortcut.getParams()[1], params[1]);
		assertEquals(shortcut.getBeanName(), IShortcutFactoryHelper.BEAN_ID);
	}

	@Test
	public void createShortcutFromClass_classNull() {
		String[] params = { "1", "2" };

		IShortcut shortcut = shortcutFactoryHelper.createShortcut((Class) null, params);

		assertNull(shortcut);
	}

	@Test
	public void createShortcutFromClass_paramNull() {
		IShortcut shortcut = shortcutFactoryHelper.createShortcut(ShortcutFactoryHelperImpl.class, null);

		assertTrue(shortcut.getParams().length == 0);
	}

	@Test
	public void createShortcutFromBean_interfaceClass() {
		String[] params = { "1", "2" };

		IShortcut shortcut = shortcutFactoryHelper.createShortcut(IShortcutFactoryHelper.BEAN_ID, params);

		assertNotEquals("Shortcut object is not immutable.", shortcut.getParams(), params);
		assertThat(shortcut.getParams().length, is(params.length));
		assertEquals(shortcut.getParams()[0], params[0]);
		assertEquals(shortcut.getParams()[1], params[1]);
		assertEquals(IDefaultShortcutFactoryHelper.class, shortcut.getClassRepresentingCommand());
	}

	@Test
	public void createShortcutFromBean_beanNameNull() {
		String[] params = { "1", "2" };

		IShortcut shortcut = shortcutFactoryHelper.createShortcut((String) null, params);

		assertNull(shortcut);
	}

	@Test
	public void createShortcutFromBean_paramNull() {
		IShortcut shortcut = shortcutFactoryHelper.createShortcut(ShortcutFactoryHelperImpl.class, null);

		assertTrue(shortcut.getParams().length == 0);
	}

	@Test
	public void parseShortcut_normalCase() {
		String line = IBeanUtil.BEAN_ID + IShortcutFactoryHelper.COMMAND_PARAMS_SEPARATOR + "1"
				+ IShortcutFactoryHelper.PARAMS_SEPARATOR + "2";

		IShortcut parsedShortcut = shortcutFactoryHelper.parseShortcut(line);

		assertEquals(IDefaultBeanUtil.class, parsedShortcut.getClassRepresentingCommand());
		assertTrue(parsedShortcut.getParams().length == 2);
		assertTrue(parsedShortcut.getParams()[0].equals("1"));
		assertTrue(parsedShortcut.getParams()[1].equals("2"));
		assertTrue(IBeanUtil.BEAN_ID.equals(parsedShortcut.getBeanName()));
	}

	@Test
	public void parseShortcut_noParameter() {
		String line = IBeanUtil.BEAN_ID;

		IShortcut parsedShortcut = shortcutFactoryHelper.parseShortcut(line);

		assertEquals(IDefaultBeanUtil.class, parsedShortcut.getClassRepresentingCommand());
		assertTrue(parsedShortcut.getParams().length == 0);
		assertTrue(IBeanUtil.BEAN_ID.equals(parsedShortcut.getBeanName()));
	}
}
