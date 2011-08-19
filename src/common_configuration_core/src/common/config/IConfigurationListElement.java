package common.config;

/**
 * An interface describing a configuration element of a
 * {@link IConfigurationList}.
 * 
 * @author benobiwan
 * @param <ELT>
 *            The type of {@linkIConfigurationListElement} which will be used in
 *            the comparator.
 */
public interface IConfigurationListElement<ELT extends IConfigurationListElement<ELT>>
		extends IConfigurationNode, Comparable<ELT>
{
	/**
	 * Get the id of this element.
	 * 
	 * @return the id of this element.
	 */
	String getId();
}
