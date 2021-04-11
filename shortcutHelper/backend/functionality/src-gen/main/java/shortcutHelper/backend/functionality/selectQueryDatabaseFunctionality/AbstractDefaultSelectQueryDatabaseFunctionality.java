package shortcutHelper.backend.functionality.selectQueryDatabaseFunctionality;

import shortcutHelper.backend.functionality.AbstractFunctionality;
import shortcutHelper.backend.logic.setClipboardLogic.IDefaultSetClipboardLogic;
import shortcutHelper.helper.databaseInformationHelper.IDatabaseInformationHelper;

public abstract class AbstractDefaultSelectQueryDatabaseFunctionality extends AbstractFunctionality implements IDefaultSelectQueryDatabaseFunctionality
{
	private IDefaultSetClipboardLogic setClipboardLogic;
	private IDatabaseInformationHelper databaseInformationHelper;
	
	public void setSetClipboardLogic(IDefaultSetClipboardLogic setClipboardLogic)
	{
		this.setClipboardLogic = setClipboardLogic;
	}
	
	public IDefaultSetClipboardLogic getSetClipboardLogic()
	{
		return this.setClipboardLogic;
	}
	public void setDatabaseInformationHelper(IDatabaseInformationHelper databaseInformationHelper)
	{
		this.databaseInformationHelper = databaseInformationHelper;
	}
	
	public IDatabaseInformationHelper getDatabaseInformationHelper()
	{
		return this.databaseInformationHelper;
	}
}
