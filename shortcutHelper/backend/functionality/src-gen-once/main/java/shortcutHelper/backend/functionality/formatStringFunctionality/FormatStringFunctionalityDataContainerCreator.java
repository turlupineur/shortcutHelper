package shortcutHelper.backend.functionality.formatStringFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class FormatStringFunctionalityDataContainerCreator
		extends AbstractFormatStringFunctionalityDataContainerCreator {

	public FunctionalityDataContainer getDataContainer() {
		FormatStringFunctionalityDataContainer container = new FormatStringFunctionalityDataContainer();
		container.setDReverseFormat(true);
		return container;
	}
};
