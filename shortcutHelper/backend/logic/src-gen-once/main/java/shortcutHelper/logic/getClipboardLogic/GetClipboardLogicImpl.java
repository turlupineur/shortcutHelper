package shortcutHelper.logic.getClipboardLogic;

import shortcutHelper.logic.DataContainer;
import shortcutHelper.logic.LogicResult;

public class GetClipboardLogicImpl extends AbstractGetClipboardLogic {
	public LogicResult runImpl(DataContainer c) {
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
