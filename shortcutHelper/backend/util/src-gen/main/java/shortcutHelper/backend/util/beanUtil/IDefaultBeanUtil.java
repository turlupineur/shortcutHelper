package shortcutHelper.backend.util.beanUtil;
import shortcutHelper.backend.util.Util;

public interface IDefaultBeanUtil extends Util{
	public static final String BEAN_ID = "BeanUtil";

    public String getBeanNameFromClass(Class clazz);


    public Class getInterfaceFromBeanName(String beanName);


    public Class getInterfaceFromClass(Class clazz);

}