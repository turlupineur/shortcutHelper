package shortcutHelper.main;

import shortcutHelper.middleend.controller.IMainInterfaceController;
import shortcutHelper.middleend.controller.MainInterfaceController;

public class ShortcutHelperMain {

	
	public static void main(String[] args) {
		loadBeans();
		IMainInterfaceController controller = new MainInterfaceController();
		controller.showInterface();
	}
	private static void loadBeans()
	{
		
	}
}
