package shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;
import shortcutHelper.backend.functionality.executerFunctionality.ExecuterFunctionalityDataContainer;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;
import shortcutHelper.logging.ShortcutHelperLogging;

public class SubmitShortcutBackendInteraction extends AbstractSubmitShortcutBackendInteraction {

	@Override
	public void execute(BackendInteractionDataContainer c) {
		SubmitShortcutBackendInteractionDataContainer container = (SubmitShortcutBackendInteractionDataContainer) c;
		// TODO Auto-generated method stub
		ShortcutHelperLogging.logInfo("Executing shortcut: " + container.getShortcutToExecute());

		String shortcutRaw = this.getShortcutHelper().getShortcut(container.getShortcutToExecute());
		IShortcut shortcut = this.getShortcutFactoryHelper().parseShortcut(shortcutRaw);

		ExecuterFunctionalityDataContainer containerCmd = new ExecuterFunctionalityDataContainer();
		containerCmd.setShortcutHelperContext(container.getContext());
		containerCmd.setShortcutToExecute(shortcut);
		this.getExecuterFunctionality().run(containerCmd);
	}

}
