package common.config;

import javax.management.MBeanServer;

/**
 * Abstract {@link IConfigurationLoader} which loads the configuration from an
 * XML file.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractXMLFileConfigurationLoader extends
		AbstractConfigurationLoader
{
	/**
	 * Creates a new AbstractXMLFileConfigurationLoader.
	 * 
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractXMLFileConfigurationLoader(final MBeanServer mBeanServer)
	{
		super(mBeanServer);
	}
	// TODO code of AbstractXMLFileConfigurationLoader
}
