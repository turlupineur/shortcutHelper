package shortcutHelper.backendCommand.refreshCommand;

import shortcutHelper.backendCommand.DataContainer;

public class RefreshCommandDataContainerCreator extends AbstractRefreshCommandDataContainerCreator{
	
	public DataContainer getDataContainer()
	{
		return new RefreshCommandDataContainer();
	}
};
