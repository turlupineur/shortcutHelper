package shortcutHelper.logic.setClipboardLogic;

import shortcutHelper.logic.DataContainer;

public class SetClipboardLogicDataContainerCreator extends AbstractSetClipboardLogicDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new SetClipboardLogicDataContainer();
	}
};
