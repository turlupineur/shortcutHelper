package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class SetStorageOnTheFlyFunctionalityDataContainer extends FunctionalityDataContainer{
	private String vName;
	private shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation operation;
	
	public String getVName()
	{
		return vName;
	}
	
	public void setVName(String vName){
		this.vName = vName;
	}
	public shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation getOperation()
	{
		return operation;
	}
	
	public void setOperation(shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation operation){
		this.operation = operation;
	}
}
