package shortcutHelper.backend.helper.shortcutHelper;
import shortcutHelper.backend.helper.Helper;

public interface IDefaultShortcutHelper extends Helper{
	public static final String BEAN_ID = "ShortcutHelper";

    public String getShortcut(String shortcutId);


    public void refresh();


    public java.util.Map<String,String> getListShortcuts();

}