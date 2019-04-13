package shortcutHelper.backend.helper.shortcutFactoryHelper;

import shortcutHelper.backend.util.beanUtil.IBeanUtil;

public abstract class AbstractShortcutFactoryHelper implements IShortcutFactoryHelper {
	private IBeanUtil beanUtil;

	public IBeanUtil getBeanUtil() {
		return beanUtil;
	}

	public void setBeanUtil(IBeanUtil beanUtil) {
		this.beanUtil = beanUtil;
	}
}
