package shortcutHelper.middleend.interaction.submitShortcutToExecute;

import shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction.ISubmitShortcutBackendInteraction;
import shortcutHelper.middleend.interaction.Interaction;

public abstract class AbstractSubmitShortcutToExecuteInteraction extends Interaction implements ISubmitShortcutToExecuteInteraction {
	private ISubmitShortcutBackendInteraction submitShortcutBackenInteraction;

	public ISubmitShortcutBackendInteraction getSubmitShortcutBackenInteraction() {
		return submitShortcutBackenInteraction;
	}

	public void setSubmitShortcutBackenInteraction(ISubmitShortcutBackendInteraction submitShortcutBackenInteraction) {
		this.submitShortcutBackenInteraction = submitShortcutBackenInteraction;
	}

}
