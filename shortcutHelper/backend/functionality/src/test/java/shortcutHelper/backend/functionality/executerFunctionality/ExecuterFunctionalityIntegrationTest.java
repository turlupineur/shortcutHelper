package shortcutHelper.backend.functionality.executerFunctionality;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.backend.functionality.FunctionalityIntegrationTesting;
import shortcutHelper.backend.functionality.copyToClipboardFunctionality.IDefaultCopyToClipboardFunctionality;
import shortcutHelper.backendCommon.ShortcutHelperContext;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class ExecuterFunctionalityIntegrationTest extends FunctionalityIntegrationTesting {
	@Autowired
	private IDefaultExecuterFunctionality executerFunctionality;

	@Test
	public void variableAutomaticallyReplaced() {

		setClibpoard("coucou");

		setVariable("helloworld", "bonjour");

		ExecuterFunctionalityDataContainer container = new ExecuterFunctionalityDataContainer();
		ShortcutHelperContext context = new ShortcutHelperContext();
		container.setShortcutHelperContext(context);
		IShortcut shortcut = createShortcut(IDefaultCopyToClipboardFunctionality.class, "${helloworld}");
		container.setShortcutToExecute(shortcut);

		executerFunctionality.run(container);

		assertThat(getClipboard(), is("bonjour"));
	}
}
