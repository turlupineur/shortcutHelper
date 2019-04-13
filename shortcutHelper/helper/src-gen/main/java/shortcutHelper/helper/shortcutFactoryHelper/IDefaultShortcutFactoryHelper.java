package shortcutHelper.helper.shortcutFactoryHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultShortcutFactoryHelper extends Helper{
	public static final String BEAN_ID = "ShortcutFactoryHelper";

    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(Class commandClass,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(String beanCommand,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut parseShortcut(String lineToParse);

}