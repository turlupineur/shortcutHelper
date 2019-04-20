package shortcutHelper.helper.functionalityContainerHelper;

import java.lang.reflect.InvocationTargetException;

import shortcutHelper.logging.ShortcutHelperLogging;

public class FunctionalityContainerHelperImpl extends AbstractFunctionalityContainerHelper {

	public Object createDefaultContainerForFunctionality(Class clazz) {
		String containerCreatorBeanName = this.getBeanUtil().getContainerCreatorNameFromClass(clazz);
		Object bean = this.getBeanHelper().getBean(containerCreatorBeanName);
		try {
			return bean.getClass().getMethod("getDataContainer", null).invoke(bean, null);
		} catch (NoSuchMethodException e) {
			ShortcutHelperLogging.logError(e);
		} catch (SecurityException e) {
			ShortcutHelperLogging.logError(e);
		} catch (IllegalAccessException e) {
			ShortcutHelperLogging.logError(e);
		} catch (IllegalArgumentException e) {
			ShortcutHelperLogging.logError(e);
		} catch (InvocationTargetException e) {
			ShortcutHelperLogging.logError(e);
		}
		return null;
	}

	public Object createDefaultContainerForFunctionality(Object _functionality) {
		return createDefaultContainerForFunctionality(_functionality.getClass());
	}

	@Override
	public Object getContainerExtractorFunctionality(Object _functionality) {
		return getContainerExtractorFunctionality(_functionality.getClass());
	}

	@Override
	public Object getContainerExtractorFunctionality(Class clazz) {
		String extractorBeanName = getBeanUtil().getContainerExtractorNameFromClass(clazz);
		return getBeanHelper().getBean(extractorBeanName);
	}

	@Override
	public void fillContainerWithParams(Class clazzFunctionality, Object container, String[] params) {
		Object bean = getContainerExtractorFunctionality(clazzFunctionality);
		try {
			Class[] parametersMethod = { String[].class,
					Class.forName("shortcutHelper.backend.functionality.DataContainer") };
			bean.getClass().getMethod("extractData", parametersMethod).invoke(bean, params, container);
			return;
		} catch (NoSuchMethodException e) {
			ShortcutHelperLogging.logError(e);
		} catch (SecurityException e) {
			ShortcutHelperLogging.logError(e);
		} catch (IllegalAccessException e) {
			ShortcutHelperLogging.logError(e);
		} catch (IllegalArgumentException e) {
			ShortcutHelperLogging.logError(e);
		} catch (InvocationTargetException e) {
			ShortcutHelperLogging.logError(e);
		} catch (ClassNotFoundException e) {
			ShortcutHelperLogging.logError(e);
		}
		throw new IllegalStateException("Method threw unexpected error.");
	}

	@Override
	public Object createAndFillContainer(Class clazz, String[] params) {
		Object container = createDefaultContainerForFunctionality(clazz);
		fillContainerWithParams(clazz, container, params);
		return container;
	}

	@Override
	public Object createAndFillContainer(Object _functionality, String[] params) {
		return createAndFillContainer(_functionality.getClass(), params);
	}

}