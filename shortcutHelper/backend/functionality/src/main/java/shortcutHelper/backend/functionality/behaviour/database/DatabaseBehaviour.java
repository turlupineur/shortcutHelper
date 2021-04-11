package shortcutHelper.backend.functionality.behaviour.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import shortcutHelper.helper.databaseInformationHelper.dto.DatabaseInformationConnection;

public interface DatabaseBehaviour {

	public default Connection createConnection(DatabaseInformationConnection databaseInformationConnection)
			throws SQLException {
		String host = databaseInformationConnection.host;
		int port = databaseInformationConnection.port;
		String password = databaseInformationConnection.password;
		String username = databaseInformationConnection.username;
		String database = databaseInformationConnection.database;
		return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
	}

}
