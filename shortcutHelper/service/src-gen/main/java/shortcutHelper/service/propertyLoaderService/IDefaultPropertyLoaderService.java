package shortcutHelper.service.propertyLoaderService;
import shortcutHelper.service.Service;

public interface IDefaultPropertyLoaderService extends Service{
	public static final String BEAN_ID = "PropertyLoaderService";

    public void setReadPropertyAsLocal();


    public void setReadPropertyAsResource();

}