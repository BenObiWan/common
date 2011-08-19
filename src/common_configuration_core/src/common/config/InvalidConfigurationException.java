package common.config;

/**
 * An Exception warning that the configuration is invalid.
 * 
 * @author benobiwan
 * 
 */
public final class InvalidConfigurationException extends Exception
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 7767349194202713454L;

	/**
	 * Message used when one of the parameters is invalid and the configuration
	 * can't be saved.
	 */
	public static final String INVALID_PARAMETER = "Invalid parameter, can't save to Configuration.";

	/**
	 * Create a new InvalidConfigurationException.
	 */
	public InvalidConfigurationException()
	{
		super();
	}

	/**
	 * Create a new InvalidConfigurationException with the specified message.
	 * 
	 * @param message
	 *            the message associated to this InvalidConfigurationException.
	 */
	public InvalidConfigurationException(final String message)
	{
		super(message);
	}

	/**
	 * Create a new InvalidConfigurationException with the specified cause.
	 * 
	 * @param cause
	 *            the cause for this InvalidConfigurationException.
	 */
	public InvalidConfigurationException(final Throwable cause)
	{
		super(cause);
	}

	/**
	 * Create a new InvalidConfigurationException with the specified message and
	 * cause.
	 * 
	 * @param message
	 *            the message associated to this InvalidConfigurationException.
	 * @param cause
	 *            the cause for this InvalidConfigurationException.
	 */
	public InvalidConfigurationException(final String message,
			final Throwable cause)
	{
		super(message, cause);
	}

}
