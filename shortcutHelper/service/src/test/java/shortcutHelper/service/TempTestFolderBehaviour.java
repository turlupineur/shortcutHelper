package shortcutHelper.service;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public interface TempTestFolderBehaviour {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	public default String getTempFolder() {
		return folder.getRoot().getAbsolutePath();
	}

}
