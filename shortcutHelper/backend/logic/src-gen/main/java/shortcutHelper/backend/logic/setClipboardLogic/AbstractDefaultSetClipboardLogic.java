package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.AbstractLogic;
import shortcutHelper.service.clipboardService.IClipboardService;

public abstract class AbstractDefaultSetClipboardLogic extends AbstractLogic implements IDefaultSetClipboardLogic
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
