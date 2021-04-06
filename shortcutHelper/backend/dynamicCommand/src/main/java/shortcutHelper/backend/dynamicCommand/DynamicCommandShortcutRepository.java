package shortcutHelper.backend.dynamicCommand;

import java.util.HashMap;
import java.util.Map;

import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class DynamicCommandShortcutRepository {
	private Map<String, IShortcut> shortcutsToAdd;
	private Map<String, IShortcut> shortcutsToRemove;

	public DynamicCommandShortcutRepository() {
		shortcutsToAdd = new HashMap<>();
		shortcutsToRemove = new HashMap<>();
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
		shortcutsToRemove.put(shortcut.getName(), shortcut);
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
}
