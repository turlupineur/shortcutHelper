package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.Functionality;
import shortcutHelper.backend.functionality.FunctionalityDataContainer;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class ExecuterFunctionalityImpl extends AbstractExecuterFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		ExecuterFunctionalityDataContainer container = (ExecuterFunctionalityDataContainer) c;

		IShortcut shortcutToExecute = container.getShortcutToExecute();

		Functionality functionalityToExecute = (Functionality) getBeanHelper().getBean(shortcutToExecute.getBeanName());

		FunctionalityDataContainer containerForFunctionality = (FunctionalityDataContainer) getFunctionalityContainerHelper()
				.createAndFillContainer(functionalityToExecute.getClass(), shortcutToExecute.getParams());

		containerForFunctionality.setShortcutHelperContext(container.getShortcutHelperContext());

		functionalityToExecute.run(containerForFunctionality);

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
