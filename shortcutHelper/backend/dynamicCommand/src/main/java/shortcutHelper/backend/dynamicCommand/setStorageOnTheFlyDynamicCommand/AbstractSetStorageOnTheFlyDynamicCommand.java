package shortcutHelper.backend.dynamicCommand.setStorageOnTheFlyDynamicCommand;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import shortcutHelper.backend.dynamicCommand.AbstractDynamicCommand;
import shortcutHelper.service.stringStorageService.IStringStorageService;

public abstract class AbstractSetStorageOnTheFlyDynamicCommand extends AbstractDynamicCommand
		implements ISetStorageOnTheFlyDynamicCommand {

	protected Logger logger = null;

	private IStringStorageService stringStorageService;

	public IStringStorageService getStringStorageService() {
		return stringStorageService;
	}

	public void setStringStorageService(IStringStorageService stringStorageService) {
		this.stringStorageService = stringStorageService;
	}

	protected Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getLogger(this.getClass());
		}
		return logger;
	}
}
