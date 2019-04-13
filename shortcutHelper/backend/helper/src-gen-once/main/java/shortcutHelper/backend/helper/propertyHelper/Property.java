package shortcutHelper.backend.helper.propertyHelper;

public enum Property {
	FAKE_PROPERTY("fakeProperties");
	private String value;

	private Property(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
