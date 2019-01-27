package shortcutHelper.backendCommand.refreshCommand;

import shortcutHelper.backendCommand.BackendCommandResult;
import shortcutHelper.backendCommand.ConcreteBackendCommandResult;
import shortcutHelper.backendCommand.DataContainer;
import shortcutHelper.logging.ShortcutHelperLogging;

public class RefreshCommandImpl extends AbstractRefreshCommand
{
	public BackendCommandResult runImpl(DataContainer c)
	{
		RefreshCommandDataContainer container = (RefreshCommandDataContainer ) c;
		boolean exceptionOccured = false;
		try {			
			getPropertyHelper().refresh();
		}catch(Throwable t)
		{
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}
		try {	
			getShortcutHelper().refresh();
		}catch(Throwable t)
		{
			ShortcutHelperLogging.logError(t);
			container.getShortcutHelperContext().setError("Error while refreshing properties: " + t.getMessage());
			exceptionOccured = true;
		}
		
		if(!exceptionOccured)
		{
			container.getShortcutHelperContext().setInfo("Application refreshed");
		}
		
		return ConcreteBackendCommandResult.RESULT_NULL;
	}
} 
