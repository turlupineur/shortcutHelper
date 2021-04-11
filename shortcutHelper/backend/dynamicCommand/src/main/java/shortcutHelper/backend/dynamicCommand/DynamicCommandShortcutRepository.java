package shortcutHelper.backend.dynamicCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class DynamicCommandShortcutRepository {
	private Map<String, IShortcut> shortcutsToAdd;
	private List<String> shortcutsToRemove;

	public DynamicCommandShortcutRepository() {
		shortcutsToAdd = new HashMap<>();
		shortcutsToRemove = new ArrayList<>();
	}

	public void addShorcut(IShortcut shortcut) {
		checkName(shortcut);
		shortcutsToAdd.put(shortcut.getName(), shortcut);
	}

	public boolean alreadyAdded(IShortcut shortcut) {
		checkName(shortcut);
		return shortcutsToAdd.containsKey(shortcut.getName());
	}

	public void removeShortcut(IShortcut shortcut) {
		checkName(shortcut);
		shortcutsToRemove.add(shortcut.getName());
	}

	private void checkName(IShortcut shortcut) {
		if (shortcut.getName() == null) {
			throw new IllegalStateException("Shortcut name is null");
		}
	}

	public int getNbShortcutsAdded() {
		return shortcutsToAdd.size();
	}

	public int getNbShortcutsRemoved() {
		return shortcutsToRemove.size();
	}

	/**
	 * Return a read only map of all the added shortcuts.
	 * 
	 * @return
	 */
	public Map<String, IShortcut> getShortcutsToAdd() {
		return Collections.unmodifiableMap(shortcutsToAdd);
	}

	/**
	 * Returns a read only map of all the removed shortcuts.
	 * 
	 * @return
	 */
	public List<String> getShortcutsToRemove() {
		return Collections.unmodifiableList(shortcutsToRemove);
	}

}
