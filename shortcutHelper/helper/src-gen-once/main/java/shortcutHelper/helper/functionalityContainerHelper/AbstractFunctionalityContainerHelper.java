package shortcutHelper.helper.functionalityContainerHelper;

import shortcutHelper.helper.beanHelper.IBeanHelper;
import shortcutHelper.util.beanUtil.IBeanUtil;

public abstract class AbstractFunctionalityContainerHelper implements IFunctionalityContainerHelper {
	private IBeanUtil beanUtil;
	private IBeanHelper beanHelper;

	public IBeanHelper getBeanHelper() {
		return beanHelper;
	}

	public void setBeanHelper(IBeanHelper beanHelper) {
		this.beanHelper = beanHelper;
	}

	public IBeanUtil getBeanUtil() {
		return beanUtil;
	}

	public void setBeanUtil(IBeanUtil beanUtil) {
		this.beanUtil = beanUtil;
	}
}
