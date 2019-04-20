package shortcutHelper.backend.functionality.openUrlFunctionality;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.logging.ShortcutHelperLogging;

public class OpenUrlFunctionalityImpl extends AbstractOpenUrlFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		OpenUrlFunctionalityDataContainer container = (OpenUrlFunctionalityDataContainer) c;

		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(container.getUrl()));
			} catch (IOException | URISyntaxException e) {
				ShortcutHelperLogging.logError(e);
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("xdg-open " + container.getUrl());
			} catch (IOException e) {
				ShortcutHelperLogging.logError(e);
			}
		}

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
