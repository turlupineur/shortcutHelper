package shortcutHelper.helper.shortcutFactoryHelper;

/**
 * Represents an immutable Shortcut. An instance of this interface guarantees
 * that the shortcut is executable. It does not guarantees that the number of
 * params given is correct.
 * 
 * @author jsvaillant
 *
 */
public interface IShortcut {
	/**
	 * Gets the interface representing the command. Should always points to
	 * Interface.
	 * 
	 * @return
	 */
	public Class getClassRepresentingCommand();

	/**
	 * 
	 * @return
	 */
	public String getBeanName();

	/**
	 * Gets the parameters for this Shortcut.
	 * 
	 * @return
	 */
	public String[] getParams();

	/**
	 * Returns the name of the shortcut. This property is optional if the Shortcut
	 * is created through the code.
	 * 
	 * @return
	 */
	public String getName();

}
