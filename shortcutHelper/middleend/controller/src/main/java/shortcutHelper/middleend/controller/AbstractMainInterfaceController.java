package shortcutHelper.middleend.controller;

import java.util.Observer;

import shortcutHelper.frontend._interface.MainInterface;
import shortcutHelper.middleend.interaction.submitShortcutToExecute.ISubmitShortcutToExecuteInteraction;
import shortcutHelper.middleend.interaction.submitShortcutToExecute.SubmitShortcutToExecuteInteraction;
import shortcutHelper.middleend.interaction.updateMainInterfaceInteraction.IUpdateMainInterfaceInteraction;
import shortcutHelper.middleend.interaction.updateMainInterfaceInteraction.UpdateMainInterfaceInteraction;

public abstract class AbstractMainInterfaceController implements Observer, IMainInterfaceController{
	private MainInterface mainInterface;
	
	private ISubmitShortcutToExecuteInteraction submitShortcutToExecuteInteraction;
	
	private IUpdateMainInterfaceInteraction updateMainInterfaceInteractionInteraction;
	
	public AbstractMainInterfaceController()
	{
		setSubmitShortcutToExecuteInteraction(new SubmitShortcutToExecuteInteraction());
		setUpdateMainInterfaceInteractionInteraction(new UpdateMainInterfaceInteraction());
	}
	public MainInterface getMainInterface() {
		return mainInterface;
	}
	public void setMainInterface(MainInterface mainInterface) {
		this.mainInterface = mainInterface;
	}
	public ISubmitShortcutToExecuteInteraction getSubmitShortcutToExecuteInteraction() {
		return submitShortcutToExecuteInteraction;
	}
	public void setSubmitShortcutToExecuteInteraction(
			ISubmitShortcutToExecuteInteraction submitShortcutToExecuteInteraction) {
		this.submitShortcutToExecuteInteraction = submitShortcutToExecuteInteraction;
	}
	public IUpdateMainInterfaceInteraction getUpdateMainInterfaceInteractionInteraction() {
		return updateMainInterfaceInteractionInteraction;
	}
	public void setUpdateMainInterfaceInteractionInteraction(
			IUpdateMainInterfaceInteraction updateMainInterfaceInteractionInteraction) {
		this.updateMainInterfaceInteractionInteraction = updateMainInterfaceInteractionInteraction;
	}
	
}
