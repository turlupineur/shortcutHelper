package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.helper.propertyHelper.IPropertyHelper;
import shortcutHelper.backend.helper.shortcutHelper.IShortcutHelper;

public abstract class AbstractRefreshFunctionality extends AbstractDefaultRefreshFunctionality
		implements IDefaultRefreshFunctionality {
	private IPropertyHelper propertyHelper;
	private IShortcutHelper shortcutHelper;

	public IShortcutHelper getShortcutHelper() {
		return shortcutHelper;
	}

	public void setShortcutHelper(IShortcutHelper shortcutHelper) {
		this.shortcutHelper = shortcutHelper;
	}

	public IPropertyHelper getPropertyHelper() {
		return propertyHelper;
	}

	public void setPropertyHelper(IPropertyHelper propertyHelper) {
		this.propertyHelper = propertyHelper;
	}
}
