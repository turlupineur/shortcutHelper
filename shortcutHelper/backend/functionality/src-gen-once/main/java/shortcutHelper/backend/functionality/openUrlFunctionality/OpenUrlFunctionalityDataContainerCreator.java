package shortcutHelper.backend.functionality.openUrlFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class OpenUrlFunctionalityDataContainerCreator extends AbstractOpenUrlFunctionalityDataContainerCreator {

	public FunctionalityDataContainer getDataContainer() {
		return new OpenUrlFunctionalityDataContainer();
	}
};
