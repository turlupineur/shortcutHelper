package shortcutHelper.logging;

public class ShortcutHelperLogging {
	public static void logDebug(Object o)
	{
		System.out.println(o);
	}
	
	public static void logDebug(String str)
	{
		System.out.println(str);
	}
	
	public static void logDebug(Throwable t)
	{
		t.printStackTrace();
	}
	public static void logInfo(Object o)
	{
		System.out.println(o);
	}
	
	public static void logInfo(String str)
	{
		System.out.println(str);
	}
	
	public static void logInfo(Throwable t)
	{
		t.printStackTrace();
	}
	public static void logWarning(Object o)
	{
		System.out.println(o);
	}
	
	public static void logWarning(String str)
	{
		System.out.println(str);
	}
	
	public static void logWarning(Throwable t)
	{
		t.printStackTrace();
	}
	public static void logError(Object o)
	{
		System.out.println(o);
	}
	
	public static void logError(String str)
	{
		System.out.println(str);
	}
	
	public static void logError(Throwable t)
	{
		t.printStackTrace();
	}
}
