package shortcutHelper.common.properties.data;

public class ShortcutHelperProperties {
	private ServiceProperties service = new ServiceProperties();
	private FunctionalityProperties functionality = new FunctionalityProperties();

	public ServiceProperties getService() {
		return service;
	}

	public void setService(ServiceProperties service) {
		this.service = service;
	}

	public FunctionalityProperties getFunctionality() {
		return functionality;
	}

	public void setFunctionality(FunctionalityProperties functionality) {
		this.functionality = functionality;
	}

}
