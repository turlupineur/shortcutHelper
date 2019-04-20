package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.util.beanUtil.IBeanUtil;
import shortcutHelper.helper.beanHelper.IBeanHelper;

public abstract class AbstractDefaultCopyToClipboardFunctionality extends AbstractFunctionality implements IDefaultCopyToClipboardFunctionality
{
	private IDefaultSetClipboardLogic setClipboardLogic;
	private IBeanUtil beanUtil;
	private IBeanHelper beanHelper;
	
	public void setSetClipboardLogic(IDefaultSetClipboardLogic setClipboardLogic)
	{
		this.setClipboardLogic = setClipboardLogic;
	}
	
	public IDefaultSetClipboardLogic getSetClipboardLogic()
	{
		return this.setClipboardLogic;
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
