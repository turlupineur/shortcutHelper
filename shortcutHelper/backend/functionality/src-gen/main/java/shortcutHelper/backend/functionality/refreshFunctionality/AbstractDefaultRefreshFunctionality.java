package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.helper.propertyHelper.IPropertyHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;

public abstract class AbstractDefaultRefreshFunctionality extends AbstractFunctionality implements IDefaultRefreshFunctionality
{
	private IPropertyHelper propertyHelper;
	private IShortcutHelper shortcutHelper;
	
	public void setPropertyHelper(IPropertyHelper propertyHelper)
	{
		this.propertyHelper = propertyHelper;
	}
	
	public IPropertyHelper getPropertyHelper()
	{
		return this.propertyHelper;
	}
	public void setShortcutHelper(IShortcutHelper shortcutHelper)
	{
		this.shortcutHelper = shortcutHelper;
	}
	
	public IShortcutHelper getShortcutHelper()
	{
		return this.shortcutHelper;
	}
}
