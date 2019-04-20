package shortcutHelper.logic;

import shortcutHelper.backend.logic.DataContainer;
import shortcutHelper.backend.logic.Logic;
import shortcutHelper.backend.logic.LogicResult;
import shortcutHelper.backendCommon.ExecutableComponent;

public abstract class AbstractLogic extends ExecutableComponent implements Logic {
	public final LogicResult run(DataContainer container) {
		check(container);
		preRunImpl(container);
		LogicResult result = runImpl(container);
		postRunImpl(container, result);
		return result;
	}

	public abstract LogicResult runImpl(DataContainer container);

	public void check(DataContainer container) {
		// implement if required
	}

	public void preRunImpl(DataContainer container) {
		// implement if required
	}

	public void postRunImpl(DataContainer container, LogicResult result) {
		// implement if required
	}
}
