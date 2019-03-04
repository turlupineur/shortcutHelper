package shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;

public class SubmitShortcutBackendInteractionDataContainer extends BackendInteractionDataContainer {
	private String shortcutToExecute;

	public String getShortcutToExecute() {
		return shortcutToExecute;
	}

	public void setShortcutToExecute(String shortcutToExecute) {
		this.shortcutToExecute = shortcutToExecute;
	}
}
