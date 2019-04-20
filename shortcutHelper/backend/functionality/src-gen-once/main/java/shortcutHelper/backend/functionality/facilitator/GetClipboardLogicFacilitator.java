package shortcutHelper.backend.functionality.facilitator;

import shortcutHelper.logic.LogicResult;
import shortcutHelper.logic.getClipboardLogic.GetClipboardLogicDataContainer;
import shortcutHelper.logic.getClipboardLogic.IDefaultGetClipboardLogic;

public interface GetClipboardLogicFacilitator extends LogicFacilitator {
	public default String getClipboard() {
		GetClipboardLogicDataContainer container = (GetClipboardLogicDataContainer) createDataContainerForLogic(
				getGetClipboardLogic());
		LogicResult result = getGetClipboardLogic().run(container);
		return (String) result.getValue();
	}

	public IDefaultGetClipboardLogic getGetClipboardLogic();
}
