package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.DataContainer;

public class SetClipboardLogicDataContainerCreator extends AbstractSetClipboardLogicDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new SetClipboardLogicDataContainer();
	}
};
