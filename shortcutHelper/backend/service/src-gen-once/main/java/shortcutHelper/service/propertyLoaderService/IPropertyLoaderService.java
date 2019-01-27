package shortcutHelper.service.propertyLoaderService;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface IPropertyLoaderService extends IDefaultPropertyLoaderService{
	/**
	 * Returns the appropriate InputStream to read the given file (whether the file
	 * is located in a local path or as a resource).
	 * @param file The file to read.
	 * @return The appropriate InputStream to read this file. Null if not found (exception may also be thrown instead).
	 * @throws FileNotFoundException 
	 */
	public InputStream getInputStreamForFile(String file) throws FileNotFoundException;
}