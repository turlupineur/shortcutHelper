package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;

public class SetStorageOnTheFlyFunctionalityIntegrationTest_DeleteAllFromOwner
		extends AbstractSetStorageOnTheFlyFunctionalityIntegrationTesting {

	@Autowired
	private IShortcutHelper shortcutHelper;

	@Test
	public void deleteAllFromOwner() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucouDelete";
		String variableName2 = "coucouDelete2";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		runCurrentFunctionality(variableName, operation.toString());
		runCurrentFunctionality(variableName2, operation.toString());

		operation = SetStorageOnTheFlyOperation.DELETE_ALL_FROM_OWNER;

		FunctionalityExecutionResult deleteResult = runCurrentFunctionality(operation.toString());

		boolean setShortcutExists = shortcutHelper.getShortcut("set.coucouDelete") != null;
		boolean getShortcutExists = shortcutHelper.getShortcut("get.coucouDelete") != null;
		boolean deleteShortcutExists = shortcutHelper.getShortcut("delete.coucouDelete") != null;
		boolean setShortcutExists2 = shortcutHelper.getShortcut("set.coucouDelete2") != null;
		boolean getShortcutExists2 = shortcutHelper.getShortcut("get.coucouDelete2") != null;
		boolean deleteShortcutExists2 = shortcutHelper.getShortcut("delete.coucouDelete2") != null;

		assertFalse(setShortcutExists);
		assertFalse(getShortcutExists);
		assertFalse(deleteShortcutExists);
		assertFalse(setShortcutExists2);
		assertFalse(getShortcutExists2);
		assertFalse(deleteShortcutExists2);
		assertThat(deleteResult.getContext().getInfo(), is("All variables from this functionality have been erased."));
	}
}
