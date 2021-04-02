package shortcutHelper.helper.databaseInformationHelper;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

import org.yaml.snakeyaml.Yaml;

import shortcutHelper.helper.databaseInformationHelper.dto.DatabaseInformationConnection;
import shortcutHelper.helper.databaseInformationHelper.dto.DatabaseInformationConnections;
import shortcutHelper.logging.ShortcutHelperLogging;

public class DatabaseInformationHelperImpl extends AbstractDatabaseInformationHelper {
	private static final String DATABASE_INFORMATION_CONFIG_FILE = "config/helper/databaseInformationHelper/databaseInformation.yml";
	private Map<String, DatabaseInformationConnection> connections;

	public void refresh() {
		try {
			ShortcutHelperLogging.logSeparationInfo();
			ShortcutHelperLogging
					.logInfo("Loading Database information from config: " + DATABASE_INFORMATION_CONFIG_FILE);
			InputStream inputStream = this.getPropertyLoaderService()
					.getInputStreamForFile(DATABASE_INFORMATION_CONFIG_FILE);
			Yaml yaml = new Yaml();
			DatabaseInformationConnections data = yaml.loadAs(inputStream, DatabaseInformationConnections.class);
			connections = data.connections.stream()
					.collect(Collectors.toMap(DatabaseInformationConnection::getName, connection -> connection));
		} catch (FileNotFoundException e) {
			ShortcutHelperLogging.logInfo("Loading of database config failed: " + e);
			ShortcutHelperLogging.logInfo(e);
		}
		ShortcutHelperLogging.logSeparationInfo();
	}

	public DatabaseInformationConnection getDatabaseInformation(String databaseName) {
		return connections.get(databaseName);
	}

	public boolean hasDatabaseInformation(String databaseName) {
		return connections.containsKey(databaseName);
	}

}