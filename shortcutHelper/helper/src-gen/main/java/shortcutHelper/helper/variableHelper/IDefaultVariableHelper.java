package shortcutHelper.helper.variableHelper;

import shortcutHelper.helper.Helper;

public interface IDefaultVariableHelper extends Helper {
	public static final String BEAN_ID = "VariableHelper";

	public void refresh();

	public boolean variableExists(String nameOfVariable);

	public String getVariableValue(String nameOfVariable);

	public void clearAllVariables();

	public void setVariable(String nameOfVariable, String value);

}