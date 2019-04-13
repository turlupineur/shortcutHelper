package shortcutHelper.backend.helper.propertyHelper;
import shortcutHelper.backend.helper.Helper;

public interface IDefaultPropertyHelper extends Helper{
	public static final String BEAN_ID = "PropertyHelper";

    public void refresh();


    public String getProperty(shortcutHelper.backend.helper.propertyHelper.Property prop);

}