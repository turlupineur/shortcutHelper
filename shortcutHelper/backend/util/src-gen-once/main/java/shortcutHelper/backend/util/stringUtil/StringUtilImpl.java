package shortcutHelper.backend.util.stringUtil;

public class StringUtilImpl implements IStringUtil {

	public int getPositionLastUpperCase(String str) {
		int posLastUpperCase = INVALID_POSITION;
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= 65 && c <= 90) {
					posLastUpperCase = i;
				}
			}
		}
		return posLastUpperCase;
	}

	@Override
	public String toFirstUpper(String str) {
		if (str == null) {
			return str;
		}
		if (str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
	}

	@Override
	public String toFirstLower(String str) {
		if (str == null) {
			return str;
		}
		if (str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
	}
}