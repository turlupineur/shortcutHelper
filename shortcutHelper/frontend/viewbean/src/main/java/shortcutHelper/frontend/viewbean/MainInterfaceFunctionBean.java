package shortcutHelper.frontend.viewbean;

public class MainInterfaceFunctionBean {
	private String toastMessage;
	private boolean focusOnShortcutTextBox;
	
	public MainInterfaceFunctionBean()
	{
		toastMessage = "";
		focusOnShortcutTextBox = false;
	}

	public void setToastMessage(String toastMessage) {
		this.toastMessage = toastMessage;
	}

	public String getToastMessage() {
		return toastMessage;
	}
	
	public boolean isFocusOnShortcutTextBox() {
		return focusOnShortcutTextBox;
	}

	public void setFocusOnShortcutTextBox(boolean focusOnShortcutTextBox) {
		this.focusOnShortcutTextBox = focusOnShortcutTextBox;
	}
}
