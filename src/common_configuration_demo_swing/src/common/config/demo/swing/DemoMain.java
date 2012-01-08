package common.config.demo.swing;

import java.awt.HeadlessException;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import common.config.demo.DoubleDemoConfiguration;
import common.config.demo.FloatDemoConfiguration;
import common.config.demo.IntegerDemoConfiguration;
import common.config.swing.ConfigurationPanel;

/**
 * Main frame for the configuration demo. Creates a panel for each demo
 * configuration and displays them in tabs.
 * 
 * @author benobiwan
 * 
 */
public final class DemoMain extends JFrame
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -1271806634110676749L;

	/**
	 * Creates a new DemoMain.
	 * 
	 * @throws HeadlessException
	 *             if GraphicsEnvironment.isHeadless() returns true.
	 */
	public DemoMain() throws HeadlessException
	{
		super("Configuration demo");
		final MBeanServer beanServer = ManagementFactory
				.getPlatformMBeanServer();

		final JTabbedPane contentPane = new JTabbedPane();
		setContentPane(contentPane);

		contentPane.addTab("Integer", new ConfigurationPanel(
				new IntegerDemoConfiguration(null, beanServer), true));
		contentPane.addTab("Float", new ConfigurationPanel(
				new FloatDemoConfiguration(null, beanServer), true));
		contentPane.addTab("Double", new ConfigurationPanel(
				new DoubleDemoConfiguration(null, beanServer), true));

	}

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final DemoMain frame = new DemoMain();
		frame.pack();
		frame.setVisible(true);
	}

}
