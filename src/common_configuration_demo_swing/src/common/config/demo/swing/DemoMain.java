package common.config.demo.swing;

import java.awt.HeadlessException;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import common.config.demo.FloatDemoConfiguration;
import common.config.demo.IntegerDemoConfiguration;
import common.config.swing.ConfigurationPanel;

public final class DemoMain extends JFrame
{

	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -1271806634110676749L;

	public DemoMain() throws HeadlessException
	{
		super("Configuration demo");
		final MBeanServer beanServer = ManagementFactory
				.getPlatformMBeanServer();

		final JTabbedPane contentPane = new JTabbedPane();
		contentPane.addTab("Integer", new ConfigurationPanel(
				new IntegerDemoConfiguration(null, beanServer)));
		contentPane.addTab("Float", new ConfigurationPanel(
				new FloatDemoConfiguration(null, beanServer)));

		setContentPane(contentPane);
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
