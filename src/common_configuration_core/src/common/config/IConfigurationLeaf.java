package common.config;

/**
 * Interface describing a leaf of the configuration tree. It holds the different
 * values of a parameter : on the interface, on the command line, in the
 * configuration, the default one and the current one.
 * 
 * The value can be locked to prevent the current value from being modified. If
 * one of the parent configuration node is locked, the value is considered
 * locked.
 * 
 * When unlocked, the current value depends of which values are set. The order
 * is as followed : Interface value -> command line value -> configuration value
 * -> default value.
 * 
 * @author benobiwan
 * 
 * @param <TYPE>
 *            the type of the value described by this leaf.
 * @param <DISP_TYPE>
 *            the display type of the value described by this leaf.
 */
public interface IConfigurationLeaf<TYPE, DISP_TYPE extends Enum<DISP_TYPE>>
		extends IConfiguration, Comparable<IConfigurationLeaf<TYPE, DISP_TYPE>>
{
	/**
	 * Validate whether the specified value of this configuration element is
	 * correct.
	 * 
	 * @param value
	 *            the value to validate.
	 * @return true if this value is correct.
	 */
	boolean validateValue(TYPE value);

	/**
	 * Get the long description of this configuration element.
	 * 
	 * @return the long description of this configuration element.
	 */
	String getLongDescription();

	/**
	 * Get the display type of this configuration element.
	 * 
	 * @return the display type of this configuration element.
	 */
	DISP_TYPE getDisplayType();

	/**
	 * Get the message used in the exception when trying to set this
	 * configuration element to a forbidden value.
	 * 
	 * @return the message used in the exception when trying to set this
	 *         configuration element to a forbidden value.
	 */
	String getInvalidMessage();

	/**
	 * Get the current value of this configuration element.
	 * 
	 * @return the current value of this configuration element.
	 */
	TYPE getCurrentValue();

	/**
	 * Get the value specified in the configuration file for this configuration
	 * element.
	 * 
	 * @return the value specified in the configuration file for this
	 *         configuration element.
	 */
	TYPE getConfigurationValue();

	/**
	 * Change the value specified in the configuration file for this
	 * configuration element.
	 * 
	 * @param configurationValue
	 *            the new value.
	 * @throws InvalidConfigurationException
	 *             if the new value is invalid.
	 */
	void setConfigurationValue(TYPE configurationValue)
			throws InvalidConfigurationException;

	/**
	 * Get the value specified in the interface for this configuration element.
	 * 
	 * @return the value specified in the interface for this configuration
	 *         element.
	 */
	TYPE getInterfaceValue();

	/**
	 * Change the value specified in the interface for this configuration
	 * element.
	 * 
	 * @param interfaceValue
	 *            the new value.
	 * @throws InvalidConfigurationException
	 *             if the new value is invalid.
	 */
	void setInterfaceValue(TYPE interfaceValue)
			throws InvalidConfigurationException;

	/**
	 * Get the value specified on the command line for this configuration
	 * element.
	 * 
	 * @return the value specified on the command line for this configuration
	 *         element.
	 */
	TYPE getCommandLineValue();

	/**
	 * Get the default value of this configuration element.
	 * 
	 * @return the default value of this configuration element.
	 */
	TYPE getDefaultValue();

	/**
	 * Check whether this configuration element is advanced.
	 * 
	 * @return true if this configuration element is advanced.
	 */
	boolean isAdvanced();

	/**
	 * Set the configuration value to the current value.
	 */
	public void setConfToCurrent();

	/**
	 * Set the configuration file value to the default value.
	 */
	public void setConfToDefault();

	/**
	 * Set the interface value to the default value.
	 */
	public void setInterfaceToDefault();

	/**
	 * Set the interface value to the configuration file value.
	 */
	public void setInterfaceToConf();

	/**
	 * Check whether the configuration file value has changed.
	 * 
	 * @return true if the configuration file value has changed.
	 */
	public boolean hasConfChanged();
}
