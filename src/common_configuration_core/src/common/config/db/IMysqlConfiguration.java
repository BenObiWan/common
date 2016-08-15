package common.config.db;

/**
 * Configuration for an Mysql database.
 * 
 * @author benobiwan
 * 
 */
public interface IMysqlConfiguration
{
	/**
	 * Tag of this configuration node.
	 */
	String SQLITE_CONFIGURATION_TAG = "MysqlConfiguration";

	/**
	 * Tag for the database server.
	 */
	String DATABASE_SERVER_TAG = "DatabaseServer";
	
	/**
	 * Tag for the database port.
	 */
	String DATABASE_PORT_TAG = "DatabasePort";

	/**
	 * Tag for the database name.
	 */
	String DATABASE_NAME_TAG = "DatabaseName";

	/**
	 * Tag for the database username.
	 */
	String DATABASE_USERNAME_TAG = "DatabaseUserName";

	/**
	 * Tag for the database password.
	 */
	String DATABASE_PASSWORD_TAG = "DatabasePassword";

	/**
	 * Driver for Mysql databases.
	 */
	String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * Get the server hosting the database.
	 * 
	 * @return server hosting the database.
	 */
	String getServer();

	/**
	 * Get the port of the database.
	 * 
	 * @return the port of the database.
	 */
	int getPort();

	/**
	 * Get the database name.
	 * 
	 * @return the database name.
	 */
	String getDatabase();

	/**
	 * Get the username used to connect to the database.
	 * 
	 * @return the username used to connect to the database.
	 */
	String getUsername();

	/**
	 * Get the password used to connect to the database.
	 * 
	 * @return the password used to connect to the database.
	 */
	String getPassword();
}
