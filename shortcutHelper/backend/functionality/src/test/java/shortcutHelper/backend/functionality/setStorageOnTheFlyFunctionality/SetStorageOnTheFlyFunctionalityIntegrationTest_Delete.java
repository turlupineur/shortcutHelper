package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;
import shortcutHelper.helper.shortcutHelper.IShortcutHelper;

public class SetStorageOnTheFlyFunctionalityIntegrationTest_Delete
		extends AbstractSetStorageOnTheFlyFunctionalityIntegrationTesting {

	@Autowired
	private IShortcutHelper shortcutHelper;

	@Test
	public void deleteStringNotStored() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucou";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.DELETE;
		setClibpoard("value");

		operation = SetStorageOnTheFlyOperation.GET;

		FunctionalityExecutionResult deleteResult = runCurrentFunctionality(variableName, operation.toString());

		assertThat(getClipboard(), is("value"));
		assertThat(deleteResult.getContext().getInfo(), is("No value is stored for this variable."));
	}

	@Test
	public void deleteStoredString() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucou";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		FunctionalityExecutionResult setResult = runCurrentFunctionality(variableName, operation.toString());

		setClibpoard("anotherValue");

		operation = SetStorageOnTheFlyOperation.DELETE;

		FunctionalityExecutionResult deleteResult = runCurrentFunctionality(variableName, operation.toString());

		boolean setShortcutExists = shortcutHelper.getShortcut("set.coucou") != null;
		boolean getShortcutExists = shortcutHelper.getShortcut("get.coucou") != null;
		boolean deleteShortcutExists = shortcutHelper.getShortcut("delete.coucou") != null;

		assertThat(deleteResult.getContext().getInfo(), is("Value deleted from store."));
		assertFalse(setShortcutExists);
		assertFalse(getShortcutExists);
		assertFalse(deleteShortcutExists);
	}

}
