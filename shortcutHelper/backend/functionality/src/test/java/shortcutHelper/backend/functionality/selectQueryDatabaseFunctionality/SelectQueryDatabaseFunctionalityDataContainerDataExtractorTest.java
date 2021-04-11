package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.InjectMocks;

import shortcutHelper.backend.functionality.FunctionalityTesting;

public class SelectQueryDatabaseFunctionalityDataContainerDataExtractorTest extends FunctionalityTesting {
	@InjectMocks
	private SelectQueryDatabaseFunctionalityDataContainerDataExtractor extractor;

	@Test
	public void paramExtraction() {
		String[] rawData = { "connectionName", "query" };

		SelectQueryDatabaseFunctionalityDataContainer container = new SelectQueryDatabaseFunctionalityDataContainer();
		extractor.extractData(rawData, container);

		assertThat(container.getDatabaseConnectionName(), is("connectionName"));
		assertThat(container.getQuery(), is("query"));
	}
}
