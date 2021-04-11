package shortcutHelper.helper.shortcutRegistrationHelper;

import java.util.List;
import java.util.Map;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public interface IShortcutRegistrationHelper extends IDefaultShortcutRegistrationHelper {
	/**
	 * Replace all shortcuts contained in map. If one shortcut doest have a name,
	 * nothing is done.
	 * 
	 * @param shortcuts
	 */
	public void replaceShortcuts(Map<String, IShortcut> shortcuts);

	/**
	 * Adds all shortcuts (only if they dont exist yet). If one shortcut doesnt have
	 * a name, nothing is done.
	 * 
	 * @param shortcuts
	 */
	public void addShortcuts(Map<String, IShortcut> shortcuts);

	public void removeShortcuts(List<String> shortcuts);
}