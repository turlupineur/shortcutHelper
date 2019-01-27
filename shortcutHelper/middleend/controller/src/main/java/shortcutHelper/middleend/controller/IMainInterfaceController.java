package shortcutHelper.middleend.controller;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public interface IMainInterfaceController {
	public void showInterface();
	
	/**
	 * Updates the view with the current given viewbean.
	 * @param viewBean The new view bean representing the view.
	 */
	public void updateView(MainInterfaceViewBean viewBean);
	
	/**
	 * Updates the view by calling internal refresh.
	 */
	public void updateView();
}
