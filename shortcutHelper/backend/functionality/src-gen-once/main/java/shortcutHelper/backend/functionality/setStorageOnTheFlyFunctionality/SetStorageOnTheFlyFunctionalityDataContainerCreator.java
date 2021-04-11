package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class SetStorageOnTheFlyFunctionalityDataContainerCreator extends AbstractSetStorageOnTheFlyFunctionalityDataContainerCreator{
	
	public FunctionalityDataContainer getDataContainer()
	{
		return new SetStorageOnTheFlyFunctionalityDataContainer();
	}
};
