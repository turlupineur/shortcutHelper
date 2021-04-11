package shortcutHelper.backend.logic;

public class LogicResult{
	
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
