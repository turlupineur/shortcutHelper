package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import java.util.List;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;
import shortcutHelper.backend.logic.behavior.ClipboardGetBehavior;
import shortcutHelper.backend.logic.behavior.ClipboardSetBehavior;
import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class SetStorageOnTheFlyFunctionalityImpl extends AbstractSetStorageOnTheFlyFunctionality
		implements ClipboardGetBehavior, ClipboardSetBehavior {

	private static final String OWNER = "SetStorageOnTheFly";

	public FunctionalityResult runImpl(FunctionalityDataContainer c) {
		SetStorageOnTheFlyFunctionalityDataContainer container = (SetStorageOnTheFlyFunctionalityDataContainer) c;

		if (container.getOperation() == null) {
			container.getShortcutHelperContext().setError("Operation not recognized.");
			return ConcreteFunctionalityResult.RESULT_NULL;
		}

		if (container.getOperation() == SetStorageOnTheFlyOperation.SET) {
			handleSetOperation(container);
		} else if (container.getOperation() == SetStorageOnTheFlyOperation.GET) {
			handleGetOperation(container);
		} else if (container.getOperation() == SetStorageOnTheFlyOperation.DELETE) {
			handleDeleteOperation(container, container.getVName());
		} else if (container.getOperation() == SetStorageOnTheFlyOperation.DELETE_ALL_FROM_OWNER) {
			handleDeleteAllFromOwner(container);
		} else {
			container.getShortcutHelperContext().setError("Operation '" + container.getOperation() + "' not unknown.");
		}
		return ConcreteFunctionalityResult.RESULT_NULL;
	}

	private void handleDeleteAllFromOwner(SetStorageOnTheFlyFunctionalityDataContainer container) {
		String folderForStorage = StaticApplicationProperptyHolder.getProperties().getShortcutHelper()
				.getFunctionality().getSetStorageOnTheFly().getStorageFolder();
		List<String> storageNames = this.getStringStorageService().listAllStorageForOwner(folderForStorage, OWNER);
		for (String storage : storageNames) {
			handleDeleteOperation(container, storage);
		}
		container.getShortcutHelperContext().setInfo("All variables from this functionality have been erased.");
	}

	private void handleDeleteOperation(SetStorageOnTheFlyFunctionalityDataContainer container, String variableName) {
		String folderForStorage = StaticApplicationProperptyHolder.getProperties().getShortcutHelper()
				.getFunctionality().getSetStorageOnTheFly().getStorageFolder();
		boolean isStringStored = getStringStorageService().stringIsStored(folderForStorage, OWNER, variableName);
		if (isStringStored) {
			boolean success = getStringStorageService().deleteString(folderForStorage, OWNER, variableName);
			IShortcut setShortcut = getShortcutFactoryHelper().createShortcut("set." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.SET.toString() });
			IShortcut getShortcut = getShortcutFactoryHelper().createShortcut("get." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.GET.toString() });
			IShortcut deleteShortcut = getShortcutFactoryHelper().createShortcut("delete." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.DELETE.toString() });
			getShortcutRegistrationHelper().removeShortcut(setShortcut);
			getShortcutRegistrationHelper().removeShortcut(getShortcut);
			getShortcutRegistrationHelper().removeShortcut(deleteShortcut);
			container.getShortcutHelperContext().setInfo("Value deleted from store.");
		} else {
			container.getShortcutHelperContext().setInfo("No value is stored for this variable.");
		}
	}

	private void handleGetOperation(SetStorageOnTheFlyFunctionalityDataContainer container) {
		String folderForStorage = StaticApplicationProperptyHolder.getProperties().getShortcutHelper()
				.getFunctionality().getSetStorageOnTheFly().getStorageFolder();
		boolean isStringStored = getStringStorageService().stringIsStored(folderForStorage, OWNER,
				container.getVName());
		if (isStringStored) {
			String value = getStringStorageService().readString(folderForStorage, OWNER, container.getVName());
			setClipboard(value);
			container.getShortcutHelperContext().setInfo("Value copied to clipboard.");
		} else {
			container.getShortcutHelperContext().setInfo("No value is stored for this variable.");
		}
	}

	private void handleSetOperation(SetStorageOnTheFlyFunctionalityDataContainer container) {
		// TODO Auto-generated method stub
		String clipboard = getClipboard();
		if (clipboard == null || clipboard.length() == 0) {
			container.getShortcutHelperContext().setInfo("Clipboard empty or invalid.");
			return;
		}
		IShortcut setShortcut = retrieveSetShortcut(container.getVName());
		IShortcut getShortcut = retrieveGetShortcut(container.getVName());
		IShortcut deleteShortcut = retrieveDeleteShortcut(container.getVName());

		String folderForStorage = StaticApplicationProperptyHolder.getProperties().getShortcutHelper()
				.getFunctionality().getSetStorageOnTheFly().getStorageFolder();

		if (setShortcut != null) {
			getStringStorageService().storeString(folderForStorage, OWNER, container.getVName(), clipboard);
			container.getShortcutHelperContext().setInfo("Value for '" + container.getVName() + "' replaced.");
		} else {
			if (getShortcut != null || deleteShortcut != null) {
				container.getShortcutHelperContext().setError(
						"Shortcuts get or delete for '" + container.getVName() + "' defined but no set shortcut.");
				return;
			} else {
				getStringStorageService().storeString(folderForStorage, OWNER, container.getVName(), clipboard);

				setShortcut = getShortcutFactoryHelper().createShortcut("set." + container.getVName(),
						IDefaultSetStorageOnTheFlyFunctionality.class,
						new String[] { container.getVName(), SetStorageOnTheFlyOperation.SET.toString() });
				getShortcut = getShortcutFactoryHelper().createShortcut("get." + container.getVName(),
						IDefaultSetStorageOnTheFlyFunctionality.class,
						new String[] { container.getVName(), SetStorageOnTheFlyOperation.GET.toString() });
				deleteShortcut = getShortcutFactoryHelper().createShortcut("delete." + container.getVName(),
						IDefaultSetStorageOnTheFlyFunctionality.class,
						new String[] { container.getVName(), SetStorageOnTheFlyOperation.DELETE.toString() });

				getShortcutRegistrationHelper().addShortcut(setShortcut);
				getShortcutRegistrationHelper().addShortcut(getShortcut);
				getShortcutRegistrationHelper().addShortcut(deleteShortcut);
				container.getShortcutHelperContext()
						.setInfo("Value of '" + container.getVName() + "' added on the fly.");
			}
		}

	}

	private IShortcut retrieveSetShortcut(String variableName) {
		String name = "set." + variableName;
		String rawShortcut = getShortcutHelper().getShortcut(name);
		if (rawShortcut == null) {
			return null;
		} else {
			return getShortcutFactoryHelper().parseShortcut(rawShortcut);
		}
	}

	private IShortcut retrieveGetShortcut(String variableName) {
		String name = "get." + variableName;
		String rawShortcut = getShortcutHelper().getShortcut(name);
		if (rawShortcut == null) {
			return null;
		} else {
			return getShortcutFactoryHelper().parseShortcut(rawShortcut);
		}
	}

	private IShortcut retrieveDeleteShortcut(String variableName) {
		String name = "delete." + variableName;
		String rawShortcut = getShortcutHelper().getShortcut(name);
		if (rawShortcut == null) {
			return null;
		} else {
			return getShortcutFactoryHelper().parseShortcut(rawShortcut);
		}
	}
}
