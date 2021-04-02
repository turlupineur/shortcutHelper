package shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;
import shortcutHelper.backend.functionality.executerFunctionality.ExecuterFunctionalityDataContainer;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class SubmitShortcutBackendInteraction extends AbstractSubmitShortcutBackendInteraction {

	@Override
	public void execute(BackendInteractionDataContainer c) {
		SubmitShortcutBackendInteractionDataContainer container = (SubmitShortcutBackendInteractionDataContainer) c;

		String shortcutRaw = this.getShortcutHelper().getShortcut(container.getShortcutToExecute());
		IShortcut shortcut;
		if (shortcutRaw != null) {
			shortcut = this.getShortcutFactoryHelper().parseShortcut(shortcutRaw);
		} else {
			shortcut = null;
		}

		ExecuterFunctionalityDataContainer containerCmd = new ExecuterFunctionalityDataContainer();
		containerCmd.setShortcutHelperContext(container.getContext());
		containerCmd.setShortcutToExecute(shortcut);
		containerCmd.setORawShortcutToExecute(shortcutRaw);
		this.getExecuterFunctionality().run(containerCmd);
	}

}
