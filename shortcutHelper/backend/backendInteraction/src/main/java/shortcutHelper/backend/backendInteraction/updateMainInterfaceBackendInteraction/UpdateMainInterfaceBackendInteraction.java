package shortcutHelper.backend.backendInteraction.updateMainInterfaceBackendInteraction;

import shortcutHelper.backend.backendInteraction.BackendInteraction;
import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;

public class UpdateMainInterfaceBackendInteraction extends AbstractUpdateMainInterfaceBackendInteraction{

	@Override
	public void execute(BackendInteractionDataContainer c) {
		this.getRefreshCommand().run(null);
	}
}
