package shortcutHelper.service.propertyLoaderService;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface IPropertyLoaderService extends IDefaultPropertyLoaderService {
	public InputStream getInputStreamForFile(String file) throws FileNotFoundException;
}