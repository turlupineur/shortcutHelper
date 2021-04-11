package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import shortcutHelper.backend.functionality.FunctionalityDataContainer;

public class SelectQueryDatabaseFunctionalityDataContainer extends FunctionalityDataContainer{
	private String databaseConnectionName;
	private String query;
	
	public String getDatabaseConnectionName()
	{
		return databaseConnectionName;
	}
	
	public void setDatabaseConnectionName(String databaseConnectionName){
		this.databaseConnectionName = databaseConnectionName;
	}
	public String getQuery()
	{
		return query;
	}
	
	public void setQuery(String query){
		this.query = query;
	}
}
