package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.logging.ShortcutHelperLogging;

public class RefreshFunctionalityImpl extends AbstractRefreshFunctionality {
	public FunctionalityResult runImpl(DataContainer container) {
		boolean exceptionOccured = false;
		try {
			getPropertyHelper().refresh();
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}
		try {
			getShortcutHelper().refresh();
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}

		if (!exceptionOccured) {
			container.getShortcutHelperContext().setInfo("Application refreshed");
		}

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
