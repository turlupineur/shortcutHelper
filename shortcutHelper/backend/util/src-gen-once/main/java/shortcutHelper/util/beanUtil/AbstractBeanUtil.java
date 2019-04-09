package shortcutHelper.util.beanUtil;

import shortcutHelper.util.stringUtil.IStringUtil;

public abstract class AbstractBeanUtil implements IBeanUtil{
	private IStringUtil stringUtil;

	public IStringUtil getStringUtil() {
		return stringUtil;
	}

	public void setStringUtil(IStringUtil stringUtil) {
		this.stringUtil = stringUtil;
	}
	
}
