package shortcutHelper.helper.applicationPropertyHelper;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.common.properties.data.ApplicationProperties;
import shortcutHelper.logging.ShortcutHelperLogging;

public class ApplicationPropertyHelperImpl extends AbstractApplicationHelper {

	private static final String PROPERTY_CONFIG_FILE = "config/properties/application.yml";

	private ApplicationProperties properties;

	public void refresh() {
		try {
			ShortcutHelperLogging.logSeparationInfo();
			ShortcutHelperLogging.logInfo("Loading Properties information from config: " + PROPERTY_CONFIG_FILE);
			InputStream inputStream = this.getPropertyLoaderService().getInputStreamForFile(PROPERTY_CONFIG_FILE);
			Yaml yaml = new Yaml();
			properties = yaml.loadAs(inputStream, ApplicationProperties.class);
			StaticApplicationProperptyHolder.setProperties(properties);
		} catch (FileNotFoundException e) {
			ShortcutHelperLogging.logInfo("Loading of properties config failed: " + e);
			ShortcutHelperLogging.logInfo(e);
		}
		ShortcutHelperLogging.logSeparationInfo();
	}

	@Override
	public ApplicationProperties getProperties() {
		return properties;
	}

}