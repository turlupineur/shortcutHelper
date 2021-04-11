package shortcutHelper.service.clipboardService;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.service.ServiceIntegrationTesting;
import shortcutHelper.service.clipboardService.clipboard.ClipboardObject;

public class ClipboardServiceIntegrationTest extends ServiceIntegrationTesting {
	@Autowired
	private AbstractClipboardService clipboardService;

	@Resource(name = IClipboardService.BEAN_ID_INTERN_CLIPBOARD)
	private ClipboardObject internClipboard;

	@Before
	public void setUp() {
		super.setUp();
		// intern clipboard to prevent errors.
		clipboardService.setClipboardObject(internClipboard);
	}

	@Test
	public void setAndGet() {
		String value = "value";
		clipboardService.setClipboard(value);
		assertEquals(value, clipboardService.getClipboard());
	}
}
