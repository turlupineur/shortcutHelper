package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class RefreshFunctionalityDataContainerCreator extends AbstractRefreshFunctionalityDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new RefreshFunctionalityDataContainer();
	}
};
