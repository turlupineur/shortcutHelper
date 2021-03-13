package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.ConcreteLogicResult;
import shortcutHelper.backend.logic.LogicDataContainer;
import shortcutHelper.backend.logic.LogicResult;

public class SetClipboardLogicImpl extends AbstractSetClipboardLogic {
	public LogicResult runImpl(LogicDataContainer c) {
		SetClipboardLogicDataContainer container = (SetClipboardLogicDataContainer) c;

		this.getClipboardService().setClipboard(container.getClipboardValue());

		return ConcreteLogicResult.RESULT_NULL;
	}
}
