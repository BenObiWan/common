package common.config.demo;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.display.IntegerDisplayType;
import common.config.leaf.ConfigurationInteger;

/**
 * Configuration demo using Integer values.
 * 
 * @author benobiwan
 * 
 */
public final class IntegerDemoConfiguration extends AbstractConfigurationBranch
{
	/**
	 * Leaf configuring a spinner.
	 */
	private final ConfigurationInteger _leafSpinner;

	/**
	 * Leaf configuring a slider.
	 */
	private final ConfigurationInteger _leafSlider;

	/**
	 * Leaf configuring a text field.
	 */
	private final ConfigurationInteger _leafTextField;

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

		_leafSlider = new ConfigurationInteger(this, "Slider demo",
				"Slider demo", "Slider demo.", "Invalid slider demo value",
				false, IntegerDisplayType.SLIDER, Integer.valueOf(1024),
				Integer.valueOf(65535), Integer.valueOf(1664));
		addLeaf(_leafSlider);

		_leafTextField = new ConfigurationInteger(this, "Text field demo",
				"Slider demo", "Slider demo.", "Invalid slider demo value",
				false, IntegerDisplayType.TEXTFIELD, Integer.valueOf(1024),
				Integer.valueOf(65535), Integer.valueOf(1664));
		addLeaf(_leafTextField);
	}

	@Override
	public String getDescription()
	{
		return "Demo for the integer configuration.";
	}
}
