package shortcutHelper.logic.getClipboardLogic;

import shortcutHelper.logic.DataContainer;

public class GetClipboardLogicDataContainerCreator extends AbstractGetClipboardLogicDataContainerCreator {

	public DataContainer getDataContainer() {
		GetClipboardLogicDataContainer container = new GetClipboardLogicDataContainer();
		container.setDTrimm(true);
		return container;
	}
};
