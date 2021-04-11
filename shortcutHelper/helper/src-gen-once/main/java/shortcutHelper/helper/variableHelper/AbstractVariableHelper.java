package shortcutHelper.helper.variableHelper;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractVariableHelper implements IVariableHelper {
	private IPropertyLoaderService propertyLoaderService;

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}
}
