package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.DataContainer;

public class CopyToClipboardFunctionalityDataContainerDataExtractor
		extends AbstractCopyToClipboardFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, DataContainer c) {
		CopyToClipboardFunctionalityDataContainer container = (CopyToClipboardFunctionalityDataContainer) c;
		container.setClipboard(rawData[0]);
	}
}
