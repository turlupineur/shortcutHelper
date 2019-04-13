package shortcutHelper.service.propertyLoaderService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PropertyLoaderServiceImpl implements IPropertyLoaderService {

	private Boolean readAsResource;

	public PropertyLoaderServiceImpl() {
		this.readAsResource = null;
		initializeService();
	}

	public void setReadPropertyAsLocal() {
		this.readAsResource = Boolean.FALSE;
	}

	public void setReadPropertyAsResource() {
		this.readAsResource = Boolean.TRUE;
	}

	@Override
	public InputStream getInputStreamForFile(String file) throws FileNotFoundException {
		if (readAsResource.booleanValue()) {
			return this.getClass().getClassLoader().getResourceAsStream(file);
		} else {
			return new FileInputStream(file);
		}
	}

	private void initializeService() {
		findPropertyLoaderStrategy();
	}

	private void findPropertyLoaderStrategy() {
		File configFolder = new File("config");
		if (configFolder.exists()) {
			setReadPropertyAsLocal();
		} else {
			setReadPropertyAsResource();
		}
	}

}