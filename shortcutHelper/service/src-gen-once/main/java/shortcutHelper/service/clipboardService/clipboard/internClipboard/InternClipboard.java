package shortcutHelper.service.clipboardService.clipboard.internClipboard;

import shortcutHelper.service.clipboardService.clipboard.ClipboardObject;

public class InternClipboard implements ClipboardObject {
	private String clipboard;

	public InternClipboard() {
		clipboard = null;
	}

	@Override
	public void setClipboard(String value) {
		this.clipboard = value;
	}

	@Override
	public String getClipboard() {
		return clipboard;
	}

}
