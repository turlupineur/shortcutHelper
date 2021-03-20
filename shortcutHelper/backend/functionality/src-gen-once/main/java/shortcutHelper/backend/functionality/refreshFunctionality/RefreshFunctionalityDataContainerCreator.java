package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class RefreshFunctionalityDataContainerCreator extends AbstractRefreshFunctionalityDataContainerCreator {

	public FunctionalityDataContainer getDataContainer() {
		return new RefreshFunctionalityDataContainer();
	}
};
