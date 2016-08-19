package common.config.db;

/**
 * Configuration for a SQLite database.
 * 
 * @author benobiwan
 * 
 */
public interface ISQLiteConfiguration extends IDatabaseConfiguration
{	
	/**
	 * Tag of this configuration node.
	 */
	String SQLITE_CONFIGURATION_TAG = "SQLiteConfiguration";

	/**
	 * Tag for the database file name.
	 */
	String DATABASE_FILE_NAME_TAG = "DatabaseFileName";

	/**
	 * Driver for SQLite databases.
	 */
	String SQLITE_DRIVER = "org.sqlite.JDBC";

	/**
	 * Get the file name of the database.
	 * 
	 * @return the file name of the database.
	 */
	String getDatabaseFileName();
}
