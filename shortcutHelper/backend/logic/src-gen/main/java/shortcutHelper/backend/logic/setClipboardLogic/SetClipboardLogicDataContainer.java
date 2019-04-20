package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.DataContainer;

public class SetClipboardLogicDataContainer extends DataContainer{
	private String clipboardValue;
	
	public String getClipboardValue()
	{
		return clipboardValue;
	}
	
	public void setClipboardValue(String clipboardValue){
		this.clipboardValue = clipboardValue;
	}
}
