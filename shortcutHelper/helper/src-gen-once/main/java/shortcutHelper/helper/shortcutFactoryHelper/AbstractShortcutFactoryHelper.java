package shortcutHelper.helper.shortcutFactoryHelper;

import shortcutHelper.helper.beanHelper.IBeanHelper;
import shortcutHelper.util.beanUtil.IBeanUtil;

public abstract class AbstractShortcutFactoryHelper implements IShortcutFactoryHelper {
	private IBeanUtil beanUtil;
	private IBeanHelper beanHelper;

	public IBeanUtil getBeanUtil() {
		return beanUtil;
	}

	public void setBeanUtil(IBeanUtil beanUtil) {
		this.beanUtil = beanUtil;
	}

	public IBeanHelper getBeanHelper() {
		return beanHelper;
	}

	public void setBeanHelper(IBeanHelper beanHelper) {
		this.beanHelper = beanHelper;
	}

}
