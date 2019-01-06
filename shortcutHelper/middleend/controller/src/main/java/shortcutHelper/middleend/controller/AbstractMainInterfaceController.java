package shortcutHelper.middleend.controller;

import java.util.Observer;

import shortcutHelper.frontend._interface.MainInterface;
import shortcutHelper.middleend.interaction.submitShortcutToExecute.SubmitShortcutToExecuteInteraction;
import shortcutHelper.middleend.interaction.updateMainInterfaceInteraction.UpdateMainInterfaceInteraction;

public abstract class AbstractMainInterfaceController implements Observer, IMainInterfaceController{
	private MainInterface mainInteface;
	
	private SubmitShortcutToExecuteInteraction submitShortcutToExecute;
	
	private UpdateMainInterfaceInteraction updateMainInterfaceInteraction;
	
	public AbstractMainInterfaceController()
	{
		setSubmitShortcutToExecute(new SubmitShortcutToExecuteInteraction());
		setUpdateMainInterfaceInteraction(new UpdateMainInterfaceInteraction());
	}
	public MainInterface getMainInteface() {
		return mainInteface;
	}
	public void setMainInteface(MainInterface mainInteface) {
		this.mainInteface = mainInteface;
	}
	public SubmitShortcutToExecuteInteraction getSubmitShortcutToExecute() {
		return submitShortcutToExecute;
	}
	public void setSubmitShortcutToExecute(SubmitShortcutToExecuteInteraction submitShortcutToExecute) {
		this.submitShortcutToExecute = submitShortcutToExecute;
	}
	public UpdateMainInterfaceInteraction getUpdateMainInterfaceInteraction() {
		return updateMainInterfaceInteraction;
	}
	public void setUpdateMainInterfaceInteraction(UpdateMainInterfaceInteraction updateMainInterfaceInteraction) {
		this.updateMainInterfaceInteraction = updateMainInterfaceInteraction;
	}
}
