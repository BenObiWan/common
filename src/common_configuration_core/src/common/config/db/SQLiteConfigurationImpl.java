package common.config.db;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.StringDisplayType;
import common.config.leaf.ConfigurationString;

/**
 * An implementation of the {@link ISQLiteConfiguration} interface.
 * 
 * @author benobiwan
 *
 */
public final class SQLiteConfigurationImpl extends AbstractConfigurationBranch implements ISQLiteConfiguration
{
	/**
	 * Leaf configuring the database file name.
	 */
	private final ConfigurationString _leafDatabaseFileName;

	/**
	 * Short description for the database file name.
	 */
	private final static String DATABASE_FILE_NAME_SHORT_DESC = "Database file name";

	/**
	 * Long description for the database file name.
	 */
	private final static String DATABASE_FILE_NAME_LONG_DESC = "File name of the SQLite database.";

	/**
	 * Invalid message for the database file name.
	 */
	private final static String DATABASE_FILE_NAME_INVALID_MESSAGE = "Invalid file name for the database.";

	/**
	 * Creates a new SQLiteConfigurationImpl using default values for every
	 * elements.
	 * 
	 * @param parent
	 *            the parent configuration.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	public SQLiteConfigurationImpl(final IConfiguration parent, final MBeanServer mBeanServer)
	{
		super(parent, SQLITE_CONFIGURATION_TAG, mBeanServer);
		_leafDatabaseFileName = new ConfigurationString(this, DATABASE_FILE_NAME_TAG, DATABASE_FILE_NAME_SHORT_DESC,
				DATABASE_FILE_NAME_LONG_DESC, DATABASE_FILE_NAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"");
		addLeaf(_leafDatabaseFileName);
	}

	/**
	 * Creates a new SQLiteConfigurationImpl with values coming from the command
	 * line.
	 * 
	 * @param parent
	 *            the parent configuration.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param strCommandLineDatabaseFileName
	 *            the value specified on the command line for the database file
	 *            name.
	 * @throws InvalidConfigurationException
	 *             one of the given value is invalid.
	 */
	public SQLiteConfigurationImpl(final IConfiguration parent, final MBeanServer mBeanServer,
			final String strCommandLineDatabaseFileName) throws InvalidConfigurationException
	{
		super(parent, SQLITE_CONFIGURATION_TAG, mBeanServer);
		_leafDatabaseFileName = new ConfigurationString(this, DATABASE_FILE_NAME_TAG, DATABASE_FILE_NAME_SHORT_DESC,
				DATABASE_FILE_NAME_LONG_DESC, DATABASE_FILE_NAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"", strCommandLineDatabaseFileName);
		addLeaf(_leafDatabaseFileName);
	}

	/**
	 * Creates a new SQLiteConfigurationImpl with values coming from the command
	 * line and from a configuration file.
	 * 
	 * @param parent
	 *            the parent configuration.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 * @param strCommandLineDatabaseFileName
	 *            the value specified on the command line for the database file
	 *            name.
	 * @param strConfigurationDatabaseFileName
	 *            the value specified in the configuration file for the database
	 *            file name.
	 * @throws InvalidConfigurationException
	 *             one of the given value is invalid.
	 */
	public SQLiteConfigurationImpl(IConfiguration parent, MBeanServer mBeanServer,
			final String strCommandLineDatabaseFileName, final String strConfigurationDatabaseFileName)
			throws InvalidConfigurationException
	{
		this(parent, mBeanServer, strCommandLineDatabaseFileName);
		_leafDatabaseFileName.setConfigurationValue(strConfigurationDatabaseFileName);
	}

	@Override
	public String getDatabaseConnection()
	{
		return "jdbc:sqlite:" + _leafDatabaseFileName.getCurrentValue();
	}

	@Override
	public String getDatabaseFileName()
	{
		return _leafDatabaseFileName.getCurrentValue();
	}

	@Override
	public String getDescription()
	{
		return "Configuration for a SQLite database.";
	}

	@Override
	public String getDatabaseDriver()
	{
		return SQLITE_DRIVER;
	}

	@Override
	public int compareTo(IDatabaseConfiguration o)
	{
		if (o == null)
		{
			return 1;
		}
		int ret = getDatabaseDriver().compareTo(o.getDatabaseDriver());
		if (ret != 0)
		{
			ret = getDatabaseConnection().compareTo(o.getDatabaseConnection());
		}
		return ret;
	}
}
