package common.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import javax.management.MBeanServer;

/**
 * Abstract {@link IConfigurationLoader} which loads the configuration from an
 * property file.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractPropertyConfigurationLoader extends
		AbstractConfigurationLoader
{
	/**
	 * Map containing all the configuration parameters specified in the
	 * configuration file.
	 */
	protected final Properties _fileConf = new Properties();

	/**
	 * Creates a new {@link AbstractPropertyConfigurationLoader} without reading
	 * from a property file.
	 * 
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractPropertyConfigurationLoader(final MBeanServer mBeanServer)
	{
		super(mBeanServer);
	}

	/**
	 * Creates a new {@link AbstractPropertyConfigurationLoader} reading from an
	 * {@link InputStream}.
	 * 
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param inStream
	 *            the {@link InputStream} from which to read.
	 * @param bXML
	 *            true if the input file is an XML property file.
	 * @throws IOException
	 *             if an error occurred when reading from the input stream.
	 */
	protected AbstractPropertyConfigurationLoader(
			final MBeanServer mBeanServer, final InputStream inStream,
			final boolean bXML) throws IOException
	{
		super(mBeanServer);
		if (bXML)
		{
			_fileConf.load(inStream);
		}
		else
		{
			_fileConf.loadFromXML(inStream);
		}
	}

	/**
	 * Creates a new {@link AbstractPropertyConfigurationLoader} reading from a
	 * {@link Reader}.
	 * 
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param reader
	 *            the {@link Reader} from which to read.
	 * @throws IOException
	 *             if an error occurred when reading from the input stream.
	 */
	protected AbstractPropertyConfigurationLoader(
			final MBeanServer mBeanServer, final Reader reader)
			throws IOException
	{
		super(mBeanServer);
		_fileConf.load(reader);
	}
}
