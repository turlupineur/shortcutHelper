package shortcutHelper.service.clipboardService;

import shortcutHelper.service.clipboardService.clipboard.ClipboardObject;

public abstract class AbstractClipboardService implements IClipboardService {
	private ClipboardObject clipboardObject;

	public ClipboardObject getClipboardObject() {
		return clipboardObject;
	}

	public void setClipboardObject(ClipboardObject clipboardObject) {
		this.clipboardObject = clipboardObject;
	}

}
