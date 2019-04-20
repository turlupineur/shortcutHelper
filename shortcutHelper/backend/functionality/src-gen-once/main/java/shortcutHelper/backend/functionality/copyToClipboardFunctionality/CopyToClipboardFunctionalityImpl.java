package shortcutHelper.backend.functionality.copyToClipboardFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;

public class CopyToClipboardFunctionalityImpl extends AbstractCopyToClipboardFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		CopyToClipboardFunctionalityDataContainer container = (CopyToClipboardFunctionalityDataContainer) c;

		setClipboard(container.getClipboard());

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
