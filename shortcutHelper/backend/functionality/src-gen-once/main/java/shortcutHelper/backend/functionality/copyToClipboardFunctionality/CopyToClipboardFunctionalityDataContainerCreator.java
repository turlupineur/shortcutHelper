package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class CopyToClipboardFunctionalityDataContainerCreator extends AbstractCopyToClipboardFunctionalityDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new CopyToClipboardFunctionalityDataContainer();
	}
};
