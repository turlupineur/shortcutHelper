package shortcutHelper.backend.functionality.executerFunctionality;

import java.util.Arrays;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.Functionality;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;
import shortcutHelper.logging.ShortcutHelperLogging;

public class ExecuterFunctionalityImpl extends AbstractExecuterFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		ExecuterFunctionalityDataContainer container = (ExecuterFunctionalityDataContainer) c;

		IShortcut shortcutToExecute = container.getShortcutToExecute();

		ShortcutHelperLogging.logInfo("Executing shortcut: " + shortcutToExecute.getBeanName() + ", with params: "
				+ Arrays.toString(shortcutToExecute.getParams()));

		Functionality functionalityToExecute = (Functionality) getBeanHelper().getBean(shortcutToExecute.getBeanName());

		ShortcutHelperLogging.logInfo("Running class: " + functionalityToExecute.getClass().getName());

		DataContainer containerForFunctionality = (DataContainer) getFunctionalityContainerHelper()
				.createAndFillContainer(functionalityToExecute.getClass(), shortcutToExecute.getParams());

		containerForFunctionality.setShortcutHelperContext(container.getShortcutHelperContext());

		functionalityToExecute.run(containerForFunctionality);

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
