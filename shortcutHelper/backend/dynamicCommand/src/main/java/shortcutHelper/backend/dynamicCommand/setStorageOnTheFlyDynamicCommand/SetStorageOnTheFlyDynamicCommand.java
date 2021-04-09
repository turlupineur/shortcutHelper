package shortcutHelper.backend.dynamicCommand.setStorageOnTheFlyDynamicCommand;

import java.util.List;

import shortcutHelper.backend.dynamicCommand.DynamicCommandShortcutRepository;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.IDefaultSetStorageOnTheFlyFunctionality;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.SetStorageOnTheFlyFunctionalityImpl;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;
import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class SetStorageOnTheFlyDynamicCommand extends AbstractSetStorageOnTheFlyDynamicCommand {

	@Override
	public void run(DynamicCommandShortcutRepository dynamicCommandShortcutRepository) {

		List<String> variableNames = getStringStorageService().listAllStorageForOwner(
				SetStorageOnTheFlyFunctionalityImpl.OWNER, StaticApplicationProperptyHolder.getProperties()
						.getShortcutHelper().getFunctionality().getSetStorageOnTheFly().getStorageFolder());
		for (String variableName : variableNames) {
			IShortcut set = getShortcutFactoryHelper().createShortcut("set." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.SET.toString() });
			IShortcut get = getShortcutFactoryHelper().createShortcut("get." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.GET.toString() });
			IShortcut delete = getShortcutFactoryHelper().createShortcut("delete." + variableName,
					IDefaultSetStorageOnTheFlyFunctionality.class,
					new String[] { variableName, SetStorageOnTheFlyOperation.DELETE.toString() });

			dynamicCommandShortcutRepository.addShorcut(set);
			dynamicCommandShortcutRepository.addShorcut(get);
			dynamicCommandShortcutRepository.addShorcut(delete);
		}
	}

}
