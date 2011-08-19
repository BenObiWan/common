package common.config;

import java.util.Set;

/**
 * An interface describing a list of configuration element.
 * 
 * @author benobiwan
 * 
 * @param <CONF>
 *            the type of {@link IConfigurationListElement} contained by this
 *            list.
 */
public interface IConfigurationList<CONF extends IConfigurationListElement<CONF>>
		extends IConfigurationNode, IConfigurationNodeElement
{
	/**
	 * Get a set of all the {@link IConfigurationListElement} contained by this
	 * list.
	 * 
	 * @return a set of all the {@link IConfigurationListElement} contained by
	 *         this list.
	 */
	Set<CONF> getElements();

	/**
	 * Add an element to the configuration list.
	 * 
	 * @param elt
	 *            the element to add.
	 */
	void addElement(CONF elt);
}
