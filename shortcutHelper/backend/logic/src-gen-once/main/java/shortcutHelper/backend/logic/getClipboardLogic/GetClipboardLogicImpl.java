package shortcutHelper.backend.logic.getClipboardLogic;

import shortcutHelper.backend.logic.LogicDataContainer;
import shortcutHelper.backend.logic.LogicResult;

public class GetClipboardLogicImpl extends AbstractGetClipboardLogic {
	public LogicResult runImpl(LogicDataContainer c) {
		GetClipboardLogicDataContainer container = (GetClipboardLogicDataContainer) c;

		String clipboard = this.getClipboardService().getClipboard();
		if (clipboard != null && container.getDTrimm()) {
			clipboard = clipboard.trim();
		}

		LogicResult logicResult = new LogicResult();
		logicResult.setValue(clipboard);
		return logicResult;
	}
}
