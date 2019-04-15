package shortcutHelper.backend.functionality.executerFunctionality;

import shortcutHelper.backend.functionality.ConcreteFunctionalityResult;
import shortcutHelper.backend.functionality.DataContainer;
import shortcutHelper.backend.functionality.Functionality;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class ExecuterFunctionalityImpl extends AbstractExecuterFunctionality {
	public FunctionalityResult runImpl(DataContainer c) {
		ExecuterFunctionalityDataContainer container = (ExecuterFunctionalityDataContainer) c;

		IShortcut shortcutToExecute = container.getShortcutToExecute();

		DataContainer containerForFunctionality = (DataContainer) getFunctionalityContainerHelper()
				.createAndFillContainer(shortcutToExecute.getClassRepresentingCommand(), shortcutToExecute.getParams());

		Functionality functionalityToExecute = (Functionality) getBeanHelper().getBean(shortcutToExecute.getBeanName());

		containerForFunctionality.setShortcutHelperContext(container.getShortcutHelperContext());

		functionalityToExecute.run(containerForFunctionality);

		return ConcreteFunctionalityResult.RESULT_NULL;
	}
}
