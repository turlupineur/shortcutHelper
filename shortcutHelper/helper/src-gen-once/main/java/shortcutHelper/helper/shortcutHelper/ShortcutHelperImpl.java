package shortcutHelper.helper.shortcutHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import shortcutHelper.logging.ShortcutHelperLogging;

public class ShortcutHelperImpl extends AbstractShortcutHelper {
	public static final String FILE_CONTAINING_SHORTCUTS_TO_LOAD = "config/shortcuts/shortcuts.properties";
	public static final String PROPERTY_SHORTCUTS_TO_LOAD = "shortcut.files";
	public static final String LIST_SEPARATOR = ";";
	private Set<String> nonNaviteShortcuts = new HashSet<>();

	@Override
	public void refresh() {
		nonNaviteShortcuts.clear();
		clearAllShorcuts();
		// parsing main shortcut file.
		Properties propShortcutsToLoad = new Properties();
		ShortcutHelperLogging.logSeparationInfo();
		ShortcutHelperLogging.logInfo("LOADING SHORTCUTS");
		try {
			ShortcutHelperLogging.logInfo("Loading shortcuts from: " + FILE_CONTAINING_SHORTCUTS_TO_LOAD);
			propShortcutsToLoad
					.load(this.getPropertyLoaderService().getInputStreamForFile(FILE_CONTAINING_SHORTCUTS_TO_LOAD));
		} catch (Throwable t) {
			ShortcutHelperLogging
					.logInfo("Error while loading shortcuts. No shortcuts was loaded. Error :" + t.getMessage());
			throw new IllegalStateException(
					"Shortcuts' list '" + FILE_CONTAINING_SHORTCUTS_TO_LOAD + "' could not be loaded", t);
		}
		String propShortcutsToLoadValue = propShortcutsToLoad.getProperty(PROPERTY_SHORTCUTS_TO_LOAD);

		if (StringUtil.isNullOrEmpty(propShortcutsToLoadValue)) {
			throw new IllegalStateException("Shortcut list files '" + FILE_CONTAINING_SHORTCUTS_TO_LOAD
					+ "' doesn't not contain a valid list for property '" + PROPERTY_SHORTCUTS_TO_LOAD + "'");
		}
		ShortcutHelperLogging.logInfo("Loading all shortcuts defined in '" + FILE_CONTAINING_SHORTCUTS_TO_LOAD + "'");
		// parse all shortcut files.
		String[] shortcutsToLoadList = propShortcutsToLoadValue.split(LIST_SEPARATOR);
		Properties loadedProperties = new Properties();
		for (String fileToLoad : shortcutsToLoadList) {
			try {
				Properties loadPropertiesFromFile = loadPropertiesFromFile(fileToLoad);
				for (Object keyLoaded : loadPropertiesFromFile.keySet()) {
					if (loadedProperties.containsKey(keyLoaded.toString())) {
						ShortcutHelperLogging.logWarning("Shortcut key '" + keyLoaded
								+ "' is defined more than once. Overwriting shortcut with the one defined in file '"
								+ fileToLoad + "'.");
					}
					loadedProperties.put(keyLoaded.toString(), loadPropertiesFromFile.get(keyLoaded).toString());
				}
				ShortcutHelperLogging.logInfo("Loaded shortcut file : " + fileToLoad);

			} catch (IOException e) {
				ShortcutHelperLogging
						.logWarning("Shortcut file '" + fileToLoad + "' could not be loaded: " + e.getMessage());
			}
		}

		Stream<Entry<Object, Object>> stream = loadedProperties.entrySet().stream();
		Map<String, String> mapOfProperties = stream
				.collect(Collectors.toMap(e -> String.valueOf(e.getKey()), e -> String.valueOf(e.getValue())));

		addShortcuts(mapOfProperties);
		ShortcutHelperLogging.logInfo("DONE LOADING SHORTCUTS.");
		ShortcutHelperLogging.logSeparationInfo();
		setInitialized(true);
	}

	private Properties loadPropertiesFromFile(String file) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(this.getPropertyLoaderService().getInputStreamForFile(file));
		return properties;
	}

	@Override
	public boolean addNonNativeShortcut(String name, String rawShortcut) {
		if (!getListShortcuts().containsKey(name)) {
			replaceNonNativeShortcut(name, rawShortcut);
			return true;
		}
		return false;
	}

	@Override
	public void replaceNonNativeShortcut(String name, String rawShortcut) {
		addShortcut(name, rawShortcut);
		nonNaviteShortcuts.add(name);
	}

	@Override
	public boolean removeShortcut(String name) {
		boolean sucess = super.removeShortcut(name);
		if (sucess && getListShortcuts().containsKey(name)) {
			nonNaviteShortcuts.remove(name);
			return true;
		}
		return false;
	}

}