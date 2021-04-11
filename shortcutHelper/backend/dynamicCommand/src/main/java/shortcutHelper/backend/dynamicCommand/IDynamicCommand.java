package shortcutHelper.backend.dynamicCommand;

public interface IDynamicCommand {
	/**
	 * General Interface for dynamic command. Implementing this command will
	 * automatically (through bean) add the class to the list of dynamic commands to
	 * execute. Create or deleted shortcuts should only be added/removed through the
	 * given repository.
	 * 
	 * @param dynamicCommandShortcutRepository
	 */
	public void run(DynamicCommandShortcutRepository dynamicCommandShortcutRepository);
}
