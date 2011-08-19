package common.config;

/**
 * A {@link IConfiguration} loader.
 * 
 * @author benobiwan
 * 
 */
public interface IConfigurationLoader
{
	/**
	 * char used to separate nodes in the configuration tree.
	 */
	char CONF_NODE_SEP = '.';

	/**
	 * String used as prefix for all configuration information passed on the
	 * command line.
	 */
	String BASE_CONF_PREFIX = "conf";

	/**
	 * Get the full command line prefix of this {@link IConfigurationLoader}.
	 * 
	 * @return the full command line prefix of this {@link IConfigurationLoader}
	 *         .
	 */
	String getFullCommandLinePrefix();
}
