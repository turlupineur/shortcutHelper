package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class ExecuterFunctionalityDataContainerCreator extends AbstractExecuterFunctionalityDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new ExecuterFunctionalityDataContainer();
	}
};
