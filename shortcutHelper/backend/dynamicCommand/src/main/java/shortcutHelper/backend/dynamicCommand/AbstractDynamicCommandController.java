package shortcutHelper.backend.dynamicCommand;

import java.util.List;

import shortcutHelper.common.dynamicCommand.IDynamicCommandController;
import shortcutHelper.common.obervation.DynamicCommandObserver;
import shortcutHelper.helper.shortcutRegistrationHelper.IShortcutRegistrationHelper;

public abstract class AbstractDynamicCommandController implements IDynamicCommandController {
	private List<IDynamicCommand> dynamicCommands;
	private List<DynamicCommandObserver> dynamicCommandObservers;
	private IShortcutRegistrationHelper shortcutRegistrationHelper;

	public List<IDynamicCommand> getDynamicCommands() {
		return dynamicCommands;
	}

	public void setDynamicCommands(List<IDynamicCommand> dynamicCommands) {
		this.dynamicCommands = dynamicCommands;
	}

	public List<DynamicCommandObserver> getDynamicCommandObservers() {
		return dynamicCommandObservers;
	}

	public void setDynamicCommandObservers(List<DynamicCommandObserver> dynamicCommandObservers) {
		this.dynamicCommandObservers = dynamicCommandObservers;
	}

	public IShortcutRegistrationHelper getShortcutRegistrationHelper() {
		return shortcutRegistrationHelper;
	}

	public void setShortcutRegistrationHelper(IShortcutRegistrationHelper shortcutRegistrationHelper) {
		this.shortcutRegistrationHelper = shortcutRegistrationHelper;
	}

}
