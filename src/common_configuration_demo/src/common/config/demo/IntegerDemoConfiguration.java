package common.config.demo;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.display.IntegerDisplayType;
import common.config.leaf.ConfigurationInteger;

public final class IntegerDemoConfiguration extends AbstractConfigurationBranch
{
	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationInteger _leafSpinner;

	/**
	 * Creates a new IntegerDemoConfiguration.
	 * 
	 * @param parent
	 *            the parent of this configuration.
	 * @param mBeanServer
	 *            the mBeanServer to use in this configuration.
	 */
	public IntegerDemoConfiguration(final IConfiguration parent,
			final MBeanServer mBeanServer)
	{
		super(parent, "Integer configuration demo", mBeanServer);
		_leafSpinner = new ConfigurationInteger(this, "Spinner demo",
				"Spinner demo", "Spinner demo.", "Invalid spinner demo value",
				false, IntegerDisplayType.SPINNER, Integer.valueOf(1024),
				Integer.valueOf(65535), Integer.valueOf(1664));

		addLeaf(_leafSpinner);
	}

	@Override
	public String getDescription()
	{
		return "Demo for the integer configuration.";
	}
}
