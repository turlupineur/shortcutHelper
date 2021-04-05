package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;

public class SetStorageOnTheFlyFunctionalityIntegrationTest_Set
		extends AbstractSetStorageOnTheFlyFunctionalityIntegrationTesting {

	@Test
	public void storeNullClipboard() {
		setClibpoard(null);
		String variableName = "vName";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;

		FunctionalityExecutionResult result = runCurrentFunctionality(variableName, operation.toString());

		assertThat(result.getContext().getInfo(), is("Clipboard empty or invalid."));
	}

	@Test
	public void unrecognizedOperation() {
		String variableName = "vName1";

		FunctionalityExecutionResult result = runCurrentFunctionality(variableName, "salut");
		assertThat(result.getContext().getError(), is("Operation not recognized."));
	}

	@Test
	public void storeNewValueWithGetShortcutAlreadyDefined() {
		String variableName = "coucou";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		registerShortcut(createShortcutWithName("get." + variableName, IDefaultSetStorageOnTheFlyFunctionality.class));

		FunctionalityExecutionResult result = runCurrentFunctionality(variableName, operation.toString());

		assertThat(result.getContext().getError(),
				is("Shortcuts get or delete for '" + variableName + "' defined but no set shortcut."));
	}

	@Test
	public void storeNewValueWithDeleteShortcutAlreadyDefined() {
		String variableName = "coucou2";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		registerShortcut(
				createShortcutWithName("delete." + variableName, IDefaultSetStorageOnTheFlyFunctionality.class));

		FunctionalityExecutionResult result = runCurrentFunctionality(variableName, operation.toString());

		assertThat(result.getContext().getError(),
				is("Shortcuts get or delete for '" + variableName + "' defined but no set shortcut."));
	}

	@Test
	public void replaceStoredValue() {
		String variableName = "coucou3";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		FunctionalityExecutionResult setResult = runCurrentFunctionality(variableName, operation.toString());

		setClibpoard("replacedValue");

		FunctionalityExecutionResult setResult2 = runCurrentFunctionality(variableName, operation.toString());

		setClibpoard("anotherValue");

		operation = SetStorageOnTheFlyOperation.GET;

		FunctionalityExecutionResult getResult = runCurrentFunctionality(variableName, operation.toString());

		assertThat(getClipboard(), is("replacedValue"));
		assertThat(setResult.getContext().getInfo(), is("Value of '" + variableName + "' added on the fly."));
		assertThat(setResult2.getContext().getInfo(), is("Value for '" + variableName + "' replaced."));
		assertThat(getResult.getContext().getInfo(), is("Value copied to clipboard."));

	}

	@Test
	public void storeNewValue() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucou4";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		FunctionalityExecutionResult setResult = runCurrentFunctionality(variableName, operation.toString());

		setClibpoard("anotherValue");

		operation = SetStorageOnTheFlyOperation.GET;

		FunctionalityExecutionResult getResult = runCurrentFunctionality(variableName, operation.toString());

		assertThat(getClipboard(), is("value"));
		assertThat(setResult.getContext().getInfo(), is("Value of '" + variableName + "' added on the fly."));
		assertThat(getResult.getContext().getInfo(), is("Value copied to clipboard."));
	}
}
