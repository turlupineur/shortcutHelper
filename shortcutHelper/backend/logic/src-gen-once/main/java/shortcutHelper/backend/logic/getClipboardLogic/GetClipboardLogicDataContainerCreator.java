package shortcutHelper.backend.logic.getClipboardLogic;

import shortcutHelper.backend.logic.DataContainer;

public class GetClipboardLogicDataContainerCreator extends AbstractGetClipboardLogicDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new GetClipboardLogicDataContainer();
	}
};
