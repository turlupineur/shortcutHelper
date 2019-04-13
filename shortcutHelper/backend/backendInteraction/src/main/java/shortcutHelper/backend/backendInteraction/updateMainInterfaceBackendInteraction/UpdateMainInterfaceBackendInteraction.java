package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;
import shortcutHelper.backend.functionality.refreshFunctionality.RefreshFunctionalityDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;

public class UpdateMainInterfaceBackendInteraction extends AbstractUpdateMainInterfaceBackendInteraction {

	@Override
	public void execute(BackendInteractionDataContainer c) {
		RefreshFunctionalityDataContainer container = new RefreshFunctionalityDataContainer();
		ShortcutHelperContext context = new ShortcutHelperContext();
		container.setShortcutHelperContext(context);
		this.getRefreshFunctionality().run(container);
	}
}
