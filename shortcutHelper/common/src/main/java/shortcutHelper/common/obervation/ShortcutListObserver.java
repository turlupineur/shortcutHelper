package shortcutHelper.common.obervation;

import java.util.Map;

/**
 * Objects observing the shortcut list should implement this interface to get
 * update.
 * 
 * @author jsvaillant
 *
 */
public interface ShortcutListObserver {
	/**
	 * 
	 * @param newShortcutLists
	 *            The new map is unmodifiable.
	 */
	public void listUpdated(Map<String, String> newShortcutLists);
}
