package common.config;

import javax.management.MBeanServer;

/**
 * An abstract implementation of the {@link IConfigurationBranch} interface.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConfigurationBranch extends
		AbstractConfigurationNode implements IConfigurationBranch
{
	/**
	 * Creates a new AbstractConfigurationBranch.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationBranch.
	 * @param strName
	 *            the name of this AbstractConfigurationBranch.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	public AbstractConfigurationBranch(final IConfiguration parent,
			final String strName, final MBeanServer mBeanServer)
	{
		super(parent, strName, mBeanServer);
	}
}
