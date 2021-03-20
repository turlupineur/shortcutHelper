package shortcutHelper.backend.functionality.executerFunctionality;

import java.util.Arrays;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.Functionality;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.logic.behavior.ClipboardGetBehavior;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;
import shortcutHelper.logging.ShortcutHelperLogging;

public class ExecuterFunctionalityImpl extends AbstractExecuterFunctionality implements ClipboardGetBehavior {
	private static final String CLIPBOARD_REFERENCE = "${CLIPBOARD_VALUE}";

	public FunctionalityResult runImpl(FunctionalityDataContainer c) {
		ExecuterFunctionalityDataContainer container = (ExecuterFunctionalityDataContainer) c;

		IShortcut shortcutToExecute = container.getShortcutToExecute();

		shortcutToExecute = resolveClipboardReference(shortcutToExecute);

		Functionality functionalityToExecute = (Functionality) getBeanHelper().getBean(shortcutToExecute.getBeanName());

		ShortcutHelperLogging.logSeparationInfo();

		ShortcutHelperLogging.logInfo("Executing shortcut: " + shortcutToExecute.getBeanName() + ", with params: "
				+ Arrays.toString(shortcutToExecute.getParams()));

		ShortcutHelperLogging.logInfo("Running class: " + functionalityToExecute.getClass().getName());

		ShortcutHelperLogging.logSeparationInfo();

		FunctionalityDataContainer containerForFunctionality = (FunctionalityDataContainer) getFunctionalityContainerHelper()
				.createAndFillContainer(functionalityToExecute.getClass(), shortcutToExecute.getParams());

		containerForFunctionality.setShortcutHelperContext(container.getShortcutHelperContext());

		functionalityToExecute.run(containerForFunctionality);

		return ConcreteFunctionalityResult.RESULT_NULL;
	}

	private IShortcut resolveClipboardReference(IShortcut shortcut) {
		String[] params = shortcut.getParams();
		String clipboardValue = getClipboard();

		for (int i = 0; i < params.length; i++) {
			params[i] = params[i].replace(CLIPBOARD_REFERENCE, clipboardValue);
		}

		return getShortcutFactoryHelper().createShortcut(shortcut.getBeanName(), params);

	}

}
