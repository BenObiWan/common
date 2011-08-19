package common.config;

import java.util.Set;

import javax.management.MBeanServer;

/**
 * An interface describing a configuration node.
 * 
 * @author benobiwan
 * 
 */
public interface IConfigurationNode extends IConfiguration
{
	/**
	 * Get all the leaf children of this {@link IConfigurationNode}.
	 * 
	 * @return all the leaf children of this {@link IConfigurationNode}.
	 */
	Set<IConfigurationLeaf<?, ?>> getLeafChildren();

	/**
	 * Get all the children of this {@link IConfigurationNode}.
	 * 
	 * @return all the children of this {@link IConfigurationNode}.
	 */
	Set<IConfigurationNodeElement> getChildren();

	/**
	 * Get the {@link MBeanServer} to use.
	 * 
	 * @return the {@link MBeanServer} to use.
	 */
	MBeanServer getMBeanServer();
}
