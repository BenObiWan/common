package common.config.db;

import common.config.IConfigurationBranch;

/**
 * Configuration for a database connection.
 * 
 * @author benobiwan
 * 
 */
public interface IDatabaseConfiguration extends IConfigurationBranch, Comparable<IDatabaseConfiguration>
{
	/**
	 * Get the driver of the database.
	 * 
	 * @return driver of the database.
	 */
	String getDatabaseDriver();

	/**
	 * Get the connection String of the database.
	 * 
	 * @return connection String of the database.
	 */
	String getDatabaseConnection();

}
