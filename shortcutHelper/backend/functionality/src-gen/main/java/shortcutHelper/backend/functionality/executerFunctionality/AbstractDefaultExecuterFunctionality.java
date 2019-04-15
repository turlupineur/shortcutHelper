package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.helper.functionalityContainerHelper.IFunctionalityContainerHelper;
import shortcutHelper.util.beanUtil.IBeanUtil;
import shortcutHelper.helper.beanHelper.IBeanHelper;

public abstract class AbstractDefaultExecuterFunctionality extends AbstractFunctionality implements IDefaultExecuterFunctionality
{
	private IFunctionalityContainerHelper functionalityContainerHelper;
	private IBeanUtil beanUtil;
	private IBeanHelper beanHelper;
	
	public void setFunctionalityContainerHelper(IFunctionalityContainerHelper functionalityContainerHelper)
	{
		this.functionalityContainerHelper = functionalityContainerHelper;
	}
	
	public IFunctionalityContainerHelper getFunctionalityContainerHelper()
	{
		return this.functionalityContainerHelper;
	}
	public void setBeanUtil(IBeanUtil beanUtil)
	{
		this.beanUtil = beanUtil;
	}
	
	public IBeanUtil getBeanUtil()
	{
		return this.beanUtil;
	}
	public void setBeanHelper(IBeanHelper beanHelper)
	{
		this.beanHelper = beanHelper;
	}
	
	public IBeanHelper getBeanHelper()
	{
		return this.beanHelper;
	}
}
