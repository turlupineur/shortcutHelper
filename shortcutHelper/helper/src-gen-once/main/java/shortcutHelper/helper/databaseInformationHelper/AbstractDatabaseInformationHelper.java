package shortcutHelper.helper.databaseInformationHelper;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractDatabaseInformationHelper implements IDatabaseInformationHelper {
	private IPropertyLoaderService propertyLoaderService;

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}
}
