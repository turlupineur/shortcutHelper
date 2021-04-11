package shortcutHelper.helper.test.behaviour;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public interface ShortcutMockingFactoryBehaviour {
	public default IShortcut createMockShortcut(String name, String beanName, Class clazz, String[] params) {
		IShortcut shortcut = mock(IShortcut.class);

		when(shortcut.getName()).thenReturn(name);
		when(shortcut.getBeanName()).thenReturn(beanName);
		when(shortcut.getClassRepresentingCommand()).thenReturn(clazz);
		when(shortcut.getParams()).thenReturn(params);

		return shortcut;
	}
}
