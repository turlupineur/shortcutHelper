package shortcutHelper.common.properties.data;

public class SetStorageOnTheFlyFunctionalityProperties {
	private String storageFolder = "storage/setStorageOnTheFly/";

	public String getStorageFolder() {
		return storageFolder;
	}

	public void setStorageFolder(String storageFolder) {
		// present invalid path not ending with path separator.
		if (storageFolder.length() != 0
				&& storageFolder.lastIndexOf(java.io.File.separator) != storageFolder.length() - 1) {
			storageFolder = storageFolder + java.io.File.separator;
		}
		this.storageFolder = storageFolder;
	}
}
