package shortcutHelper.backend.dynamicCommand.setStorageOnTheFlyDynamicCommand;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shortcutHelper.backend.dynamicCommand.DynamicCommandIntegrationTesting;
import shortcutHelper.backend.dynamicCommand.DynamicCommandShortcutRepository;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.IDefaultSetStorageOnTheFlyFunctionality;
import shortcutHelper.backend.functionality.setStorageOnTheFlyFunctionality.data.SetStorageOnTheFlyOperation;
import shortcutHelper.common.properties.StaticApplicationProperptyHolder;
import shortcutHelper.helper.shortcutFactoryHelper.IShortcut;

public class SetStorageOnTheFlyDynamicCommandIntegrationTest extends DynamicCommandIntegrationTesting {
	@Autowired
	private ISetStorageOnTheFlyDynamicCommand setStorageOnTheFlyDynamicCommand;

	@Test
	public void shortcutAreCreatedCorrectly() {
		setOuputFolderForStorageToTempFolder();
		setClibpoard("dynamicCommand");
		String name = "dynamicCommandName";

		runFunctionality(IDefaultSetStorageOnTheFlyFunctionality.class,
				new String[] { name, SetStorageOnTheFlyOperation.SET.toString() });

		DynamicCommandShortcutRepository repository = new DynamicCommandShortcutRepository();

		setStorageOnTheFlyDynamicCommand.run(repository);

		System.out.println("salut");

		assertThat(repository.getNbShortcutsAdded(), is(3));
		assertThat(repository.getNbShortcutsRemoved(), is(0));

		IShortcut set = repository.getShortcutsToAdd().get("set." + name);
		IShortcut get = repository.getShortcutsToAdd().get("get." + name);
		IShortcut delete = repository.getShortcutsToAdd().get("delete." + name);

		assertThat(set.getBeanName(), is(IDefaultSetStorageOnTheFlyFunctionality.BEAN_ID));
		assertThat(get.getBeanName(), is(IDefaultSetStorageOnTheFlyFunctionality.BEAN_ID));
		assertThat(delete.getBeanName(), is(IDefaultSetStorageOnTheFlyFunctionality.BEAN_ID));

		assertThat(set.getParams().length, is(2));
		assertThat(get.getParams().length, is(2));
		assertThat(delete.getParams().length, is(2));

		assertThat(set.getParams()[0], is(name));
		assertThat(get.getParams()[0], is(name));
		assertThat(delete.getParams()[0], is(name));

		assertThat(set.getParams()[1], is(SetStorageOnTheFlyOperation.SET.toString()));
		assertThat(get.getParams()[1], is(SetStorageOnTheFlyOperation.GET.toString()));
		assertThat(delete.getParams()[1], is(SetStorageOnTheFlyOperation.DELETE.toString()));

	}

	public void setOuputFolderForStorageToTempFolder() {
		StaticApplicationProperptyHolder.getProperties().getShortcutHelper().getFunctionality().getSetStorageOnTheFly()
				.setStorageFolder(getTempFolder());
		StaticApplicationProperptyHolder.getProperties().getShortcutHelper().getService().getStringStorageService()
				.setTargetFolder(getTempFolder());
	}
}
