package shortcutHelper.helper.shortcutRegistrationHelper;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelperInternalOperation;

public abstract class AbstractShortcutRegistrationHelper implements IShortcutRegistrationHelper {
	private IShortcutHelperInternalOperation shortcutHelper;
	private IShortcutFactoryHelper shortcutFactoryHelper;

	public IShortcutHelperInternalOperation getShortcutHelper() {
		return shortcutHelper;
	}

	public void setShortcutHelper(IShortcutHelperInternalOperation shortcutHelper) {
		this.shortcutHelper = shortcutHelper;
	}

	public IShortcutFactoryHelper getShortcutFactoryHelper() {
		return shortcutFactoryHelper;
	}

	public void setShortcutFactoryHelper(IShortcutFactoryHelper shortcutFactoryHelper) {
		this.shortcutFactoryHelper = shortcutFactoryHelper;
	}

}
