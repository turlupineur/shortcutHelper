package shortcutHelper.helper.shortcutFactoryHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultShortcutFactoryHelper extends Helper{
	public static final String BEAN_ID = "ShortcutFactoryHelper";

    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(Class functionalityClass,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(String shortcutName,Class functionalityClass,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(String beanFunctionality,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(String shortcutName,String beanFunctionality,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(Class functionalityClass,String beanFunctionality,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut createShortcut(String shortcutName,Class functionalityClass,String beanFunctionality,String [] params);


    public shortcutHelper.helper.shortcutFactoryHelper.IShortcut parseShortcut(String lineToParse);


    public String convertShortcutToString(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToConvert);

}