package shortcutHelper.helper.beanHelper;

public class BeanHelperImpl extends AbstractBeanHelper implements IBeanHelper {

	public Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public <T> T getBean(String beanName, T clazz) {
		return (T) getApplicationContext().getBean(beanName);
	}

}