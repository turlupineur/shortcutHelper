package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.service.stringStorageService.IStringStorageService;
import shortcutHelper.helper.applicationPropertyHelper.IApplicationPropertyHelper;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;
import shortcutHelper.helper.shortcutRegistrationHelper.IShortcutRegistrationHelper;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;

public abstract class AbstractDefaultSetStorageOnTheFlyFunctionality extends AbstractFunctionality implements IDefaultSetStorageOnTheFlyFunctionality
{
	private IStringStorageService StringStorageService;
	private IApplicationPropertyHelper applicationPropertyHelper;
	private IShortcutHelper shortcutHelper;
	private IShortcutFactoryHelper shortcutFactoryHelper;
	private IShortcutRegistrationHelper shortcutRegistrationHelper;
	private IDefaultGetClipboardLogic getClipboardLogic;
	private IDefaultSetClipboardLogic setClipboardLogic;
	
	public void setStringStorageService(IStringStorageService StringStorageService)
	{
		this.StringStorageService = StringStorageService;
	}
	
	public IStringStorageService getStringStorageService()
	{
		return this.StringStorageService;
	}
	public void setApplicationPropertyHelper(IApplicationPropertyHelper applicationPropertyHelper)
	{
		this.applicationPropertyHelper = applicationPropertyHelper;
	}
	
	public IApplicationPropertyHelper getApplicationPropertyHelper()
	{
		return this.applicationPropertyHelper;
	}
	public void setShortcutHelper(IShortcutHelper shortcutHelper)
	{
		this.shortcutHelper = shortcutHelper;
	}
	
	public IShortcutHelper getShortcutHelper()
	{
		return this.shortcutHelper;
	}
	public void setShortcutFactoryHelper(IShortcutFactoryHelper shortcutFactoryHelper)
	{
		this.shortcutFactoryHelper = shortcutFactoryHelper;
	}
	
	public IShortcutFactoryHelper getShortcutFactoryHelper()
	{
		return this.shortcutFactoryHelper;
	}
	public void setShortcutRegistrationHelper(IShortcutRegistrationHelper shortcutRegistrationHelper)
	{
		this.shortcutRegistrationHelper = shortcutRegistrationHelper;
	}
	
	public IShortcutRegistrationHelper getShortcutRegistrationHelper()
	{
		return this.shortcutRegistrationHelper;
	}
	public void setGetClipboardLogic(IDefaultGetClipboardLogic getClipboardLogic)
	{
		this.getClipboardLogic = getClipboardLogic;
	}
	
	public IDefaultGetClipboardLogic getGetClipboardLogic()
	{
		return this.getClipboardLogic;
	}
	public void setSetClipboardLogic(IDefaultSetClipboardLogic setClipboardLogic)
	{
		this.setClipboardLogic = setClipboardLogic;
	}
	
	public IDefaultSetClipboardLogic getSetClipboardLogic()
	{
		return this.setClipboardLogic;
	}
}
