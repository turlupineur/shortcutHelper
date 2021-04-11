package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class SelectQueryDatabaseFunctionalityDataContainerCreator extends AbstractSelectQueryDatabaseFunctionalityDataContainerCreator{
	
	public FunctionalityDataContainer getDataContainer()
	{
		return new SelectQueryDatabaseFunctionalityDataContainer();
	}
};
