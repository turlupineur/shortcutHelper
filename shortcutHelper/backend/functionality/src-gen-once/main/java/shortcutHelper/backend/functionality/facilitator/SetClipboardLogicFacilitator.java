package shortcutHelper.backend.functionality.facilitator;

import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.SetClipboardLogicDataContainer;

public interface SetClipboardLogicFacilitator extends LogicFacilitator {
	public default void setClipboard(String clipboard) {
		SetClipboardLogicDataContainer container = (SetClipboardLogicDataContainer) createDataContainerForLogic(
				getSetClipboardLogic());
		container.setClipboardValue(clipboard);
		getSetClipboardLogic().run(container);
	}

	public IDefaultSetClipboardLogic getSetClipboardLogic();
}
