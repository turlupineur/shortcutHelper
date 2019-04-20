package shortcutHelper.helper.shortcutFactoryHelper;

public class ShortcutFactoryHelperImpl extends AbstractShortcutFactoryHelper {

	public IShortcut createShortcut(Class commandClass, String[] params) {
		if (commandClass == null) {
			return null;
		}
		commandClass = getBeanUtil().getInterfaceFromClass(commandClass);
		Shortcut shortcut = new Shortcut(commandClass, params);
		shortcut.beanName = getBeanUtil().getBeanNameFromClass(commandClass);
		return shortcut;
	}

	public IShortcut createShortcut(String beanCommand, String[] params) {
		if (beanCommand == null) {
			return null;
		}
		Shortcut shortcut = new Shortcut(beanCommand, params);
		shortcut.classRepresentingCommand = getBeanUtil().getInterfaceFromBeanName(beanCommand);
		return shortcut;
	}

	public IShortcut parseShortcut(String lineToParse) {
		if (lineToParse == null || lineToParse.length() == 0) {
			throw new IllegalArgumentException("Parameter was null or empty.");
		}
		IShortcut shortcut = null;
		String[] commandAndParams = lineToParse.split(COMMAND_PARAMS_SEPARATOR);
		String beanCommandName = commandAndParams[0];
		if (commandAndParams.length > 1) {
			String[] params = commandAndParams[1].split(PARAMS_SEPARATOR);
			shortcut = createShortcut(beanCommandName, params);
		} else {
			shortcut = new Shortcut(beanCommandName);
			shortcut = createShortcut(beanCommandName, null);
		}
		return shortcut;
	}

	@Override
	public IShortcut createShortcut(Class functionalityClass, String beanFunctionality, String[] params) {
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
	}

}