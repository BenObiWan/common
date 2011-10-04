package common.config.demo;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.display.FloatDisplayType;
import common.config.leaf.ConfigurationFloat;

/**
 * Configuration demo using Float values.
 * 
 * @author benobiwan
 * 
 */
public final class FloatDemoConfiguration extends AbstractConfigurationBranch
{
	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationFloat _leafSpinner;

	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationFloat _leafTextField;

	/**
	 * Creates a new FloatDemoConfiguration.
	 * 
	 * @param parent
	 *            the parent of this configuration.
	 * @param mBeanServer
	 *            the mBeanServer to use in this configuration.
	 */
	public FloatDemoConfiguration(final IConfiguration parent,
			final MBeanServer mBeanServer)
	{
		super(parent, "Float configuration demo", mBeanServer);
		_leafSpinner = new ConfigurationFloat(this, "Spinner demo",
				"Spinner demo", "Spinner demo.", "Invalid spinner demo value",
				false, FloatDisplayType.SPINNER, Float.valueOf(1024),
				Float.valueOf(65535), Float.valueOf(1664));
		addLeaf(_leafSpinner);

		_leafTextField = new ConfigurationFloat(this, "Text field demo",
				"Text field demo", "Text field demo.",
				"Invalid text field demo value", false,
				FloatDisplayType.TEXTFIELD, Float.valueOf(1024),
				Float.valueOf(65535), Float.valueOf(1664));
		addLeaf(_leafTextField);
	}

	@Override
	public String getDescription()
	{
		return "Demo for the float configuration.";
	}
}
