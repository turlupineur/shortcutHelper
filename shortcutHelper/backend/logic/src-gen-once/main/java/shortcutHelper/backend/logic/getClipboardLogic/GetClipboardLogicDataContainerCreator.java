package shortcutHelper.backend.logic.getClipboardLogic;

import shortcutHelper.backend.logic.LogicDataContainer;

public class GetClipboardLogicDataContainerCreator extends AbstractGetClipboardLogicDataContainerCreator {

	public LogicDataContainer getDataContainer() {
		return new GetClipboardLogicDataContainer();
	}
};
