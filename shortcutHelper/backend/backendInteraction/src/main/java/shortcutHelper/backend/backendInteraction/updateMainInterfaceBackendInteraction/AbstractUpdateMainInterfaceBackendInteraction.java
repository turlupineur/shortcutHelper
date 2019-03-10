package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.AbstractBackendInteraction;
import shortcutHelper.backendCommand.refreshCommand.IDefaultRefreshCommand;

public abstract class AbstractUpdateMainInterfaceBackendInteraction extends AbstractBackendInteraction implements IUpdateMainInterfaceBackendInteraction{
	private IDefaultRefreshCommand refreshCommand;

	public IDefaultRefreshCommand getRefreshCommand() {
		return refreshCommand;
	}

	public void setRefreshCommand(IDefaultRefreshCommand refreshCommand) {
		this.refreshCommand = refreshCommand;
	}

}
