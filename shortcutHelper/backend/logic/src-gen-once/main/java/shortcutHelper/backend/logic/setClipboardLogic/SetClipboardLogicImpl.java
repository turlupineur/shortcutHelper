package shortcutHelper.backend.logic.setClipboardLogic;

import shortcutHelper.backend.logic.DataContainer;
import shortcutHelper.backend.logic.LogicResult;
import shortcutHelper.logic.ConcreteLogicResult;

public class SetClipboardLogicImpl extends AbstractSetClipboardLogic {
	public LogicResult runImpl(DataContainer c) {
		SetClipboardLogicDataContainer container = (SetClipboardLogicDataContainer) c;

		this.getClipboardService().setClipboard(container.getClipboardValue());

		return ConcreteLogicResult.RESULT_NULL;
	}
}
