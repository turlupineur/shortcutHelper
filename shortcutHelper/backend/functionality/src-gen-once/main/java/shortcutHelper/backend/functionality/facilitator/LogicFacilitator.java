package shortcutHelper.backend.functionality.facilitator;

import shortcutHelper.backend.logic.DataContainer;
import shortcutHelper.backend.logic.ILogicDataContainerCreator;
import shortcutHelper.backend.logic.Logic;
import shortcutHelper.helper.beanHelper.IBeanHelper;
import shortcutHelper.util.beanUtil.IBeanUtil;

public interface LogicFacilitator {
	public default DataContainer createDataContainerForLogic(Logic logic) {
		String containerCreatorName = this.getBeanUtil().getContainerCreatorNameFromClass(logic.getClass());

		ILogicDataContainerCreator dataContainerCreator = (ILogicDataContainerCreator) this.getBeanHelper()
				.getBean(containerCreatorName);

		return dataContainerCreator.getDataContainer();
	}

	public IBeanUtil getBeanUtil();

	public IBeanHelper getBeanHelper();
}
