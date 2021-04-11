package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;

public class SetStorageOnTheFlyFunctionalityDataContainerDataExtractor
		extends AbstractSetStorageOnTheFlyFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, FunctionalityDataContainer c) {
		SetStorageOnTheFlyFunctionalityDataContainer container = (SetStorageOnTheFlyFunctionalityDataContainer) c;
		if (rawData.length == 2) {
			container.setVName(rawData[0]);
			try {
				SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.valueOf(rawData[1]);
				container.setOperation(operation);
			} catch (IllegalArgumentException iae) {
				container.setOperation(null);
			}
		} else {
			try {
				SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.valueOf(rawData[0]);
				container.setOperation(operation);
			} catch (IllegalArgumentException iae) {
				container.setOperation(null);
			}
		}

	}
}
