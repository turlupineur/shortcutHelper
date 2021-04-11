package shortcutHelper.helper.propertyHelper;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractPropertyHelper implements IPropertyHelper {
	private IPropertyLoaderService propertyLoaderService;

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}

}
