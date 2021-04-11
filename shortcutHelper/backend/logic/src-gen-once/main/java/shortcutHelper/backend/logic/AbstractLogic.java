package shortcutHelper.backend.logic;

import shortcutHelper.backendCommon.ExecutableComponent;

public abstract class AbstractLogic extends ExecutableComponent implements Logic {
	public final LogicResult run(LogicDataContainer container) {
		check(container);
		preRunImpl(container);
		LogicResult result = runImpl(container);
		postRunImpl(container, result);
		return result;
	}

	public abstract LogicResult runImpl(LogicDataContainer container);

	public void check(LogicDataContainer container) {
		// implement if required
	}

	public void preRunImpl(LogicDataContainer container) {
		// implement if required
	}

	public void postRunImpl(LogicDataContainer container, LogicResult result) {
		// implement if required
	}
}
