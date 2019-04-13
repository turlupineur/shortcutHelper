package shortcutHelper.backend.functionality;

import shortcutHelper.backendCommon.ExecutableComponent;

public abstract class AbstractFunctionality extends ExecutableComponent implements Functionality
{
	public final FunctionalityResult run(DataContainer container)
	{
		check(container);
		preRunImpl(container);
		FunctionalityResult result = runImpl(container);
		postRunImpl(container,result);
		return result;
	}
	
	public abstract FunctionalityResult runImpl(DataContainer container);
	public void check(DataContainer container)
	{
		// implement if required
	}
	public void preRunImpl(DataContainer container)
	{
		// implement if required
	}
	public void postRunImpl(DataContainer container, FunctionalityResult result){
		// implement if required
	}
}
