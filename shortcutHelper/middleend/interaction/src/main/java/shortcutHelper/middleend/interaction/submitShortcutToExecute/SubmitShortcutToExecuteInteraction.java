package shortcutHelper.middleend.interaction.submitShortcutToExecute;

import shortcutHelper.backend.backendInteraction.submitShortcutBackendInteraction.SubmitShortcutBackendInteractionDataContainer;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class SubmitShortcutToExecuteInteraction extends AbstractSubmitShortcutToExecuteInteraction {

	@Override
	public void execute(MainInterfaceViewBean bean) {
		System.out.println("Shortcut to execute: " + bean.getDataBean().getCalledShortcut());
		SubmitShortcutBackendInteractionDataContainer container = new SubmitShortcutBackendInteractionDataContainer();
		container.setShortcutToExecute(bean.getDataBean().getCalledShortcut());
		getSubmitShortcutBackenInteraction().execute(container);
		bean.getDataBean().setCalledShortcut("");
		bean.getFunctionBean().setToastMessage("Shortcut executed !");
		bean.getFunctionBean().setFocusOnShortcutTextBox(true);
	}

}
