package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class CopyToClipboardFunctionalityDataContainerDataExtractor
		extends AbstractCopyToClipboardFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, FunctionalityDataContainer c) {
		CopyToClipboardFunctionalityDataContainer container = (CopyToClipboardFunctionalityDataContainer) c;
		container.setClipboard(rawData[0]);
	}
}
