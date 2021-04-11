package shortcutHelper.backend.functionality;

import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class FunctionalityExecutionResult {
	private IShortcut executedShortcut;
	private FunctionalityResult result;
	private ShortcutHelperContext context;

	public IShortcut getExecutedShortcut() {
		return executedShortcut;
	}

	public void setExecutedShortcut(IShortcut executedShortcut) {
		this.executedShortcut = executedShortcut;
	}

	public FunctionalityResult getResult() {
		return result;
	}

	public void setResult(FunctionalityResult result) {
		this.result = result;
	}

	public ShortcutHelperContext getContext() {
		return context;
	}

	public void setContext(ShortcutHelperContext context) {
		this.context = context;
	}

}
