package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import shortcutHelper.backend.functionality.FunctionalityIntegrationTesting;

public class CopyToClipboardFunctionalityIntegrationTest extends FunctionalityIntegrationTesting {
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void setGetClipboard() {
		String valueForClipboard = "salut";
		String otherValue = "bonjour";

		setClibpoard(otherValue);

		runCurrentFunctionality(valueForClipboard);

		assertEquals(valueForClipboard, getClipboard());
	}
}
