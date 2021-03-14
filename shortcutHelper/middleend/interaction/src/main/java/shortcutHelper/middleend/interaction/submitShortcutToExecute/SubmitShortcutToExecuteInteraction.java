package shortcutHelper.middleend.interaction.submitShortcutToExecute;

import shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction.SubmitShortcutBackendInteractionDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class SubmitShortcutToExecuteInteraction extends AbstractSubmitShortcutToExecuteInteraction {

	@Override
	public void execute(MainInterfaceViewBean bean) {
		SubmitShortcutBackendInteractionDataContainer container = new SubmitShortcutBackendInteractionDataContainer();
		container.setShortcutToExecute(bean.getDataBean().getCalledShortcut());
		ShortcutHelperContext context = new ShortcutHelperContext();
		container.setContext(context);
		getSubmitShortcutBackenInteraction().execute(container);
		bean.getDataBean().setCalledShortcut("");
		if (context.getError() != null) {
			bean.getFunctionBean().setToastMessage(context.getError());
		} else if (context.getWarning() != null) {
			bean.getFunctionBean().setToastMessage(context.getWarning());
		} else if (context.getInfo() != null) {
			bean.getFunctionBean().setToastMessage(context.getInfo());
		} else {
			bean.getFunctionBean().setToastMessage("Shortcut executed !");
		}
		bean.getFunctionBean().setFocusOnShortcutTextBox(true);
	}

}
