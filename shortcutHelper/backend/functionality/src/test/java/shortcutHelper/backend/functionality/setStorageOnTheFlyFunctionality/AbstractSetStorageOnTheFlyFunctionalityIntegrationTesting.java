package shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality;

import java.io.File;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import shortcutHelper.backend.functionality.FunctionalityIntegrationTesting;
import shortcutHelper.common.properties.StaticApplicationProperptyHolder;

public abstract class AbstractSetStorageOnTheFlyFunctionalityIntegrationTesting
		extends FunctionalityIntegrationTesting {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	public String getTempFolder() {
		return folder.getRoot().getAbsolutePath() + File.separator;
	}

	protected void setOuputFolderForStorageToTempFolder() {
		StaticApplicationProperptyHolder.getProperties().getShortcutHelper().getService().getStringStorageService()
				.setTargetFolder(getTempFolder());
	}

}
