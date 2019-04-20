package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class ExecuterFunctionalityDataContainerCreator extends AbstractExecuterFunctionalityDataContainerCreator {

	public FunctionalityDataContainer getDataContainer() {
		return new ExecuterFunctionalityDataContainer();
	}
};
