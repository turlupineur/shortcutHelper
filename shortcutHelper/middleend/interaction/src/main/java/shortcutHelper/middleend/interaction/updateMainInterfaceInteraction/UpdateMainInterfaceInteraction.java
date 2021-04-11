package shortcutHelper.middleend.interaction.updateMainInterfaceInteraction;

import java.util.ArrayList;
import java.util.List;

import shortcutHelper.backend.backendInteraction.BackendInteractionDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class UpdateMainInterfaceInteraction extends AbstractUpdateMainInterfaceInteraction {

	@Override
	public void execute(MainInterfaceViewBean bean) {
		BackendInteractionDataContainer backendInteractionDataContainer = new BackendInteractionDataContainer();
		getUpdateMainInterfaceBackendInteraction().execute(backendInteractionDataContainer);
		List<String> listShortcutsToShow = new ArrayList<String>();
		listShortcutsToShow.addAll(this.getShortcutHelper().getListShortcuts().keySet());
		bean.getFunctionBean().getToastMessage();
		bean.getDataBean().setShortcuts(listShortcutsToShow);

		setToastMessageAfterUpdate(bean, backendInteractionDataContainer);
	}

	private void setToastMessageAfterUpdate(MainInterfaceViewBean bean,
			BackendInteractionDataContainer backendInteractionDataContainer) {
		ShortcutHelperContext context = backendInteractionDataContainer.getContext();
		if (context.getError() != null) {
			bean.getFunctionBean().setToastMessage(context.getError());
		} else if (context.getWarning() != null) {
			bean.getFunctionBean().setToastMessage(context.getWarning());
		} else if (context.getInfo() != null) {
			bean.getFunctionBean().setToastMessage(context.getInfo());
		} else {
			bean.getFunctionBean().setToastMessage("Application refreshed !");
		}
	}

}
