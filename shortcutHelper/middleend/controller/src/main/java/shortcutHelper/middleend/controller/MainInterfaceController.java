package shortcutHelper.middleend.controller;

import java.util.Observable;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class MainInterfaceController extends AbstractMainInterfaceController {
	private boolean controllerInitialized;

	public MainInterfaceController() {
		controllerInitialized = false;
	}

	private void init() {
		updateView();
	}

	public void showInterface() {
		if (!controllerInitialized) {
			init();
			controllerInitialized = true;
		}
		getMainInterface().setVisible(true);
	}

	public void updateView(MainInterfaceViewBean viewBean) {
		this.getMainInterface().updateView(viewBean);
	}

	@Override
	public void update(Observable o, Object arg) {
		// Called upon execution of a shortcut.
		MainInterfaceViewBean viewBean = (MainInterfaceViewBean) arg;
		getSubmitShortcutToExecuteInteraction().execute(viewBean);
		updateView(viewBean);
	}

	public void updateView() {
		MainInterfaceViewBean mainInterfaceViewBean = new MainInterfaceViewBean();
		this.getUpdateMainInterfaceInteractionInteraction().execute(mainInterfaceViewBean);
		updateView(mainInterfaceViewBean);
	}

}
