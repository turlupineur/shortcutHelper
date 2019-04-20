package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class CopyToClipboardFunctionalityDataContainer extends DataContainer{
	private String clipboard;
	
	public String getClipboard()
	{
		return clipboard;
	}
	
	public void setClipboard(String clipboard){
		this.clipboard = clipboard;
	}
}
