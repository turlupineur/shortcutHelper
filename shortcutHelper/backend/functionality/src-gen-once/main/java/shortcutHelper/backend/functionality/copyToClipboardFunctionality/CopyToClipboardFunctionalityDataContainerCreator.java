package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class CopyToClipboardFunctionalityDataContainerCreator
		extends AbstractCopyToClipboardFunctionalityDataContainerCreator {

	public FunctionalityDataContainer getDataContainer() {
		return new CopyToClipboardFunctionalityDataContainer();
	}
};
