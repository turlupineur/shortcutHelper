package shortcutHelper.helper.variableHelper;

import shortcutHelper.helper.Helper;

public interface IDefaultVariableHelper extends Helper {
	public static final String BEAN_ID = "VariableHelper";

	public void refresh();

	public boolean variableExists(String name);

	public String getVariableValue(String name);

	public void clearAllVariables();

	public void setVariable(String name, String value);

}