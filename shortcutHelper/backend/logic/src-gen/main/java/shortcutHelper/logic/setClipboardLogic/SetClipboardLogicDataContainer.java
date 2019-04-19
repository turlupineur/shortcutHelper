package shortcutHelper.logic.setClipboardLogic;

import shortcutHelper.logic.DataContainer;

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
