package shortcutHelper.util.stringUtil;
import shortcutHelper.util.Util;

public interface IDefaultStringUtil extends Util{
	public static final String BEAN_ID = "StringUtil";

    public int getPositionLastUpperCase(String str);


    public String toFirstUpper(String str);


    public String toFirstLower(String str);

}