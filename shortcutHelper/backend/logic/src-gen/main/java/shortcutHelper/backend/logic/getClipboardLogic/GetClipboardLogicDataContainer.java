package shortcutHelper.backend.logic.getClipboardLogic;

import shortcutHelper.backend.logic.DataContainer;

public class GetClipboardLogicDataContainer extends DataContainer{
	private boolean dTrimm;
	
	public boolean getDTrimm()
	{
		return dTrimm;
	}
	
	public void setDTrimm(boolean dTrimm){
		this.dTrimm = dTrimm;
	}
}
