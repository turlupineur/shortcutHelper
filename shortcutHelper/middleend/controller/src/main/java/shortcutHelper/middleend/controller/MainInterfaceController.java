package shortcutHelper.middleend.controller;

import java.util.Observable;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class MainInterfaceController extends AbstractMainInterfaceController{
	 
	
	public MainInterfaceController()
	{
		
	}
	
	public void showInterface()
	{
		getMainInteface().setVisible(true);
	}
	
	public void updateView(MainInterfaceViewBean viewBean)
	{
		this.getMainInteface().updateView(viewBean);
	}

	@Override
	public void update(Observable o, Object arg) {
		MainInterfaceViewBean viewBean = (MainInterfaceViewBean) arg;
		getSubmitShortcutToExecute().execute(viewBean);
		updateView(viewBean);
	}
	
}
