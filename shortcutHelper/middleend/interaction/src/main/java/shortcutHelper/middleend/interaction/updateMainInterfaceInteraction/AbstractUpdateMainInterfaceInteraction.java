package shortcutHelper.middleend.interaction.updateMainInterfaceInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteraction;
import shortcutHelper.middleend.interaction.Interaction;

public abstract class AbstractUpdateMainInterfaceInteraction extends Interaction implements IUpdateMainInterfaceInteraction{
	private BackendInteraction backendInteraction;

	public BackendInteraction getBackendInteraction() {
		return backendInteraction;
	}

	public void setBackendInteraction(BackendInteraction backendInteraction) {
		this.backendInteraction = backendInteraction;
	}
}
