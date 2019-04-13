package shortcutHelper.util.beanUtil;

import shortcutHelper.util.stringUtil.IDefaultStringUtil;

public abstract class AbstractBeanUtil implements IBeanUtil {
	private IDefaultStringUtil stringUtil;

	public IDefaultStringUtil getStringUtil() {
		return stringUtil;
	}

	public void setStringUtil(IDefaultStringUtil stringUtil) {
		this.stringUtil = stringUtil;
	}
}
