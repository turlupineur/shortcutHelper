package shortcutHelper.service.stringStorageService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.logging.ShortcutHelperLogging;

public class StringStorageServiceImpl extends AbstractStringStorageService {
	public static final String NAME_SEPARATOR = "_";
	public static final String EXTENTION_FILE = ".txt";

	public void storeString(String owner, String name, String str) {
		storeString(getOutputFolder(), owner, name, str);
	}

	public void storeString(String outputFolder, String owner, String name, String str) {
		String fileName = createFileKey(owner, name) + EXTENTION_FILE;
		try {
			File file = new File(outputFolder + fileName);
			File parent = new File(file.getParent());
			if (!parent.exists()) {
				parent.mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
			writer.write(str);
			writer.flush();
			writer.close();
			ShortcutHelperLogging.logInfo("Stored string in : " + file.getAbsolutePath());
		} catch (IOException e) {
			ShortcutHelperLogging.logError(e);
			throw new IllegalStateException(e);
		}
	}

	public String readString(String owner, String name) {
		return readString(getOutputFolder(), owner, name);
	}

	public String readString(String outputFolder, String owner, String name) {
		String fileName = createFileKey(owner, name) + EXTENTION_FILE;
		File fileToRead = new File(outputFolder + fileName);
		if (fileToRead.exists()) {
			StringBuffer stringBuffer = new StringBuffer();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
				String readLine = reader.readLine();
				while (readLine != null) {
					stringBuffer.append(readLine);
					readLine = reader.readLine();
					if (readLine != null) {
						stringBuffer.append("\n");
					}
				}
			} catch (IOException e) {
				ShortcutHelperLogging.logError(e);
				throw new IllegalStateException(e);
			}
			return stringBuffer.toString();
		} else {
			return null;
		}
	}

	public boolean stringIsStored(String owner, String name) {
		return stringIsStored(getOutputFolder(), owner, name);
	}

	public boolean stringIsStored(String outputFolder, String owner, String name) {
		String fileName = createFileKey(owner, name) + EXTENTION_FILE;
		File fileToRead = new File(outputFolder + fileName);
		if (fileToRead.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteAllStringForOwner(String owner) {
		return deleteAllStringForOwner(getOutputFolder(), owner);
	}

	public boolean deleteAllStringForOwner(String folder, String owner) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner cannot be null.");
		}
		File rootFolder = new File(folder);
		boolean success = true;
		String[] files = rootFolder.list(new FilenameFilter() {

			@Override
			public boolean accept(File file, String fileName) {
				return fileName.startsWith(owner);
			}
		});
		for (String file : files) {
			File f = new File(folder + file);
			success = success && f.delete();
		}
		return success;
	}

	public List<String> listAllStorageForOwner(String owner) {
		return listAllStorageForOwner(getOutputFolder(), owner);
	}

	public List<String> listAllStorageForOwner(String folder, String owner) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner cannot be null.");
		}
		List<String> allStorages = new ArrayList<>();

		File rootFolder = new File(folder);
		boolean success = true;
		String[] files = rootFolder.list(new FilenameFilter() {

			@Override
			public boolean accept(File file, String fileName) {
				return fileName.startsWith(owner);
			}
		});

		for (String file : files) {
			String variableName = extractVariableNameFromFileName(file);
			if (variableName != null) {
				allStorages.add(variableName);
			}
		}

		return allStorages;

	}

	@Override
	public boolean deleteString(String owner, String name) {
		return deleteString(getOutputFolder(), owner, name);
	}

	public boolean deleteString(String folder, String owner, String name) {
		String fileName = createFileKey(owner, name) + EXTENTION_FILE;
		File file = new File(folder + fileName);
		if (file.exists()) {
			return file.delete();
		} else {
			return true;
		}
	}

	private String createFileKey(String owner, String name) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner cannot be null.");
		}
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null.");
		}
		if (owner.contains(NAME_SEPARATOR)) {
			throw new IllegalArgumentException("Owner cannot contains '" + NAME_SEPARATOR + "'");
		}
		return owner + NAME_SEPARATOR + name;
	}

	private String getOutputFolder() {
		return StaticApplicationProperptyHolder.getProperties().getShortcutHelper().getService()
				.getStringStorageService().getTargetFolder();
	}

	private String extractVariableNameFromFileName(String file) {
		if (!file.contains(NAME_SEPARATOR)) {
			return null;
		}
		file = file.replace(EXTENTION_FILE, "");
		return file.substring(file.indexOf(NAME_SEPARATOR) + 1);
	}

}