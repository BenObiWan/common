package common.config.leaf;

import common.config.AbstractConfigurationLeaf;
import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.BooleanDisplayType;

/**
 * A configuration element handling a boolean value.
 * 
 * @author benobiwan
 * 
 */
public final class ConfigurationBoolean extends
		AbstractConfigurationLeaf<Boolean, BooleanDisplayType>
{
	/**
	 * Creates a new ConfigurationBoolean.
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
	 * @param defaultValue
	 *            the default value of this configuration element.
	 */
	public ConfigurationBoolean(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final BooleanDisplayType displayType,
			final Boolean defaultValue)
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, defaultValue);
	}

	/**
	 * Creates a new ConfigurationBoolean with a command line value.
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
	 * @param defaultValue
	 *            the default value of this configuration element.
	 * @param commandLineValue
	 *            the command line value of this configuration element.
	 * @throws InvalidConfigurationException
	 *             if the value specified on the command line is invalid.
	 */
	public ConfigurationBoolean(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final BooleanDisplayType displayType,
			final Boolean defaultValue, final Boolean commandLineValue)
			throws InvalidConfigurationException
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, defaultValue,
				commandLineValue);
	}

	@Override
	public boolean validateValue(final Boolean value)
	{
		return true;
	}
}
