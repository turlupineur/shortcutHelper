package shortcutHelper.backend.helper.shortcutFactoryHelper;
import shortcutHelper.backend.helper.Helper;

public interface IDefaultShortcutFactoryHelper extends Helper{
	public static final String BEAN_ID = "ShortcutFactoryHelper";

    public shortcutHelper.backend.helper.shortcutFactoryHelper.IShortcut createShortcut(Class commandClass,String [] params);


    public shortcutHelper.backend.helper.shortcutFactoryHelper.IShortcut createShortcut(String beanCommand,String [] params);


    public shortcutHelper.backend.helper.shortcutFactoryHelper.IShortcut parseShortcut(String lineToParse);

}