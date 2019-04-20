package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.LogicDataContainer;

public class SetClipboardLogicDataContainer extends LogicDataContainer{
	private String clipboardValue;
	
	public String getClipboardValue()
	{
		return clipboardValue;
	}
	
	public void setClipboardValue(String clipboardValue){
		this.clipboardValue = clipboardValue;
	}
}
