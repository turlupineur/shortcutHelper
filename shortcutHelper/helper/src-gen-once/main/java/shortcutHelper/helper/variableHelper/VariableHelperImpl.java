package shortcutHelper.helper.variableHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import shortcutHelper.helper.shortcutHelper.StringUtil;
import shortcutHelper.logging.ShortcutHelperLogging;

public class VariableHelperImpl extends AbstractVariableHelper implements IVariableHelper {
	private static final String FILE_CONTAINING_VARIABLES_TO_LOAD = "config/variables/variables.properties";
	private static final String PROPERTY_VARIABLES_TO_LOAD = "variable.files";
	public static final String LIST_SEPARATOR = ";";
	private Map<String, String> variables;

	public void refresh() {
		Properties propVariablesToLoad = new Properties();
		ShortcutHelperLogging.logSeparationInfo();
		ShortcutHelperLogging.logInfo("LOADING VARIABLES");
		try {
			ShortcutHelperLogging.logInfo("Loading variables from: " + FILE_CONTAINING_VARIABLES_TO_LOAD);
			propVariablesToLoad
					.load(this.getPropertyLoaderService().getInputStreamForFile(FILE_CONTAINING_VARIABLES_TO_LOAD));
		} catch (Throwable t) {
			ShortcutHelperLogging
					.logInfo("Error while loading shortcuts. No shortcuts was loaded. Error :" + t.getMessage());
			throw new IllegalStateException(
					"Variable' list '" + FILE_CONTAINING_VARIABLES_TO_LOAD + "' could not be loaded", t);
		}

		String variablesToLoadValue = propVariablesToLoad.getProperty(PROPERTY_VARIABLES_TO_LOAD);

		if (StringUtil.isNullOrEmpty(variablesToLoadValue)) {
			throw new IllegalStateException("Variable list files '" + FILE_CONTAINING_VARIABLES_TO_LOAD
					+ "' doesn't not contain a valid list for property '" + PROPERTY_VARIABLES_TO_LOAD + "'");
		}
		ShortcutHelperLogging.logInfo("Loading all variables defined in '" + FILE_CONTAINING_VARIABLES_TO_LOAD + "'");
		// parse all shortcut files.
		String[] variablesToLoadList = variablesToLoadValue.split(LIST_SEPARATOR);
		Properties loadedVariables = new Properties();
		for (String fileToLoad : variablesToLoadList) {
			try {
				Properties loadVariablesFromFile = loadPropertiesFromFile(fileToLoad);
				for (Object keyLoaded : loadVariablesFromFile.keySet()) {
					if (loadedVariables.containsKey(keyLoaded.toString())) {
						ShortcutHelperLogging.logWarning("Variable key '" + keyLoaded
								+ "' is defined more than once. Overwriting variable with the one defined in file '"
								+ fileToLoad + "'.");
					}
					loadedVariables.put(keyLoaded.toString(), loadVariablesFromFile.get(keyLoaded).toString());
				}
				ShortcutHelperLogging.logInfo("Loaded variable file : " + fileToLoad);

			} catch (IOException e) {
				ShortcutHelperLogging
						.logWarning("Variable file '" + fileToLoad + "' could not be loaded: " + e.getMessage());
			}
		}

		Stream<Entry<Object, Object>> stream = loadedVariables.entrySet().stream();
		Map<String, String> mapOfProperties = stream
				.collect(Collectors.toMap(e -> String.valueOf(e.getKey()), e -> String.valueOf(e.getValue())));
		variables = mapOfProperties;

		ShortcutHelperLogging.logInfo("DONE LOADING VARIABLES.");
		ShortcutHelperLogging.logSeparationInfo();
	}

	private Properties loadPropertiesFromFile(String file) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(this.getPropertyLoaderService().getInputStreamForFile(file));
		return properties;
	}

	private void loadsIfNeeded() {
		if (variables == null) {
			refresh();
		}
	}

	public boolean variableExists(String name) {
		loadsIfNeeded();
		return variables.containsKey(name);
	}

	public String getVariableValue(String name) {
		loadsIfNeeded();
		return variables.get(name);
	}

	@Override
	public void clearAllVariables() {
		variables = new HashMap<>();
	}

	@Override
	public void setVariable(String name, String value) {
		loadsIfNeeded();
		variables.put(name, value);
	}

}