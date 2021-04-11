package shortcutHelper.helper.shortcutHelper;

public class StringUtil {
	public static final String EMPTY_STRING = "";
	public static final String NULL_STRING = null;

	public static final boolean isNullOrEmpty(String str) {
		return str == NULL_STRING || str.length() == 0;
	}
}
