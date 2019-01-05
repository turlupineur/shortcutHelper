package shortcutHelper.middleend.controller;

import java.util.Observer;

import shortcutHelper.frontend._interface.MainInterface;
import shortcutHelper.middleend.interaction.submitShortcutToExecute.SubmitShortcutToExecute;

public abstract class AbstractMainInterfaceController implements Observer, IMainInterfaceController{
	private MainInterface mainInteface;
	
	private SubmitShortcutToExecute submitShortcutToExecute;
	
	public AbstractMainInterfaceController()
	{
		mainInteface = new MainInterface(this);
		setSubmitShortcutToExecute(new SubmitShortcutToExecute());
	}
	public MainInterface getMainInteface() {
		return mainInteface;
	}
	public void setMainInteface(MainInterface mainInteface) {
		this.mainInteface = mainInteface;
	}
	public SubmitShortcutToExecute getSubmitShortcutToExecute() {
		return submitShortcutToExecute;
	}
	public void setSubmitShortcutToExecute(SubmitShortcutToExecute submitShortcutToExecute) {
		this.submitShortcutToExecute = submitShortcutToExecute;
	}
	
	
	
}
