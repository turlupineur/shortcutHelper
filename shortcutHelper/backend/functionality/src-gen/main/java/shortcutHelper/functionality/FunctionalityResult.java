package shortcutHelper.functionality;

public class FunctionalityResult{
	
	private Object value;
	
	public Object getValue()
	{
		return value;
	}
	
	public Object getValueAsString()
	{
		return value.toString();
	}
	
	public void setValue(Object value)
	{
		this.value = value;
	}
}
