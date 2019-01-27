package shortcutHelper.helper.shortcutHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import shortcutHelper.service.propertyLoaderService.IPropertyLoaderService;

public abstract class AbstractShortcutHelper implements IShortcutHelper {
	// The list is defined here to have a better control over the update. All updates methods are defined here and will be linked through aop to update gui.
	private Map<String, String> listShortcuts;
	
	private IPropertyLoaderService propertyLoaderService;
	
	public AbstractShortcutHelper()
	{
		listShortcuts = null;
	}
	/**
	 * Returns a unmodifiable copy of the list of shortcuts. To modify the list of shortcuts, please use the appropriate addShortcut methods. 
	 * @return
	 */
	public Map<String,String> getListShortcuts()
	{
		return Collections.unmodifiableMap(listShortcuts);
	}
	
	public String getShortcut(String shortcutId){
    	refreshIfNeeded();
    	return this.listShortcuts.get(shortcutId);
    }
	
	public boolean isListShortcutsInitialized()
	{
		return listShortcuts != null;
	}
	/**
	 * Official method to add shortcuts.
	 * @param keyShortcut
	 * @param shortcut
	 */
	protected void addShortcut(String keyShortcut, String shortcut)
	{
		this.listShortcuts.put(keyShortcut, shortcut);
	}
	/**
	 * Official method to add shortcuts.
	 * @param shortcuts
	 */
	protected void addShortcuts(Map<String, String> shortcuts)
	{
		this.listShortcuts.putAll(shortcuts);
	}
	
	/**
	 * Only refreshes if shortcut list has not been loaded yet.
	 */
	protected void refreshIfNeeded()
	{
		if(!isListShortcutsInitialized())
		{
			this.listShortcuts = new HashMap<String,String>();
			refresh();
		}
	}
	
	public IPropertyLoaderService getPropertyLoaderService() {
		return propertyLoaderService;
	}
	public void setPropertyLoaderService(IPropertyLoaderService propertyLoaderService) {
		this.propertyLoaderService = propertyLoaderService;
	}
}
