package common.config;

/**
 * An interface describing a Configuration.
 * 
 * @author benobiwan
 * 
 */
public interface IConfiguration
{
	/**
	 * Validate a name to check if it is suitable for a configuration.
	 * Essentially used in {@link IConfigurationList} to check for collision.
	 * 
	 * @param strName
	 *            the name to validate.
	 * @return true if the name is valid.
	 */
	boolean validateName(String strName);

	/**
	 * Get the name of this configuration.
	 * 
	 * @return the name of this configuration.
	 */
	String getName();

	/**
	 * Get the description of this configuration.
	 * 
	 * @return the description of this configuration.
	 */
	String getDescription();

	/**
	 * Lock this configuration. Also has an effect on children.
	 */
	void lock();

	/**
	 * Unlock this configuration.
	 */
	void unlock();

	/**
	 * Check whether this configuration is locked.
	 * 
	 * @return true if this configuration is locked.
	 */
	boolean isLocked();

	/**
	 * Update the current value of this configuration only if it is unlocked.
	 */
	void updateCurrentValue();
}
