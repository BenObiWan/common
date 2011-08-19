package common.config;

import java.util.Map;
import java.util.Properties;

import javax.management.MBeanServer;

/**
 * Abstract {@link IConfigurationLoader} which loads the configuration from the
 * command line.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConfigurationLoader implements
		IConfigurationLoader
{
	/**
	 * Map containing all the configuration parameters specified on the command
	 * line and relative to this {@link IConfigurationLoader}.
	 */
	protected final Properties _commandLineConf;

	/**
	 * The {@link MBeanServer} to use.
	 */
	protected final MBeanServer _mBeanServer;

	/**
	 * Creates a new AbstractConfigurationLoader.
	 * 
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractConfigurationLoader(final MBeanServer mBeanServer)
	{
		_commandLineConf = filterSystemConf();
		_mBeanServer = mBeanServer;
	}

	/**
	 * Get all the command line parameters concerning the configurations loaded
	 * by this object.
	 * 
	 * @return all the command line parameters concerning the configurations
	 *         loaded by this object.
	 */
	protected final Properties filterSystemConf()
	{
		final Properties res = new Properties();
		for (final Map.Entry<Object, Object> entry : System.getProperties()
				.entrySet())
		{
			if (entry.getKey() instanceof String
					&& entry.getValue() instanceof String)
			{
				final String key = (String) entry.getKey();
				if (key.startsWith(getFullCommandLinePrefix()))
				{
					key.replace(getFullCommandLinePrefix(), "");
					res.put(key, entry.getValue());
				}
			}
		}
		return res;
	}

	/**
	 * Read a String from a property.
	 * 
	 * @param prop
	 *            the property to read the String from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static String readStringFromProperty(final Properties prop,
			final String strPropName)
	{
		return prop.getProperty(strPropName);
	}

	/**
	 * Read a Boolean from a property.
	 * 
	 * @param prop
	 *            the property to read the Boolean from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static Boolean readBooleanFromProperty(
			final Properties prop, final String strPropName)
	{
		final String strProp = prop.getProperty(strPropName);
		if (strProp == null)
		{
			return null;
		}
		return Boolean.valueOf(strProp);
	}

	/**
	 * Read an Integer from a property.
	 * 
	 * @param prop
	 *            the property to read the Integer from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static Integer readIntegerFromProperty(
			final Properties prop, final String strPropName)
	{
		final String strProp = prop.getProperty(strPropName);
		if (strProp == null)
		{
			return null;
		}
		return Integer.valueOf(strProp);
	}

	/**
	 * Read a Long from a property.
	 * 
	 * @param prop
	 *            the property to read the Long from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static Long readLongFromProperty(final Properties prop,
			final String strPropName)
	{
		final String strProp = prop.getProperty(strPropName);
		if (strProp == null)
		{
			return null;
		}
		return Long.valueOf(strProp);
	}

	/**
	 * Read a Float from a property.
	 * 
	 * @param prop
	 *            the property to read the Float from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static Float readFloatFromProperty(final Properties prop,
			final String strPropName)
	{
		final String strProp = prop.getProperty(strPropName);
		if (strProp == null)
		{
			return null;
		}
		return Float.valueOf(strProp);
	}

	/**
	 * Read a Double from a property.
	 * 
	 * @param prop
	 *            the property to read the Double from.
	 * @param strPropName
	 *            the name of the property to get.
	 * @return the wanted property.
	 */
	protected final static Double readDoubleFromProperty(final Properties prop,
			final String strPropName)
	{
		final String strProp = prop.getProperty(strPropName);
		if (strProp == null)
		{
			return null;
		}
		return Double.valueOf(strProp);
	}
}
