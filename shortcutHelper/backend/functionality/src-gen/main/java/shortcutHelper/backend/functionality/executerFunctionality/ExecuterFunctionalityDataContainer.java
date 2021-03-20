package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class ExecuterFunctionalityDataContainer extends FunctionalityDataContainer{
	private shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToExecute;
	
	public shortcutHelper.helper.shortcutFactoryHelper.IShortcut getShortcutToExecute()
	{
		return shortcutToExecute;
	}
	
	public void setShortcutToExecute(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToExecute){
		this.shortcutToExecute = shortcutToExecute;
	}
}
