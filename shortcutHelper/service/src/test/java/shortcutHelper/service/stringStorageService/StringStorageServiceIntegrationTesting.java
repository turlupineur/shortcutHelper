package shortcutHelper.service.stringStorageService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.service.ServiceIntegrationTesting;

public class StringStorageServiceIntegrationTesting extends ServiceIntegrationTesting {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	public String getTempFolder() {
		return folder.getRoot().getAbsolutePath() + File.separator;
	}

	@Autowired
	private IStringStorageService stringStorageService;

	@Test(expected = IllegalArgumentException.class)
	public void storeStringNullOwner() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString(null, "name", "value");
	}

	@Test(expected = IllegalArgumentException.class)
	public void storeStringNullName() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", null, "value");
	}

	@Test(expected = IllegalArgumentException.class)
	public void storeStringOwnerContainsIllegalCharacter() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner_", null, "value");
	}

	@Test(expected = IllegalStateException.class)
	public void storeStringNullStringValue() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner\"", "name", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void storeStringWithOwnerContainingIllegalFileCharacters() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner_", "name", null);
	}

	@Test
	public void normalStringStorage() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", "name", "value");
		String value = stringStorageService.readString("owner", "name");
		assertThat(value, is("value"));
	}

	@Test
	public void overwriteStringStorage() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", "name", "value");
		stringStorageService.storeString("owner", "name", "value2");
		String value = stringStorageService.readString("owner", "name");
		assertThat(value, is("value2"));
	}

	@Test
	public void normalDeleteString() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", "name", "value");
		stringStorageService.deleteString("owner", "name");
		assertFalse(stringStorageService.stringIsStored("owner", "name"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteStringNullOwner() {
		setOuputFolderToTempFolder();
		stringStorageService.deleteString(null, "name");
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteStringNullName() {
		setOuputFolderToTempFolder();
		stringStorageService.deleteString("owner", null);
	}

	@Test
	public void stringIsNotStoredTest() {
		setOuputFolderToTempFolder();
		assertFalse(stringStorageService.stringIsStored("owner", "name"));
	}

	@Test
	public void stringIsStoredTest() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", "name", "value");
		assertTrue(stringStorageService.stringIsStored("owner", "name"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteAllFromOwnerWithNullOwner() {
		setOuputFolderToTempFolder();
		stringStorageService.deleteAllStringForOwner(null);
	}

	@Test
	public void deleteAllFromOwnerNormalCase() {
		setOuputFolderToTempFolder();
		stringStorageService.storeString("owner", "name1", "value");
		stringStorageService.storeString("owner", "name2", "value");
		stringStorageService.deleteAllStringForOwner("owner");
		assertFalse(stringStorageService.stringIsStored("owner", "name1"));
		assertFalse(stringStorageService.stringIsStored("owner", "name2"));
	}

	private void setOuputFolderToTempFolder() {
		StaticApplicationProperptyHolder.getProperties().getShortcutHelper().getService().getStringStorageService()
				.setTargetFolder(getTempFolder());
	}
}
