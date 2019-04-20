package shortcutHelper.backend.functionality.facilitator;

import shortcutHelper.backend.logic.LogicResult;
import shortcutHelper.backend.logic.getClipboardLogic.GetClipboardLogicDataContainer;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;

public interface GetClipboardLogicFacilitator extends LogicFacilitator {
	public default String getClipboard() {
		GetClipboardLogicDataContainer container = (GetClipboardLogicDataContainer) createDataContainerForLogic(
				getGetClipboardLogic());
		LogicResult result = getGetClipboardLogic().run(container);
		return (String) result.getValue();
	}

	public IDefaultGetClipboardLogic getGetClipboardLogic();
}
