package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.helper.propertyHelper.IPropertyHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;
import shortcutHelper.helper.variableHelper.IVariableHelper;
import shortcutHelper.helper.databaseInformationHelper.IDatabaseInformationHelper;
import shortcutHelper.helper.applicationPropertyHelper.IApplicationPropertyHelper;

public abstract class AbstractDefaultRefreshFunctionality extends AbstractFunctionality implements IDefaultRefreshFunctionality
{
	private IPropertyHelper propertyHelper;
	private IShortcutHelper shortcutHelper;
	private IVariableHelper variableHelper;
	private IDatabaseInformationHelper databaseInformationHelper;
	private IApplicationPropertyHelper applicationPropertyHelper;
	
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
	public void setVariableHelper(IVariableHelper variableHelper)
	{
		this.variableHelper = variableHelper;
	}
	
	public IVariableHelper getVariableHelper()
	{
		return this.variableHelper;
	}
	public void setDatabaseInformationHelper(IDatabaseInformationHelper databaseInformationHelper)
	{
		this.databaseInformationHelper = databaseInformationHelper;
	}
	
	public IDatabaseInformationHelper getDatabaseInformationHelper()
	{
		return this.databaseInformationHelper;
	}
	public void setApplicationPropertyHelper(IApplicationPropertyHelper applicationPropertyHelper)
	{
		this.applicationPropertyHelper = applicationPropertyHelper;
	}
	
	public IApplicationPropertyHelper getApplicationPropertyHelper()
	{
		return this.applicationPropertyHelper;
	}
}
