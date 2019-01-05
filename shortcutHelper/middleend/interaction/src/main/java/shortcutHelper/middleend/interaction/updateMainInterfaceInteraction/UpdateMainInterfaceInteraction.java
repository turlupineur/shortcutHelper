package shortcutHelper.middleend.interaction.updateMainInterfaceInteraction;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class UpdateMainInterfaceInteraction extends AbstractUpdateMainInterfaceInteraction{

	@Override
	public void execute(MainInterfaceViewBean bean) {
		getBackendInteraction().execute();
	}

}
