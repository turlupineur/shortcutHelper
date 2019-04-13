package shortcutHelper.backend.helper.propertyHelper;

import java.io.IOException;
import java.util.Properties;

import shortcutHelper.logging.ShortcutHelperLogging;

public class PropertyHelperImpl extends AbstractPropertyHelper {
	private static final String[] LIST_PROPERTY_FILES_TO_LOAD = {
			// "config/properties/fakeProperties.properties"
	};
	private Properties properties;

	public PropertyHelperImpl() {
		properties = null;
	}

	@Override
	public String getProperty(Property prop) {
		refreshIfNeeded();
		return properties.getProperty(prop.getValue());
	}

	@Override
	public void refresh() {
		if (properties == null) {
			properties = new Properties();
		} else {
			properties.clear();
		}
		ShortcutHelperLogging.logSeparationInfo();
		ShortcutHelperLogging.logInfo("LOADING PROPERTIES");

		for (String propertyFileToLoad : LIST_PROPERTY_FILES_TO_LOAD) {
			Properties propFromFile = new Properties();
			ShortcutHelperLogging.logInfo("Loading property file '" + propertyFileToLoad + "'.");
			try {
				propFromFile.load(this.getPropertyLoaderService().getInputStreamForFile(propertyFileToLoad));
				this.properties.putAll(propFromFile);
			} catch (IOException e) {
				ShortcutHelperLogging.logInfo("Property file '" + propertyFileToLoad + "' could not be loaded.");
			}
		}

		ShortcutHelperLogging.logInfo("DONE LOADING PROPERTIES.");
		ShortcutHelperLogging.logSeparationInfo();
	}

	public void refreshIfNeeded() {
		if (properties == null) {
			refresh();
		}
	}

}