package shortcutHelper.service.stringStorageService;

public interface IStringStorageService extends IDefaultStringStorageService {
	/**
	 * Stores the string using the specified outputfolder for storage. The
	 * outputfolder must ends with a system path separator.
	 * 
	 * @param outputFolder
	 * @param owner
	 * @param vName
	 * @param str
	 */
	public void storeString(String outputFolder, String owner, String vName, String str);

	public String readString(String folder, String owner, String vName);

	public boolean deleteString(String folder, String owner, String vName);

	public boolean stringIsStored(String folder, String owner, String vName);

	public boolean deleteAllStringForOwner(String folder, String owner);

	public java.util.List<String> listAllStorageForOwner(String folder, String owner);
}