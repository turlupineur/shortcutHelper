package shortcutHelper.helper.shortcutRegistrationHelper;

import java.util.List;

import shortcutHelper.common.obervation.ShortcutListObserver;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelperInternalOperation;

public abstract class AbstractShortcutRegistrationHelper implements IShortcutRegistrationHelper {
	private IShortcutHelperInternalOperation shortcutHelper;
	private IShortcutFactoryHelper shortcutFactoryHelper;
	private List<ShortcutListObserver> shortcutListObservers;

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

	public List<ShortcutListObserver> getShortcutListObservers() {
		return shortcutListObservers;
	}

	public void setShortcutListObservers(List<ShortcutListObserver> shortcutListObservers) {
		this.shortcutListObservers = shortcutListObservers;
	}

}
