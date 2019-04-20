package shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction;

import shortcutHelper.backend.backendInteraction.AbstractBackendInteraction;
import shortcutHelper.backend.functionality.executerFunctionality.IDefaultExecuterFunctionality;
import shortcutHelper.helper.shortcutFactoryHelper.IDefaultShortcutFactoryHelper;
import shortcutHelper.helper.shortcutHelper.IDefaultShortcutHelper;

public abstract class AbstractSubmitShortcutBackendInteraction extends AbstractBackendInteraction
		implements ISubmitShortcutBackendInteraction {
	private IDefaultExecuterFunctionality executerFunctionality;
	private IDefaultShortcutHelper shortcutHelper;
	private IDefaultShortcutFactoryHelper shortcutFactoryHelper;

	public IDefaultShortcutHelper getShortcutHelper() {
		return shortcutHelper;
	}

	public void setShortcutHelper(IDefaultShortcutHelper shortcutHelper) {
		this.shortcutHelper = shortcutHelper;
	}

	public IDefaultShortcutFactoryHelper getShortcutFactoryHelper() {
		return shortcutFactoryHelper;
	}

	public void setShortcutFactoryHelper(IDefaultShortcutFactoryHelper shortcutFactoryHelper) {
		this.shortcutFactoryHelper = shortcutFactoryHelper;
	}

	public IDefaultExecuterFunctionality getExecuterFunctionality() {
		return executerFunctionality;
	}

	public void setExecuterFunctionality(IDefaultExecuterFunctionality executerFunctionality) {
		this.executerFunctionality = executerFunctionality;
	}
}
