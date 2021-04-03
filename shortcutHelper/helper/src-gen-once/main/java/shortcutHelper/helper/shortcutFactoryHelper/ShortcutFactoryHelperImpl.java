package shortcutHelper.helper.shortcutFactoryHelper;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class ShortcutFactoryHelperImpl extends AbstractShortcutFactoryHelper {

	public IShortcut createShortcut(Class commandClass, String[] params) {
		return createShortcut(null, commandClass, params);
	}

	public IShortcut createShortcut(String beanCommand, String[] params) {
		String name = null;
		return createShortcut(name, beanCommand, params);
	}

	private Class extractClassFromBeanName(String beanCommand) {
		Object functionality;
		try {
			functionality = getBeanHelper().getBean(beanCommand);
			return getBeanUtil().getInterfaceFromClass(functionality.getClass());
		} catch (NoSuchBeanDefinitionException nsbde) {
			throw new IllegalArgumentException(
					"The command '" + beanCommand + "' could not be associated to any command defined.");
		}
	}

	@Override
	public IShortcut createShortcut(String shortcutName, String beanCommand, String[] params) {
		if (beanCommand == null) {
			return null;
		}

		Class classCommand = extractClassFromBeanName(beanCommand);

		Shortcut shortcut = new Shortcut(classCommand, beanCommand, params);
		shortcut.beanName = getBeanUtil().getBeanNameFromClass(classCommand);
		shortcut.setName(shortcutName);
		return shortcut;
	}

	public IShortcut parseShortcut(String lineToParse) {
		if (lineToParse == null || lineToParse.length() == 0) {
			return null;
		}
		try {
			IShortcut shortcut = null;
			String[] commandAndParams = lineToParse.split(COMMAND_PARAMS_SEPARATOR);
			String beanCommandName = commandAndParams[0];
			Class classCommand = extractClassFromBeanName(beanCommandName);

			if (commandAndParams.length > 1) {
				String[] params = lineToParse.substring(lineToParse.indexOf(COMMAND_PARAMS_SEPARATOR) + 1)
						.split(PARAMS_SEPARATOR);
				shortcut = createShortcut(classCommand, beanCommandName, params);
			} else {
				shortcut = createShortcut(classCommand, beanCommandName, null);
			}
			return shortcut;
		} catch (Throwable t) {
			return null;
		}

	}

	@Override
	public IShortcut createShortcut(Class functionalityClass, String beanFunctionality, String[] params) {
		return createShortcut(null, functionalityClass, beanFunctionality, params);
	}

	@Override
	public IShortcut createShortcut(String shortcutName, Class commandClass, String[] params) {
		if (commandClass == null) {
			return null;
		}
		commandClass = getBeanUtil().getInterfaceFromClass(commandClass);
		Shortcut shortcut = new Shortcut(commandClass, params);
		shortcut.beanName = getBeanUtil().getBeanNameFromClass(commandClass);
		shortcut.setName(shortcutName);
		return shortcut;
	}

	@Override
	public IShortcut createShortcut(String shortcutName, Class functionalityClass, String beanFunctionality,
			String[] params) {
		if (functionalityClass == null) {
			return createShortcut(beanFunctionality, params);
		}
		if (beanFunctionality == null) {
			return createShortcut(functionalityClass, params);
		}

		Shortcut shortcut = new Shortcut(functionalityClass, beanFunctionality, params);

		return shortcut;
	}

	private class Shortcut implements IShortcut {
		private String name;
		private String beanName;
		private Class classRepresentingCommand;
		private String[] params;

		private Shortcut(String beanName) {
			this.beanName = beanName;
			this.params = null;
		}

		private Shortcut(String beanName, String[] params) {
			this.beanName = beanName;
			this.params = copyParams(params);
		}

		private Shortcut(Class clazz, String[] params) {
			this.classRepresentingCommand = clazz;
			this.params = copyParams(params);
		}

		private Shortcut(Class clazz, String beanName, String[] params) {
			this.classRepresentingCommand = clazz;
			this.beanName = beanName;
			this.params = copyParams(params);
		}

		public Class getClassRepresentingCommand() {
			return classRepresentingCommand;
		}

		public String[] getParams() {
			return copyParams(params);
		}

		public String getBeanName() {
			return beanName;
		}

		private String[] copyParams(String[] params) {
			if (params != null && params.length != 0) {
				String[] copy = new String[params.length];
				for (int i = 0; i < params.length; i++) {
					copy[i] = params[i];
				}
				return copy;
			} else {
				return new String[0];
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@Override
	public String convertShortcutToString(IShortcut shortcutToConvert) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(shortcutToConvert.getBeanName());
		if (shortcutToConvert.getParams() != null && shortcutToConvert.getParams().length > 0) {
			stringBuffer.append(COMMAND_PARAMS_SEPARATOR);
			for (int i = 0; i < shortcutToConvert.getParams().length; i++) {
				stringBuffer.append(shortcutToConvert.getParams()[i]);
				if (i + 1 < shortcutToConvert.getParams().length) {
					stringBuffer.append(PARAMS_SEPARATOR);
				}
			}
		}

		return stringBuffer.toString();
	}
}