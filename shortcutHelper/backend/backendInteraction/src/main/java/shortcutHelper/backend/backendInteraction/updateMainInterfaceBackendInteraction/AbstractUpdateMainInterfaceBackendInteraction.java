package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.AbstractBackendInteraction;
import shortcutHelper.backend.functionality.refreshFunctionality.IDefaultRefreshFunctionality;

public abstract class AbstractUpdateMainInterfaceBackendInteraction extends AbstractBackendInteraction
		implements IUpdateMainInterfaceBackendInteraction {
	private IDefaultRefreshFunctionality refreshFunctionality;

	public IDefaultRefreshFunctionality getRefreshFunctionality() {
		return refreshFunctionality;
	}

	public void setRefreshFunctionality(IDefaultRefreshFunctionality refreshFunctionality) {
		this.refreshFunctionality = refreshFunctionality;
	}
}
