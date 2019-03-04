package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteraction;
import shortcutHelper.backendCommand.refreshCommand.IDefaultRefreshCommand;

public abstract class AbstractUpdateMainInterfaceBackendInteraction extends BackendInteraction implements IUpdateMainInterfaceBackendInteraction{
	private IDefaultRefreshCommand refreshCommand;

	public IDefaultRefreshCommand getRefreshCommand() {
		return refreshCommand;
	}

	public void setRefreshCommand(IDefaultRefreshCommand refreshCommand) {
		this.refreshCommand = refreshCommand;
	}

}
