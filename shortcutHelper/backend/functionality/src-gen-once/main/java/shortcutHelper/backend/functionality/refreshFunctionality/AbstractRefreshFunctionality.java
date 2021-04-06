package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.common.dynamicCommand.IDynamicCommandController;
import shortcutHelper.helper.propertyHelper.IPropertyHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;

public abstract class AbstractRefreshFunctionality extends AbstractDefaultRefreshFunctionality
		implements IDefaultRefreshFunctionality {
	private IPropertyHelper propertyHelper;
	private IShortcutHelper shortcutHelper;
	private IDynamicCommandController dynamicCommandController;

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

	public IDynamicCommandController getDynamicCommandController() {
		return dynamicCommandController;
	}

	public void setDynamicCommandController(IDynamicCommandController dynamicCommandController) {
		this.dynamicCommandController = dynamicCommandController;
	}

}
