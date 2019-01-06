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
		MainInterfaceViewBean mainInterfaceViewBean = new MainInterfaceViewBean();
		this.setMainInteface(mainInteface);
		this.getUpdateMainInterfaceInteraction().execute(mainInterfaceViewBean);
		this.getMainInteface().updateView(mainInterfaceViewBean);
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
		MainInterfaceViewBean viewBean = (MainInterfaceViewBean) arg;
		getSubmitShortcutToExecute().execute(viewBean);
		updateView(viewBean);
	}
	
}
