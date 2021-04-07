package shortcutHelper.backend.dynamicCommand.setStorageOnTheFlyDynamicCommand;

import shortcutHelper.backend.dynamicCommand.AbstractDynamicCommand;
import shortcutHelper.service.stringStorageService.IStringStorageService;

public abstract class AbstractSetStorageOnTheFlyDynamicCommand extends AbstractDynamicCommand
		implements ISetStorageOnTheFlyDynamicCommand {
	private IStringStorageService stringStorageService;

	public IStringStorageService getStringStorageService() {
		return stringStorageService;
	}

	public void setStringStorageService(IStringStorageService stringStorageService) {
		this.stringStorageService = stringStorageService;
	}
}
