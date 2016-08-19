package common.config.db;

import javax.management.MBeanServer;

import common.config.AbstractConfigurationBranch;
import common.config.IConfiguration;
import common.config.InvalidConfigurationException;
import common.config.display.IntegerDisplayType;
import common.config.display.StringDisplayType;
import common.config.leaf.ConfigurationInteger;
import common.config.leaf.ConfigurationString;

public final class MysqlConfigurationImpl extends AbstractConfigurationBranch implements IMysqlConfiguration
{
	/**
	 * Leaf configuring the database server.
	 */
	private final ConfigurationString _leafDatabaseServer;

	/**
	 * Short description for the database server.
	 */
	private final static String DATABASE_SERVER_SHORT_DESC = "Database server";

	/**
	 * Long description for the database server.
	 */
	private final static String DATABASE_SERVER_LONG_DESC = "Address of the Mysql server.";

	/**
	 * Invalid message for the database server.
	 */
	private final static String DATABASE_SERVER_INVALID_MESSAGE = "Invalid address for the Mysql server.";

	/**
	 * Leaf configuring the database port.
	 */
	private final ConfigurationInteger _leafDatabasePort;

	/**
	 * Short description for the database port.
	 */
	private final static String DATABASE_PORT_SHORT_DESC = "Database port";

	/**
	 * Long description for the database port.
	 */
	private final static String DATABASE_PORT_LONG_DESC = "TCP port of the Mysql server.";

	/**
	 * Invalid message for the database port.
	 */
	private final static String DATABASE_PORT_INVALID_MESSAGE = "Invalid TCP port for the Mysql server.";

	/**
	 * Leaf configuring the database name.
	 */
	private final ConfigurationString _leafDatabaseName;

	/**
	 * Short description for the database name.
	 */
	private final static String DATABASE_NAME_SHORT_DESC = "Database name";

	/**
	 * Long description for the database name.
	 */
	private final static String DATABASE_NAME_LONG_DESC = "Name of the database.";

	/**
	 * Invalid message for the database name.
	 */
	private final static String DATABASE_NAME_INVALID_MESSAGE = "Invalid name for the database.";

	/**
	 * Leaf configuring the database username.
	 */
	private final ConfigurationString _leafDatabaseUsername;

	/**
	 * Short description for the database username.
	 */
	private final static String DATABASE_USERNAME_SHORT_DESC = "Database username";

	/**
	 * Long description for the database username.
	 */
	private final static String DATABASE_USERNAME_LONG_DESC = "Username to connect to the Mysql database.";

	/**
	 * Invalid message for the database username.
	 */
	private final static String DATABASE_USERNAME_INVALID_MESSAGE = "Invalid username for the database connection.";

	/**
	 * Leaf configuring the database password.
	 */
	private final ConfigurationString _leafDatabasePassword;

	/**
	 * Short description for the database password.
	 */
	private final static String DATABASE_PASSWORD_SHORT_DESC = "Database password";

	/**
	 * Long description for the database password.
	 */
	private final static String DATABASE_PASSWORD_LONG_DESC = "Password to connect to the Mysql database.";

	/**
	 * Invalid message for the database password.
	 */
	private final static String DATABASE_PASSWORD_INVALID_MESSAGE = "Invalid password to connect to the Mysql database.";

	public MysqlConfigurationImpl(final IConfiguration parent, final MBeanServer mBeanServer)
	{
		super(parent, MYSQL_CONFIGURATION_TAG, mBeanServer);
		_leafDatabaseServer = new ConfigurationString(this, DATABASE_SERVER_TAG, DATABASE_SERVER_SHORT_DESC,
				DATABASE_SERVER_LONG_DESC, DATABASE_SERVER_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"localhost");
		_leafDatabasePort = new ConfigurationInteger(this, DATABASE_PORT_TAG, DATABASE_PORT_SHORT_DESC,
				DATABASE_PORT_LONG_DESC, DATABASE_PORT_INVALID_MESSAGE, true, IntegerDisplayType.SPINNER,
				Integer.valueOf(1), Integer.valueOf(65535), Integer.valueOf(3306));
		_leafDatabaseName = new ConfigurationString(this, DATABASE_NAME_TAG, DATABASE_NAME_SHORT_DESC,
				DATABASE_NAME_LONG_DESC, DATABASE_NAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0, "");
		_leafDatabaseUsername = new ConfigurationString(this, DATABASE_USERNAME_TAG, DATABASE_USERNAME_SHORT_DESC,
				DATABASE_USERNAME_LONG_DESC, DATABASE_USERNAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"");
		_leafDatabasePassword = new ConfigurationString(this, DATABASE_PASSWORD_TAG, DATABASE_PASSWORD_SHORT_DESC,
				DATABASE_PASSWORD_LONG_DESC, DATABASE_PASSWORD_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"");
		addLeaf(_leafDatabaseServer);
		addLeaf(_leafDatabasePort);
		addLeaf(_leafDatabaseName);
		addLeaf(_leafDatabaseUsername);
		addLeaf(_leafDatabasePassword);
	}

