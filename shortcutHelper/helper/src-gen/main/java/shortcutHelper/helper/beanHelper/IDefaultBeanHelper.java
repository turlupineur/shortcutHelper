package shortcutHelper.helper.beanHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultBeanHelper extends Helper{
	public static final String BEAN_ID = "BeanHelper";

    public Object getBean(String beanName);

}