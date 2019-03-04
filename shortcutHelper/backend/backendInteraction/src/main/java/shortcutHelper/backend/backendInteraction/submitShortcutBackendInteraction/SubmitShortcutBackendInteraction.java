package shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;

public class SubmitShortcutBackendInteraction extends AbstractSubmitShortcutBackendInteraction{

	@Override
	public void execute(BackendInteractionDataContainer c) {
		SubmitShortcutBackendInteractionDataContainer container = (SubmitShortcutBackendInteractionDataContainer) c;
		// TODO Auto-generated method stub
		System.out.println("BackendInteraction shortcut: " + container.getShortcutToExecute());
	}

}
