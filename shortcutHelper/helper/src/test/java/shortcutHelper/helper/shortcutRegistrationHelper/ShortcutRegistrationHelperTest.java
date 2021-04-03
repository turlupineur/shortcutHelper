package shortcutHelper.helper.shortcutRegistrationHelper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import shortcutHelper.common.obervation.ShortcutListObserver;
import shortcutHelper.helper.HelperTesting;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelperInternalOperation;
import shortcutHelper.helper.test.behaviour.ShortcutMockingFactoryBehaviour;

public class ShortcutRegistrationHelperTest extends HelperTesting implements ShortcutMockingFactoryBehaviour {

	@InjectMocks
	private ShortcutRegistrationHelperImpl shortcutRegistrationHelperImpl;

	@Mock
	private IShortcutHelperInternalOperation shortcutHelper;

	@Mock
	private IShortcutFactoryHelper shortcutFactoryHelper;

	@Mock
	private ShortcutListObserver myObserver;

	@Before
	public void setUp() {
		super.setUp();

		// setting observers
		List<ShortcutListObserver> observers = new ArrayList<ShortcutListObserver>();
		observers.add(myObserver);
		shortcutRegistrationHelperImpl.setShortcutListObservers(observers);
	}

	@Test
	public void addShortcut() {
		String shortcutName = "shortcutName";
		IShortcut shortcut = createMockShortcut(shortcutName, "bean", String.class, null);
		String rawShortcut = "rawShortcut";
		when(shortcutFactoryHelper.convertShortcutToString(shortcut)).thenReturn(rawShortcut);

		shortcutRegistrationHelperImpl.addShortcut(shortcut);

		verify(shortcutHelper, times(1)).addNonNativeShortcut(shortcutName, rawShortcut);
		verify(myObserver, times(1)).listUpdated(Mockito.anyMapOf(String.class, String.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addInvalidShortcut() {
		IShortcut shortcut = createMockShortcut(null, "bean", String.class, null);

		shortcutRegistrationHelperImpl.addShortcut(shortcut);
	}
}
