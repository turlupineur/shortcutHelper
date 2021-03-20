package shortcutHelper.backend.functionality.openUrlFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class OpenUrlFunctionalityDataContainerDataExtractor
		extends AbstractOpenUrlFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, FunctionalityDataContainer c) {
		OpenUrlFunctionalityDataContainer container = (OpenUrlFunctionalityDataContainer) c;
		container.setUrl(rawData[0]);
	}
}
