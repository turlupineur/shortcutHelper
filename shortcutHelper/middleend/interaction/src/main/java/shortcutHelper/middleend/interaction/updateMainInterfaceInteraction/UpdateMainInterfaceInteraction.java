package shortcutHelper.middleend.interaction.updateMainInterfaceInteraction;

import java.util.ArrayList;
import java.util.List;

import shortcutHelper.frontend.viewbean.MainInterfaceViewBean;

public class UpdateMainInterfaceInteraction extends AbstractUpdateMainInterfaceInteraction{

	@Override
	public void execute(MainInterfaceViewBean bean) {
		getUpdateMainInterfaceBackendInteraction().execute(null);
		List<String> listShortcutsToShow = new ArrayList<String>();
		listShortcutsToShow.addAll(this.getShortcutHelper().getListShortcuts().values());
		bean.getDataBean().setShortcuts(listShortcutsToShow);
	}

}
