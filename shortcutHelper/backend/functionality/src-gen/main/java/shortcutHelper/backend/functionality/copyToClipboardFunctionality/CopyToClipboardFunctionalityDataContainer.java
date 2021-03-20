package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class CopyToClipboardFunctionalityDataContainer extends FunctionalityDataContainer{
	private String clipboard;
	
	public String getClipboard()
	{
		return clipboard;
	}
	
	public void setClipboard(String clipboard){
		this.clipboard = clipboard;
	}
}
