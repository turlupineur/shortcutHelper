package shortcutHelper.backend.functionality.refreshFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.logging.ShortcutHelperLogging;

public class RefreshFunctionalityImpl extends AbstractRefreshFunctionality {
	public FunctionalityResult runImpl(FunctionalityDataContainer container) {
		boolean exceptionOccured = false;
		try {
			getPropertyHelper().refresh();
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}

		try {
			getVariableHelper().refresh();
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing variables: " + t.getMessage());
			exceptionOccured = true;
		}

		try {
			getShortcutHelper().refresh();
		} catch (Throwable t) {
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}

		try {
			getDatabaseInformationHelper().refresh();
		} catch (Throwable t) {
			container.getShortcutHelperContext()
					.setError("Error while refreshing database information: " + t.getMessage());
			ShortcutHelperLogging.logError(t);
			exceptionOccured = true;
		}

		try {
			getApplicationPropertyHelper().refresh();
		} catch (Throwable t) {
			container.getShortcutHelperContext()
					.setError("Error while refreshing application properties: " + t.getMessage());
			ShortcutHelperLogging.logError(t);
			exceptionOccured = true;
		}

		getDynamicCommandController().executeDynamicCommands();

		if (!exceptionOccured) {
			container.getShortcutHelperContext().setInfo("Application refreshed");
		}

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
