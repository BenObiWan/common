package common.config;

import javax.management.MBeanServer;

/**
 * An abstract implementation of the {@link IConfigurationListElement}
 * interface.
 * 
 * @author benobiwan
 * @param <ELT>
 *            The type of {@linkIConfigurationListElement} which will be used in
 *            the comparator.
 */
public abstract class AbstractConfigurationListElement<ELT extends IConfigurationListElement<ELT>>
		extends AbstractConfigurationNode implements
		IConfigurationListElement<ELT>
{
	/**
	 * Creates a new AbstractConfigurationListElement.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationListElement.
	 * @param strName
	 *            the name of this AbstractConfigurationListElement.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractConfigurationListElement(final IConfiguration parent,
			final String strName, final MBeanServer mBeanServer)
	{
		super(parent, strName, mBeanServer);
	}

	@Override
	public final String getId()
	{
		return _strName;
	}
}
