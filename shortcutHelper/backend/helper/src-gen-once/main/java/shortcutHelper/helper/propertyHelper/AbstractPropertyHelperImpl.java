package shortcutHelper.helper.propertyHelper;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractPropertyHelperImpl implements IPropertyHelper{
	private IPropertyLoaderService propertyLoaderService;

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}
	
}
