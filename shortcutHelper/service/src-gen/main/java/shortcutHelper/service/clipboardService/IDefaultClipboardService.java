package shortcutHelper.service.clipboardService;
import shortcutHelper.service.Service;

public interface IDefaultClipboardService extends Service{
	public static final String BEAN_ID = "ClipboardService";

    public void setClipboard(String value);


    public String getClipboard();

}