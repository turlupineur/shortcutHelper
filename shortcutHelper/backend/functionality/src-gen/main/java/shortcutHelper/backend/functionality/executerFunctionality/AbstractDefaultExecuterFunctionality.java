package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;
import shortcutHelper.helper.beanHelper.IBeanHelper;
import shortcutHelper.helper.functionalityContainerHelper.IFunctionalityContainerHelper;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;

public abstract class AbstractDefaultExecuterFunctionality extends AbstractFunctionality implements IDefaultExecuterFunctionality
{
	private IDefaultGetClipboardLogic getClipboardLogic;
	private IBeanHelper beanHelper;
	private IFunctionalityContainerHelper functionalityContainerHelper;
	private IShortcutFactoryHelper shortcutFactoryHelper;
	
	public void setGetClipboardLogic(IDefaultGetClipboardLogic getClipboardLogic)
	{
		this.getClipboardLogic = getClipboardLogic;
	}
	
	public IDefaultGetClipboardLogic getGetClipboardLogic()
	{
		return this.getClipboardLogic;
	}
	public void setBeanHelper(IBeanHelper beanHelper)
	{
		this.beanHelper = beanHelper;
	}
	
	public IBeanHelper getBeanHelper()
	{
		return this.beanHelper;
	}
	public void setFunctionalityContainerHelper(IFunctionalityContainerHelper functionalityContainerHelper)
	{
		this.functionalityContainerHelper = functionalityContainerHelper;
	}
	
	public IFunctionalityContainerHelper getFunctionalityContainerHelper()
	{
		return this.functionalityContainerHelper;
	}
	public void setShortcutFactoryHelper(IShortcutFactoryHelper shortcutFactoryHelper)
	{
		this.shortcutFactoryHelper = shortcutFactoryHelper;
	}
	
	public IShortcutFactoryHelper getShortcutFactoryHelper()
	{
		return this.shortcutFactoryHelper;
	}
}
