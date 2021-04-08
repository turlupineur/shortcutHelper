package shortcutHelper.helper.shortcutRegistrationHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultShortcutRegistrationHelper extends Helper{
	public static final String BEAN_ID = "ShortcutRegistrationHelper";

    public void addShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToAdd);


    public void replaceShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToAdd);


    public boolean removeShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToRemove);


    public boolean hasShortcut(shortcutHelper.helper.shortcutFactoryHelper.IShortcut shortcutToCheck);


    public java.util.Map<String,String> getAllShortcuts(

}