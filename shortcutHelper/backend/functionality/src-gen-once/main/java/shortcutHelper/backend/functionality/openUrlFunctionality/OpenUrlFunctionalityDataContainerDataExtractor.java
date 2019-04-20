package shortcutHelper.backend.functionality.openUrlFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class OpenUrlFunctionalityDataContainerDataExtractor
		extends AbstractOpenUrlFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, DataContainer c) {
		OpenUrlFunctionalityDataContainer container = (OpenUrlFunctionalityDataContainer) c;
		container.setUrl(rawData[0]);
	}
}
