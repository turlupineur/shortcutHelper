package shortcutHelper.helper.applicationPropertyHelper;

import shortcutHelper.helper.Helper;

public interface IDefaultApplicationPropertyHelper extends Helper {
	public static final String BEAN_ID = "ApplicationPropertyHelper";

	public void refresh();

	public shortcutHelper.common.properties.data.ApplicationProperties getProperties();

}