package shortcutHelper.middleend.interaction.submitShortcutToExecute;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class SubmitShortcutToExecute extends AbstractSubmitShortcutToExecute {

	@Override
	public void execute(MainInterfaceViewBean bean) {
		System.out.println("Shortcut to execute: " + bean.getDataBean().getCalledShortcut());
		bean.getDataBean().setCalledShortcut("");
	}

}
