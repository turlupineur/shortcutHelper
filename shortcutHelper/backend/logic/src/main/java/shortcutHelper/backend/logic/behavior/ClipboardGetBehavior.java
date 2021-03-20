package shortcutHelper.backend.logic.behavior;

import shortcutHelper.backend.logic.LogicResult;
import shortcutHelper.backend.logic.getClipboardLogic.GetClipboardLogicDataContainer;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;

public interface ClipboardGetBehavior {
	IDefaultGetClipboardLogic getGetClipboardLogic();

	default String getClipboard() {
		GetClipboardLogicDataContainer container = new GetClipboardLogicDataContainer();
		LogicResult logicResult = getGetClipboardLogic().run(container);
		return (String) logicResult.getValue();
	}
}
