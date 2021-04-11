package shortcutHelper.helper.propertyHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultPropertyHelper extends Helper{
	public static final String BEAN_ID = "PropertyHelper";

    public void refresh();


    public String getProperty(shortcutHelper.helper.propertyHelper.Property prop);

}