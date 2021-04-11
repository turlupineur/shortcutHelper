package shortcutHelper.backend.dynamicCommand;

import java.io.File;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shortcutHelper.backend.functionality.FunctionalityExecutionResult;
import shortcutHelper.backend.functionality.FunctionalityResult;
import shortcutHelper.backend.functionality.executerFunctionality.ExecuterFunctionalityDataContainer;
import shortcutHelper.backend.functionality.executerFunctionality.IDefaultExecuterFunctionality;
import shortcutHelper.backend.logic.ILogicDataContainerCreator;
import shortcutHelper.backend.logic.LogicDataContainer;
import shortcutHelper.backend.logic.LogicResult;
import shortcutHelper.backend.logic.getClipboardLogic.GetClipboardLogicDataContainer;
import shortcutHelper.backend.logic.getClipboardLogic.IDefaultGetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.backend.logic.setClipboardLogic.SetClipboardLogicDataContainer;
import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.helper.beanHelper.IBeanHelper;
import shortcutHelper.helper.functionalityContainerHelper.IDefaultFunctionalityContainerHelper;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcutFactoryHelper;
import shortcutHelper.util.beanUtil.IBeanUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/beans/backend/functionality/functionality-data-container-creator-man.xml",
		"/config/beans/backend/functionality/functionality-data-container-data-extractor-man.xml",
		"/config/beans/backend/functionality/functionality-man.xml", "/config/beans/helper/helper-man.xml",
		"/config/beans/util/util-man.xml", "/config/beans/service/service-man.xml",
		"/config/beans/backend/logic/logic-man.xml", "/config/beans/backend/functionality/functionality_command.xml",
		"/config/beans/backend/logic/logic-data-container-creator-man.xml",
		"/config/beans/backend/functionality/functionality-man.xml",
		"/config/beans/backend/dynamicCommand/dynamicCommands.xml",
		"/config/beans/backend/dynamicCommand/dynamicCommandController.xml",
		"/config/beans/common/dynamicCommandObserver/fakeDynamicCommandObservers.xml",
		"/shortcutHelper/helper/fakeShortcutObservers.xml" })
public class DynamicCommandIntegrationTesting {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Autowired
	private IBeanUtil beanUtil;

	@Autowired
	private IShortcutFactoryHelper shortcutFactoryHelper;

	@Autowired
	private IDefaultExecuterFunctionality executerFunctionality;

	@Autowired
	private IDefaultFunctionalityContainerHelper functionalityContainerHelper;

	@Autowired
	private IDefaultGetClipboardLogic getClipboardLogic;

	@Autowired
	private IDefaultSetClipboardLogic setClipboardLogic;

	@Autowired
	private IBeanHelper beanHelper;

	/**
	 * Runs functionality with provided params.
	 * 
	 * @param functionalityToRun
	 * @param params
	 * @return Execution's result
	 */
	public FunctionalityExecutionResult runFunctionality(Class functionalityToRun, String... params) {
		FunctionalityExecutionResult functionalityExecutionResult = new FunctionalityExecutionResult();
		ShortcutHelperContext context = new ShortcutHelperContext();

		String beanNameForFunctionality = beanUtil.getBeanNameFromClass(functionalityToRun);
		IShortcut shortcut = shortcutFactoryHelper.createShortcut(functionalityToRun, beanNameForFunctionality, params);

		ExecuterFunctionalityDataContainer container = (ExecuterFunctionalityDataContainer) functionalityContainerHelper
				.createAndFillContainer(executerFunctionality, null);
		container.setShortcutToExecute(shortcut);
		container.setShortcutHelperContext(context);

		FunctionalityResult result = executerFunctionality.run(container);

		functionalityExecutionResult.setContext(context);
		functionalityExecutionResult.setExecutedShortcut(shortcut);
		functionalityExecutionResult.setResult(result);

		return functionalityExecutionResult;
	}

	/**
	 * Convenient method to set clipboard using default Logic object.
	 * 
	 * @param clipboard
	 *            Clipboard value.
	 */
	public void setClibpoard(String clipboard) {
		SetClipboardLogicDataContainer dataContainer = (SetClipboardLogicDataContainer) createContainer(
				setClipboardLogic);
		dataContainer.setClipboardValue(clipboard);
		setClipboardLogic.run(dataContainer);
	}

	/**
	 * Convenient method to get clipboard value using default Logic object.
	 * 
	 * @return
	 */
	public String getClipboard() {
		GetClipboardLogicDataContainer dataContainer = (GetClipboardLogicDataContainer) createContainer(
				getClipboardLogic);
		LogicResult result = getClipboardLogic.run(dataContainer);

		return result.getValueAsString();
	}

	private Object createContainer(Object o) {
		String containerCreatorName = beanUtil.getContainerCreatorNameFromClass(o.getClass());

		ILogicDataContainerCreator dataContainerCreator = (ILogicDataContainerCreator) beanHelper
				.getBean(containerCreatorName);

		LogicDataContainer container = dataContainerCreator.getDataContainer();
		container.setShortcutHelperContext(new ShortcutHelperContext());
		return container;
	}

	public String getTempFolder() {
		return folder.getRoot().getAbsolutePath() + File.separator;
	}

}
