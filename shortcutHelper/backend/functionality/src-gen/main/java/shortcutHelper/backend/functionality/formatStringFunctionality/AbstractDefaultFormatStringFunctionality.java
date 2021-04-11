package shortcutHelper.backend.functionality.formatStringFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;

public abstract class AbstractDefaultFormatStringFunctionality extends AbstractFunctionality implements IDefaultFormatStringFunctionality
{
	private IDefaultGetClipboardLogic getClipboardLogic;
	private IDefaultSetClipboardLogic setClipboardLogic;
	
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
