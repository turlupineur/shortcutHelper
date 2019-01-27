package shortcutHelper.middleend.controller;

import java.util.Observable;

import shortcutHelper.frontend._interface.MainInterface;
import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class MainInterfaceController extends AbstractMainInterfaceController{
	private boolean controllerInitialized;
	
	public MainInterfaceController()
	{
		controllerInitialized = false;
	}
	
	private void init()
	{
		MainInterface mainInteface = new MainInterface(this);
		this.setMainInteface(mainInteface);
		updateView();
	}
	
	public void showInterface()
	{
		if(!controllerInitialized)
		{
			init();
			controllerInitialized = true;
		}
		getMainInteface().setVisible(true);
	}
	
	public void updateView(MainInterfaceViewBean viewBean)
	{
		this.getMainInteface().updateView(viewBean);
	}

	@Override
	public void update(Observable o, Object arg) {
		// Called upon execution of a shortcut.
		MainInterfaceViewBean viewBean = (MainInterfaceViewBean) arg;
		getSubmitShortcutToExecute().execute(viewBean);
		updateView(viewBean);
	}
	
	public void updateView()
	{
		MainInterfaceViewBean mainInterfaceViewBean = new MainInterfaceViewBean();
		this.getUpdateMainInterfaceInteraction().execute(mainInterfaceViewBean);
		updateView(mainInterfaceViewBean);
	}
	
}
