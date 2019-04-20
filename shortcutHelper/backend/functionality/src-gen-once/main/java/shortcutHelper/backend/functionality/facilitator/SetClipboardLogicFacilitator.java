package shortcutHelper.backend.functionality.facilitator;

import shortcutHelper.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.logic.setClipboardLogic.SetClipboardLogicDataContainer;

public interface SetClipboardLogicFacilitator extends LogicFacilitator {
	public default void setClipboard(String clipboard) {
		SetClipboardLogicDataContainer container = (SetClipboardLogicDataContainer) createDataContainerForLogic(
				getSetClipboardLogic());
		container.setClipboardValue(clipboard);
		getSetClipboardLogic().run(container);
	}

	public IDefaultSetClipboardLogic getSetClipboardLogic();
}
