package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.functionality.behaviour.database.DatabaseBehaviour;
import shortcutHelper.backend.logic.behavior.ClipboardSetBehavior;
import shortcutHelper.helper.databaseInformationHelper.dto.DatabaseInformationConnection;
import shortcutHelper.logging.ShortcutHelperLogging;

public class SelectQueryDatabaseFunctionalityImpl extends AbstractSelectQueryDatabaseFunctionality
		implements ClipboardSetBehavior, DatabaseBehaviour {
	public FunctionalityResult runImpl(FunctionalityDataContainer c) {
		SelectQueryDatabaseFunctionalityDataContainer container = (SelectQueryDatabaseFunctionalityDataContainer) c;
		if (getDatabaseInformationHelper().hasDatabaseInformation(container.getDatabaseConnectionName())) {
			DatabaseInformationConnection databaseInformationConnection = getDatabaseInformationHelper()
					.getDatabaseInformation(container.getDatabaseConnectionName());

			try {
				Connection con = createConnection(databaseInformationConnection);
				Statement stmt = con.createStatement();
				try {
					ResultSet rs = stmt.executeQuery(container.getQuery());
					if (rs.next()) {
						String content = rs.getString(1);
						setClipboard(content);
						container.getShortcutHelperContext().setInfo("Result copied to clipboard");
					} else {
						container.getShortcutHelperContext().setInfo("No data returned.");
					}
				} catch (Throwable t) {
					ShortcutHelperLogging.logInfo(t);
					container.getShortcutHelperContext().setError("Error while executing query. See log.");
				}

			} catch (SQLException e) {
				ShortcutHelperLogging.logInfo(e);
				container.getShortcutHelperContext().setError("Connection data contains error.");
			}
		} else {
			container.getShortcutHelperContext()
					.setError("Connection '" + container.getDatabaseConnectionName() + "' could not be found.");
		}
		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
