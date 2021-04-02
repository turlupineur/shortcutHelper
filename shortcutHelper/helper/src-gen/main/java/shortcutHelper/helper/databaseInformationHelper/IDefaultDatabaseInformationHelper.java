package shortcutHelper.helper.databaseInformationHelper;

import shortcutHelper.helper.Helper;

public interface IDefaultDatabaseInformationHelper extends Helper {
	public static final String BEAN_ID = "DatabaseInformationHelper";

	public void refresh();

	public shortcutHelper.helper.databaseInformationHelper.dto.DatabaseInformationConnection getDatabaseInformation(
			String databaseName);

	public boolean hasDatabaseInformation(String databaseName);

}