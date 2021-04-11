package shortcutHelper.backend.functionality.openUrlFunctionality;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import shortcutHelper.backend.functionality.FunctionalityTesting;

public class OpenUrlFunctionalityDataContainerDataExtractorTest extends FunctionalityTesting {
	@InjectMocks
	private OpenUrlFunctionalityDataContainerDataExtractor extractor;

	private OpenUrlFunctionalityDataContainer container = new OpenUrlFunctionalityDataContainer();

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void urlNormal() {
		String url = "www.google.com";
		String[] args = new String[1];
		args[0] = url;

		extractor.extractData(args, container);

		assertEquals(url, container.getUrl());
	}
}
