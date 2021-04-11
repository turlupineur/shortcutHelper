package shortcutHelper.helper.shortcutHelper;

/**
 * This interface is meant for internal operation only.
 * 
 * @author jsvaillant
 *
 */
public interface IShortcutHelperInternalOperation extends IShortcutHelper {

	public boolean addNonNativeShortcut(String name, String rawShortcut);

	public void replaceNonNativeShortcut(String name, String rawShortcut);

	public boolean removeShortcut(String name);
}
