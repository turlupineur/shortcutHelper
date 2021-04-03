package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;

public class SetStorageOnTheFlyFunctionalityIntegrationTest_Get
		extends AbstractSetStorageOnTheFlyFunctionalityIntegrationTesting {

	@Test
	public void getStringNotStored() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucou";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.GET;
		setClibpoard("value");

		operation = SetStorageOnTheFlyOperation.GET;

		FunctionalityExecutionResult getResult = runCurrentFunctionality(variableName, operation.toString());

		assertThat(getClipboard(), is("value"));
		assertThat(getResult.getContext().getInfo(), is("No value is stored for this variable."));
	}

	@Test
	public void getStoredString() {
		setOuputFolderForStorageToTempFolder();
		String variableName = "coucou";
		SetStorageOnTheFlyOperation operation = SetStorageOnTheFlyOperation.SET;
		setClibpoard("value");

		FunctionalityExecutionResult setResult = runCurrentFunctionality(variableName, operation.toString());

		setClibpoard("anotherValue");

		operation = SetStorageOnTheFlyOperation.GET;

		FunctionalityExecutionResult getResult = runCurrentFunctionality(variableName, operation.toString());

		assertThat(getClipboard(), is("value"));
		assertThat(getResult.getContext().getInfo(), is("Value copied to clipboard."));
	}
}
