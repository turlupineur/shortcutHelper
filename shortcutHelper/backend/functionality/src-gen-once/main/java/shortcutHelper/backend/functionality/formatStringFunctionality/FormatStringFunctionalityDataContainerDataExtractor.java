package shortcutHelper.backend.functionality.formatStringFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class FormatStringFunctionalityDataContainerDataExtractor
		extends AbstractFormatStringFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, FunctionalityDataContainer c) {
		FormatStringFunctionalityDataContainer container = (FormatStringFunctionalityDataContainer) c;
		if (rawData.length < 2) {
			throw new IllegalArgumentException("This commands takes at least 2 parameters. Please see documentation.");
		}
		container.setOriginalFormat(rawData[0]);
		container.setTransformationToTargetFormat(rawData[1]);
		if (rawData.length > 2) {
			container.setOTargetFormat(rawData[2]);
			container.setOTransformationToOriginalFormat(rawData[3]);
		}
		if (rawData.length > 4) {
			container.setDReverseFormat(Boolean.valueOf(rawData[4]));
		}
	}
}
