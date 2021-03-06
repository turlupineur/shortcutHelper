package shortcutHelper.helper.shortcutHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractShortcutHelper implements IShortcutHelper, IShortcutHelperInternalOperation {
	// The list is defined here to have a better control over the update. All
	// updates methods are defined here and will be linked through aop to update
	// gui.
	private Map<String, String> listShortcuts;

	private boolean isInitialized;

	private IPropertyLoaderService propertyLoaderService;

	public AbstractShortcutHelper() {
		this.listShortcuts = new HashMap<String, String>();
		this.isInitialized = false;
	}

	/**
	 * Returns a unmodifiable copy of the list of shortcuts. To modify the list of
	 * shortcuts, please use the appropriate addShortcut methods.
	 * 
	 * @return
	 */
	public Map<String, String> getListShortcuts() {
		return Collections.unmodifiableMap(listShortcuts);
	}

	public Map<String, String> getInternalShortcutList() {
		return listShortcuts;
	}

	public String getShortcut(String shortcutId) {
		refreshIfNeeded();
		return this.listShortcuts.get(shortcutId);
	}

	public boolean isListShortcutsInitialized() {
		return this.isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	/**
	 * Official method to add shortcuts.
	 * 
	 * @param shortcuts
	 */
	protected void addShortcuts(Map<String, String> shortcuts) {
		this.listShortcuts.putAll(shortcuts);
	}

	protected void addShortcut(String name, String shortcut) {
		this.listShortcuts.putIfAbsent(name, shortcut);
	}

	protected void replaceShortcut(String name, String shortcut) {
		this.listShortcuts.put(name, shortcut);
	}

	protected void clearAllShorcuts() {
		this.listShortcuts.clear();
	}

	/**
	 * Only refreshes if shortcut list has not been loaded yet.
	 */
	protected void refreshIfNeeded() {
		if (!isListShortcutsInitialized()) {
			refresh();
		}
	}

	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}

	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}

	@Override
	public boolean removeShortcut(String name) {
		if (getListShortcuts().containsKey(name)) {
			this.listShortcuts.remove(name);
			return true;
		}
		return false;
	}
}
