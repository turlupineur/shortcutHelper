package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.logic.behavior.ClipboardSetBehavior;

public class CopyToClipboardFunctionalityImpl extends AbstractCopyToClipboardFunctionality
		implements ClipboardSetBehavior {
	public FunctionalityResult runImpl(DataContainer c) {
		CopyToClipboardFunctionalityDataContainer container = (CopyToClipboardFunctionalityDataContainer) c;

		setClipboard(container.getClipboard());

		container.getShortcutHelperContext().setInfo("Value copied to clipboard !");
		return ConcreteFunctionalityResult.RESULT_OK;
	}
}
