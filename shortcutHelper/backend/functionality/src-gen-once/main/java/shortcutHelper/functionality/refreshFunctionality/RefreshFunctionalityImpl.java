package shortcutHelper.functionality.refreshFunctionality;

import shortcutHelper.functionality.ConcreteFunctionalityResult;
import shortcutHelper.functionality.DataContainer;
import shortcutHelper.functionality.FunctionalityResult;
import shortcutHelper.logging.ShortcutHelperLogging;

public class RefreshFunctionalityImpl extends AbstractRefreshFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		RefreshFunctionalityDataContainer container = (RefreshFunctionalityDataContainer) c;
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
