package common.config.leaf;

import common.config.AbstractConfigurationLeaf;
import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.EnumDisplayType;

/**
 * A configuration element handling a {@link Enum} value.
 * 
 * @author benobiwan
 * 
 * @param <TYPE>
 *            the type of {@link Enum} this configuration element.
 */
public final class ConfigurationEnum<TYPE extends Enum<TYPE>> extends
		AbstractConfigurationLeaf<TYPE, EnumDisplayType>
{
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
	public ConfigurationEnum(final IConfiguration parent, final String strName,
			final String strShortDescription, final String strLongDescription,
			final String strInvalidMessage, final boolean bAdvanced,
			final EnumDisplayType displayType, final TYPE defaultValue,
			final TYPE commandLineValue) throws InvalidConfigurationException
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, defaultValue,
				commandLineValue);
	}

	/**
	 * Creates a new ConfigurationEnum.
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
	public ConfigurationEnum(final IConfiguration parent, final String strName,
			final String strShortDescription, final String strLongDescription,
			final String strInvalidMessage, final boolean bAdvanced,
			final EnumDisplayType displayType, final TYPE defaultValue)
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, defaultValue);
	}

	@Override
	public boolean validateValue(final TYPE value)
	{
		return true;
	}
}