	public MysqlConfigurationImpl(final IConfiguration parent, final MBeanServer mBeanServer,
			final String strCommandLineDatabaseServer, final Integer iCommandLineDatabasePort,
			final String strCommandLineDatabaseName, final String strCommandLineDatabaseUsername,
			final String strCommandLineDatabasePassword) throws InvalidConfigurationException
	{
		super(parent, MYSQL_CONFIGURATION_TAG, mBeanServer);
		_leafDatabaseServer = new ConfigurationString(this, DATABASE_SERVER_TAG, DATABASE_SERVER_SHORT_DESC,
				DATABASE_SERVER_LONG_DESC, DATABASE_SERVER_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"localhost", strCommandLineDatabaseServer);
		_leafDatabasePort = new ConfigurationInteger(this, DATABASE_PORT_TAG, DATABASE_PORT_SHORT_DESC,
				DATABASE_PORT_LONG_DESC, DATABASE_PORT_INVALID_MESSAGE, true, IntegerDisplayType.SPINNER,
				Integer.valueOf(1), Integer.valueOf(65535), Integer.valueOf(3306), iCommandLineDatabasePort);
		_leafDatabaseName = new ConfigurationString(this, DATABASE_NAME_TAG, DATABASE_NAME_SHORT_DESC,
				DATABASE_NAME_LONG_DESC, DATABASE_NAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0, "",
				strCommandLineDatabaseName);
		_leafDatabaseUsername = new ConfigurationString(this, DATABASE_USERNAME_TAG, DATABASE_USERNAME_SHORT_DESC,
				DATABASE_USERNAME_LONG_DESC, DATABASE_USERNAME_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"", strCommandLineDatabaseUsername);
		_leafDatabasePassword = new ConfigurationString(this, DATABASE_PASSWORD_TAG, DATABASE_PASSWORD_SHORT_DESC,
				DATABASE_PASSWORD_LONG_DESC, DATABASE_PASSWORD_INVALID_MESSAGE, false, StringDisplayType.TEXTFIELD, 0,
				"", strCommandLineDatabasePassword);
		addLeaf(_leafDatabaseServer);
		addLeaf(_leafDatabasePort);
		addLeaf(_leafDatabaseName);
		addLeaf(_leafDatabaseUsername);
		addLeaf(_leafDatabasePassword);
	}

	public MysqlConfigurationImpl(final IConfiguration parent, final MBeanServer mBeanServer,
			final String strCommandLineDatabaseServer, final Integer iCommandLineDatabasePort,
			final String strCommandLineDatabaseName, final String strCommandLineDatabaseUsername,
			final String strCommandLineDatabasePassword, final String strConfigurationLineDatabaseServer,
			final Integer iConfigurationDatabasePort, final String strConfigurationDatabaseName,
			final String strConfigurationDatabaseUsername, final String strConfigurationDatabasePassword)
			throws InvalidConfigurationException
	{
		this(parent, mBeanServer, strCommandLineDatabaseServer, iCommandLineDatabasePort, strCommandLineDatabaseName,
				strCommandLineDatabaseUsername, strCommandLineDatabasePassword);
		_leafDatabaseServer.setConfigurationValue(strConfigurationLineDatabaseServer);
		_leafDatabasePort.setConfigurationValue(iConfigurationDatabasePort);
		_leafDatabaseName.setConfigurationValue(strConfigurationDatabaseName);
		_leafDatabaseUsername.setConfigurationValue(strConfigurationDatabaseUsername);
		_leafDatabasePassword.setConfigurationValue(strConfigurationDatabasePassword);
	}

	@Override
	public String getDescription()
	{
		return "Configuration for a Mysql database.";
	}

	@Override
	public String getServer()
	{
		return _leafDatabaseServer.getCurrentValue();
	}

	@Override
	public int getPort()
	{
		return _leafDatabasePort.getCurrentValue().intValue();
	}

	@Override
	public String getDatabase()
	{
		return _leafDatabaseName.getCurrentValue();
	}

	@Override
	public String getUsername()
	{
		return _leafDatabaseUsername.getCurrentValue();
	}

	@Override
	public String getPassword()
	{
		return _leafDatabasePassword.getCurrentValue();
	}

	@Override
	public String getDatabaseDriver()
	{
		return MYSQL_DRIVER;
	}

	@Override
	public String getDatabaseConnection()
	{
		// DriverManager.getConnection("jdbc:mysql://localhost/test?user=minty&password=greatsqldb");
		final StringBuilder sb = new StringBuilder(60);
		sb.append("jdbc:mysql://");
		sb.append(_leafDatabaseServer.getCurrentValue());
		sb.append(':');
		sb.append(_leafDatabasePort.getCurrentValue());
		sb.append('/');
		sb.append(_leafDatabaseName.getCurrentValue());
		sb.append("?user=");
		sb.append(_leafDatabaseUsername.getCurrentValue());
		sb.append("&password=");
		sb.append(_leafDatabasePassword.getCurrentValue());
		return sb.toString();
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
