package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.LogicDataContainer;

public class SetClipboardLogicDataContainerCreator extends AbstractSetClipboardLogicDataContainerCreator {

	public LogicDataContainer getDataContainer() {
		return new SetClipboardLogicDataContainer();
	}
};
