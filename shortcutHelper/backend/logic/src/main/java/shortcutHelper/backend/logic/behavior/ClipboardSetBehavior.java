package shortcutHelper.backend.logic.behavior;

import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.SetClipboardLogicDataContainer;

public interface ClipboardSetBehavior {
	IDefaultSetClipboardLogic getSetClipboardLogic();

	default void setClipboard(String clipboard) {
		SetClipboardLogicDataContainer container = new SetClipboardLogicDataContainer();
		container.setClipboardValue(clipboard);
		getSetClipboardLogic().run(container);
	}
}
