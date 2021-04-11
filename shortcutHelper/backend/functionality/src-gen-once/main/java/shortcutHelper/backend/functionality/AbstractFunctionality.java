package shortcutHelper.backend.functionality;

import shortcutHelper.backendCommon.ExecutableComponent;
import shortcutHelper.logging.ShortcutHelperLogging;

public abstract class AbstractFunctionality extends ExecutableComponent implements Functionality {
	public final FunctionalityResult run(FunctionalityDataContainer container) {
		check(container);
		preRunImpl(container);
		try {
			FunctionalityResult result = runImpl(container);
			postRunImpl(container, result);
			return result;
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
		}
		return null;
	}

	public abstract FunctionalityResult runImpl(FunctionalityDataContainer container);

	public void check(FunctionalityDataContainer container) {
		// implement if required
	}

	public void preRunImpl(FunctionalityDataContainer container) {
		// implement if required
	}

	public void postRunImpl(FunctionalityDataContainer container, FunctionalityResult result) {
		// implement if required
	}
}
