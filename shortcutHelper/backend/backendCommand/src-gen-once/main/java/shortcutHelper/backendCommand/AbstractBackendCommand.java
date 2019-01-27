package shortcutHelper.backendCommand;

import shortcutHelper.backendCommon.ExecutableComponent;

public abstract class AbstractBackendCommand extends ExecutableComponent implements BackendCommand
{
	public final BackendCommandResult run(DataContainer container)
	{
		check(container);
		preRunImpl(container);
		BackendCommandResult result = runImpl(container);
		postRunImpl(container,result);
		return result;
	}
	
	public abstract BackendCommandResult runImpl(DataContainer container);
	public void check(DataContainer container)
	{
		// implement if required
	}
	public void preRunImpl(DataContainer container)
	{
		// implement if required
	}
	public void postRunImpl(DataContainer container, BackendCommandResult result){
		// implement if required
	}
}
