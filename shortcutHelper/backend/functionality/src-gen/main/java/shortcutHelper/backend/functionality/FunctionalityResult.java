package shortcutHelper.backend.functionality;

public class FunctionalityResult{
	
	private Object value;
	
	public Object getValue()
	{
		return value;
	}
	
	public String getValueAsString()
	{
		if(value == null){
			return null;
		}else{
			return value.toString();					
		}
	}
	
	public void setValue(Object value)
	{
		this.value = value;
	}
}
