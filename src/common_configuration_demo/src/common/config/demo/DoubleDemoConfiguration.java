package common.config.demo;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.display.DoubleDisplayType;
import common.config.leaf.ConfigurationDouble;

/**
 * Configuration demo using Double values.
 * 
 * @author benobiwan
 * 
 */
public final class DoubleDemoConfiguration extends AbstractConfigurationBranch
{
	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationDouble _leafSpinner;

	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationDouble _leafTextField;

	/**
	 * Creates a new DoubleDemoConfiguration.
	 * 
	 * @param parent
	 *            the parent of this configuration.
	 * @param mBeanServer
	 *            the mBeanServer to use in this configuration.
	 */
	public DoubleDemoConfiguration(final IConfiguration parent,
			final MBeanServer mBeanServer)
	{
		super(parent, "Float configuration demo", mBeanServer);
		_leafSpinner = new ConfigurationDouble(this, "Spinner demo",
				"Spinner demo", "Spinner demo.", "Invalid spinner demo value",
				false, DoubleDisplayType.SPINNER, Double.valueOf(1024),
				Double.valueOf(65535), Double.valueOf(1664));
		addLeaf(_leafSpinner);

		_leafTextField = new ConfigurationDouble(this, "Text field demo",
				"Text field demo", "Text field demo.",
				"Invalid text field demo value", false,
				DoubleDisplayType.TEXTFIELD, Double.valueOf(1024),
				Double.valueOf(65535), Double.valueOf(1664));
		addLeaf(_leafTextField);
	}

	@Override
	public String getDescription()
	{
		return "Demo for the double configuration.";
	}
}
