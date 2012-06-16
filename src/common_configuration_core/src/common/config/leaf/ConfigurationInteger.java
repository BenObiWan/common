package common.config.leaf;

import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.IntegerDisplayType;

/**
 * A configuration element handling a integer value.
 * 
 * @author benobiwan
 * 
 */
public final class ConfigurationInteger extends
		AbstractConfigurationNumber<Integer, IntegerDisplayType>
{
	/**
	 * Creates a new ConfigurationInteger with a command line value.
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
	 * @param minValue
	 *            the minimum value of this configuration element.
	 * @param maxValue
	 *            the maximum value of this configuration element.
	 * @param defaultValue
	 *            the default value of this configuration element.
	 * @param commandLineValue
	 *            the command line value of this configuration element.
	 * @throws InvalidConfigurationException
	 *             if the value specified on the command line is invalid.
	 */
	public ConfigurationInteger(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final IntegerDisplayType displayType,
			final Integer minValue, final Integer maxValue,
			final Integer defaultValue, final Integer commandLineValue)
			throws InvalidConfigurationException
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, minValue, maxValue,
				defaultValue, commandLineValue);
	}

	/**
	 * Creates a new ConfigurationInteger.
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
	 * @param minValue
	 *            the minimum value of this configuration element.
	 * @param maxValue
	 *            the maximum value of this configuration element.
	 * @param defaultValue
	 *            the default value of this configuration element.
	 */
	public ConfigurationInteger(final IConfiguration parent,
			final String strName, final String strShortDescription,
			final String strLongDescription, final String strInvalidMessage,
			final boolean bAdvanced, final IntegerDisplayType displayType,
			final Integer minValue, final Integer maxValue,
			final Integer defaultValue)
	{
		super(parent, strName, strShortDescription, strLongDescription,
				strInvalidMessage, bAdvanced, displayType, minValue, maxValue,
				defaultValue);
	}

	@Override
	public boolean validateValue(final Integer value)
	{
		return (value == null)
				|| ((_minValue == null || (value.intValue() >= _minValue
						.intValue())) && (_maxValue == null || (value
						.intValue() <= _maxValue.intValue())));
	}
}
