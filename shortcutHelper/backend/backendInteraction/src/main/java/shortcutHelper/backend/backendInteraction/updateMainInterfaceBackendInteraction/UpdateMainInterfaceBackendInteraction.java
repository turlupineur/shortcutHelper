package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;
import shortcutHelper.backendCommand.refreshCommand.RefreshCommandDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;

public class UpdateMainInterfaceBackendInteraction extends AbstractUpdateMainInterfaceBackendInteraction{

	@Override
	public void execute(BackendInteractionDataContainer c) {
		RefreshCommandDataContainer container = new RefreshCommandDataContainer();
		ShortcutHelperContext context = new ShortcutHelperContext();
		container.setShortcutHelperContext(context);
		this.getRefreshCommand().run(container);
	}
}
