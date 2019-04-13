package shortcutHelper.functionality.refreshFunctionality;

import shortcutHelper.functionality.DataContainer;

public class RefreshFunctionalityDataContainerCreator extends AbstractRefreshFunctionalityDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new RefreshFunctionalityDataContainer();
	}
};
