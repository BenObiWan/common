package common.config.leaf;

import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.StringDisplayType;

/**
 * A configuration element handling a String value which cannot be changed.
 * 
 * @author benobiwan
 * 
 */
public final class LockedConfigurationString extends ConfigurationString
{
	// TODO real locking

	/**
	 * Creates a new LockedConfigurationString with a command line value.
	 * 
	 * @param parent
	 *            the parent of this configuration element.
	 * @param strName
	 *            the name of this configuration element.
	 * @param strShortDescription
	 *            the short description of this configuration element.
	 * @param strLongDescription
	 *            the long description of this configuration element.
	 * @param strInvalidMessage
	 *            the invalid message for this configuration element.
	 * @param bAdvanced
	 *            a boolean indicating whether this configuration element is
	 *            advanced.
	 * @param displayType
	 *            the display type of this configuration element.
	 * @param iMaxLength
	 *            the maximum length of the String.
	 * @param defaultValue
	 *            the default value of this configuration element.
	 * @param commandLineValue
	 *            the command line value of this configuration element.
	 * @throws InvalidConfigurationException
	 *             if the value specified on the command line is invalid.
	 */
	public LockedConfigurationString(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final StringDisplayType displayType,
			final int iMaxLength, final String defaultValue,
			final String commandLineValue) throws InvalidConfigurationException
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, iMaxLength,
				defaultValue, commandLineValue);
	}

	/**
	 * Creates a new LockedConfigurationString.
	 * 
	 * @param parent
	 *            the parent of this configuration element.
	 * @param strName
	 *            the name of this configuration element.
	 * @param strShortDescription
	 *            the short description of this configuration element.
	 * @param strLongDescription
	 *            the long description of this configuration element.
	 * @param strInvalidMessage
	 *            the invalid message for this configuration element.
	 * @param bAdvanced
	 *            a boolean indicating whether this configuration element is
	 *            advanced.
	 * @param displayType
	 *            the display type of this configuration element.
	 * @param iMaxLength
	 *            the maximum length of the String.
	 * @param defaultValue
	 *            the default value of this configuration element.
	 */
	public LockedConfigurationString(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final StringDisplayType displayType,
			final int iMaxLength, final String defaultValue)
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, iMaxLength,
				defaultValue);
	}

	@Override
	public boolean isLocked()
	{
		return true;
	}
}
