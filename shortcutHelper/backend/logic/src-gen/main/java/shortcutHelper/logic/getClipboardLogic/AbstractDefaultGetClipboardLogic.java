package shortcutHelper.logic.getClipboardLogic;

import shortcutHelper.logic.AbstractLogic;
import shortcutHelper.service.clipboardService.IClipboardService;

public abstract class AbstractDefaultGetClipboardLogic extends AbstractLogic implements IDefaultGetClipboardLogic
{
	private IClipboardService clipboardService;
	
	public void setClipboardService(IClipboardService clipboardService)
	{
		this.clipboardService = clipboardService;
	}
	
	public IClipboardService getClipboardService()
	{
		return this.clipboardService;
	}
}
