package shortcutHelper.util.beanUtil;

import shortcutHelper.logging.ShortcutHelperLogging;

public class BeanUtilImpl extends AbstractBeanUtil {

	public String getBeanNameFromClass(Class clazz) {
		if (clazz != null) {
			try {
				return clazz.getField("BEAN_ID").get(null).toString();
			} catch (NoSuchFieldException | SecurityException e) {
				ShortcutHelperLogging.logError(e);
			} catch (IllegalArgumentException e) {
				ShortcutHelperLogging.logError(e);
			} catch (IllegalAccessException e) {
				ShortcutHelperLogging.logError(e);
			}
		}
		return null;
	}

	public Class getInterfaceFromBeanName(String beanName) {
		int positionLastUpperCase = getStringUtil().getPositionLastUpperCase(beanName);
		if (positionLastUpperCase == -1) {
			throw new IllegalArgumentException("Provided beanName isn't conform to standart");
		}
		String typeOfObject = beanName.substring(positionLastUpperCase);
		String classs = "shortcutHelper." + typeOfObject.toLowerCase() + "." + getStringUtil().toFirstLower(beanName)
				+ ".I" + beanName;
		return toClass(classs);
	}

	public Class getInterfaceFromClass(Class clazz) {
		if (clazz.isInterface()) {
			return clazz;
		}
		return toClass(clazz.getPackage().getName() + "." + "I"
				+ clazz.getSimpleName().replace("Impl", "").replace("Abstract", ""));
	}

	@Override
	public String getContainerCreatorNameFromClass(Class clazz) {
		if (clazz == null) {
			return null;
		}
		Class interfaceFromClass = getInterfaceFromClass(clazz);
		if (interfaceFromClass == null) {
			return null;
		}
		String interfaceName = interfaceFromClass.getSimpleName();
		String interfaceNameContainerCreator = interfaceName.replace("Default", "") + "DataContainerCreator";
		Class interfaceContainerCreator = toClass(interfaceNameContainerCreator);
		if (interfaceContainerCreator != null) {
			return getBeanNameFromClass(interfaceContainerCreator);
		}
		return null;
	}

	@Override
	public String getContainerExtractorNameFromClass(Class clazz) {
		if (clazz == null) {
			return null;
		}
		Class interfaceFromClass = getInterfaceFromClass(clazz);
		if (interfaceFromClass == null) {
			return null;
		}
		String interfaceName = interfaceFromClass.getSimpleName();
		String interfaceNameContainerCreator = interfaceName.replace("Default", "") + "DataContainerExtractor";
		Class interfaceContainerCreator = toClass(interfaceNameContainerCreator);
		if (interfaceContainerCreator != null) {
			return getBeanNameFromClass(interfaceContainerCreator);
		}
		return null;
	}

	private Class toClass(String clazz) {
		try {
			return Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			ShortcutHelperLogging.logError(e);
		}
		return null;
	}
}