package shortcutHelper.helper.shortcutRegistrationHelper;

import java.util.Map;

import shortcutHelper.common.obervation.ShortcutListObserver;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class ShortcutRegistrationHelperImpl extends AbstractShortcutRegistrationHelper {

	public void addShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToAdd) {
		checkShortcutIsValid(shortcutToAdd);
		String rawShortcut = getShortcutFactoryHelper().convertShortcutToString(shortcutToAdd);
		getShortcutHelper().addNonNativeShortcut(shortcutToAdd.getName(), rawShortcut);
		notifyObserver();
	}

	public void replaceShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToAdd) {
		checkShortcutIsValid(shortcutToAdd);
		String rawShortcut = getShortcutFactoryHelper().convertShortcutToString(shortcutToAdd);
		getShortcutHelper().replaceNonNativeShortcut(shortcutToAdd.getName(), rawShortcut);
		notifyObserver();
	}

	public boolean removeShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToRemove) {
		checkShortcutIsValid(shortcutToRemove);
		boolean success = getShortcutHelper().removeShortcut(shortcutToRemove.getName());
		if (success) {
			notifyObserver();
		}
		return success;
	}

	public boolean hasShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToCheck) {
		checkShortcutIsValid(shortcutToCheck);
		return getShortcutHelper().getShortcut(shortcutToCheck.getName()) != null;
	}

	public java.util.Map<String, String> getAllShortcuts() {
		return getShortcutHelper().getListShortcuts();
	}

	private void checkShortcutIsValid(IShortcut shortcutToCheck) {
		if (shortcutToCheck == null || shortcutToCheck.getName() == null || shortcutToCheck.getName().length() == 0) {
			throw new IllegalArgumentException("Shortcut null or name invalid.");
		}
	}

	private void notifyObserver() {
		for (ShortcutListObserver observer : getShortcutListObservers()) {
			Map<String, String> shortcuts = getAllShortcuts();
			observer.listUpdated(shortcuts);
		}
	}
}