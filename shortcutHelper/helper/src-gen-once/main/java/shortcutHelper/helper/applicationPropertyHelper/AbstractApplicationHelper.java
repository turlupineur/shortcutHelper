package shortcutHelper.helper.applicationPropertyHelper;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractApplicationHelper implements IApplicationPropertyHelper {
	private IPropertyLoaderService propertyLoaderService;

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}
}
