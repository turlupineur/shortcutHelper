package shortcutHelper.backend.dynamicCommand;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;

public abstract class AbstractDynamicCommand implements IDynamicCommand {
	private IShortcutFactoryHelper shortcutFactoryHelper;

	public IShortcutFactoryHelper getShortcutFactoryHelper() {
		return shortcutFactoryHelper;
	}

	public void setShortcutFactoryHelper(IShortcutFactoryHelper shortcutFactoryHelper) {
		this.shortcutFactoryHelper = shortcutFactoryHelper;
	}
}
