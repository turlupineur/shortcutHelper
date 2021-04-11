package shortcutHelper.middleend.interaction.updateMainInterfaceInteraction;

import shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction.IUpdateMainInterfaceBackendInteraction;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;
import shortcutHelper.middleend.interaction.Interaction;

public abstract class AbstractUpdateMainInterfaceInteraction extends Interaction implements IUpdateMainInterfaceInteraction{
	private IUpdateMainInterfaceBackendInteraction updateMainInterfaceBackendInteraction;
	private IShortcutHelper shortcutHelper;
	
	public IUpdateMainInterfaceBackendInteraction getUpdateMainInterfaceBackendInteraction() {
		return updateMainInterfaceBackendInteraction;
	}

	public void setUpdateMainInterfaceBackendInteraction(
			IUpdateMainInterfaceBackendInteraction updateMainInterfaceBackendInteraction) {
		this.updateMainInterfaceBackendInteraction = updateMainInterfaceBackendInteraction;
	}

	public IShortcutHelper getShortcutHelper() {
		return shortcutHelper;
	}

	public void setShortcutHelper(IShortcutHelper shortcutHelper) {
		this.shortcutHelper = shortcutHelper;
	}
}
