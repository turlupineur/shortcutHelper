package shortcutHelper.logic.setClipboardLogic;

import shortcutHelper.logic.ConcreteLogicResult;
import shortcutHelper.logic.DataContainer;
import shortcutHelper.logic.LogicResult;

public class SetClipboardLogicImpl extends AbstractSetClipboardLogic {
	public LogicResult runImpl(DataContainer c) {
		SetClipboardLogicDataContainer container = (SetClipboardLogicDataContainer) c;

		this.getClipboardService().setClipboard(container.getClipboardValue());

		return ConcreteLogicResult.RESULT_NULL;
	}
}
