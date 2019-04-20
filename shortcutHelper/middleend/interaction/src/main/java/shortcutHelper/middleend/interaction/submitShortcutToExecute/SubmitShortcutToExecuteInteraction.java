package shortcutHelper.middleend.interaction.submitShortcutToExecute;

import shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction.SubmitShortcutBackendInteractionDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class SubmitShortcutToExecuteInteraction extends AbstractSubmitShortcutToExecuteInteraction {

	@Override
	public void execute(MainInterfaceViewBean bean) {
		System.out.println("Shortcut to execute: " + bean.getDataBean().getCalledShortcut());
		SubmitShortcutBackendInteractionDataContainer container = new SubmitShortcutBackendInteractionDataContainer();
		container.setShortcutToExecute(bean.getDataBean().getCalledShortcut());
		ShortcutHelperContext context = new ShortcutHelperContext();
		container.setContext(context);
		getSubmitShortcutBackenInteraction().execute(container);
		bean.getDataBean().setCalledShortcut("");
		if (context.getInfo() != null) {
			bean.getFunctionBean().setToastMessage(context.getInfo());
		} else if (context.getWarning() != null) {
			bean.getFunctionBean().setToastMessage(context.getInfo());
		} else if (context.getError() != null) {
			bean.getFunctionBean().setToastMessage(context.getError());
		} else {
			bean.getFunctionBean().setToastMessage("Shortcut executed !");
		}
		bean.getFunctionBean().setFocusOnShortcutTextBox(true);
	}

}
