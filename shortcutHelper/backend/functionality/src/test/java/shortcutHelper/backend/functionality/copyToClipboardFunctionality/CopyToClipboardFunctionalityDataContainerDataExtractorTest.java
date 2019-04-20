package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import shortcutHelper.backend.functionality.FunctionalityTesting;

public class CopyToClipboardFunctionalityDataContainerDataExtractorTest extends FunctionalityTesting {
	@InjectMocks
	private CopyToClipboardFunctionalityDataContainerDataExtractor extractor;

	private CopyToClipboardFunctionalityDataContainer container = new CopyToClipboardFunctionalityDataContainer();

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void extractClipboard() {
		String value = "bonjour";
		String[] params = new String[1];
		params[0] = value;

		extractor.extractData(params, container);

		assertEquals(value, container.getClipboard());
	}
}
