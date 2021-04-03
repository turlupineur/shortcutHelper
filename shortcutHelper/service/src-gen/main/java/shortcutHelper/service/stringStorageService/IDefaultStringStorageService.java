package shortcutHelper.service.stringStorageService;
import shortcutHelper.service.Service;

public interface IDefaultStringStorageService extends Service{
	public static final String BEAN_ID = "StringStorageService";

    public void storeString(String owner,String vName,String str);


    public String readString(String owner,String vName);


    public boolean deleteString(String owner,String vName);


    public boolean stringIsStored(String owner,String vName);


    public boolean deleteAllStringForOwner(String owner);


    public java.util.List<String> listAllStorageForOwner(String owner);

}