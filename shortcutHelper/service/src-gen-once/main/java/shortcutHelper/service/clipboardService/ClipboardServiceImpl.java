package shortcutHelper.service.clipboardService;

public class ClipboardServiceImpl extends AbstractClipboardService {

	public void setClipboard(String value) {
		this.getClipboardObject().setClipboard(value);
	}

	public String getClipboard() {
		return this.getClipboardObject().getClipboard();
	}

}