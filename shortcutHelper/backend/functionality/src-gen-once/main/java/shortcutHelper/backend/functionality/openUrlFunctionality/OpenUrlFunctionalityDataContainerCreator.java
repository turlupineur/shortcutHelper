package shortcutHelper.backend.functionality.openUrlFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class OpenUrlFunctionalityDataContainerCreator extends AbstractOpenUrlFunctionalityDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new OpenUrlFunctionalityDataContainer();
	}
};
