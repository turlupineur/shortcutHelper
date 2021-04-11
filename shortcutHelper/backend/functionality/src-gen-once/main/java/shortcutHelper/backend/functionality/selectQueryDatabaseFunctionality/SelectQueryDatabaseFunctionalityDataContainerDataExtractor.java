package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class SelectQueryDatabaseFunctionalityDataContainerDataExtractor
		extends AbstractSelectQueryDatabaseFunctionalityDataContainerDataExtractor {
	public void extractData(String[] rawData, FunctionalityDataContainer c) {
		SelectQueryDatabaseFunctionalityDataContainer container = (SelectQueryDatabaseFunctionalityDataContainer) c;
		container.setDatabaseConnectionName(rawData[0]);
		container.setQuery(rawData[1]);
	}
}
