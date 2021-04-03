package shortcutHelper.common.properties;

import shortcutHelper.common.properties.data.ApplicationProperties;

public class StaticApplicationProperptyHolder {
	private static ApplicationProperties properties;

	public static ApplicationProperties getProperties() {
		return properties;
	}

	public static void setProperties(ApplicationProperties properties) {
		StaticApplicationProperptyHolder.properties = properties;
	}
}
