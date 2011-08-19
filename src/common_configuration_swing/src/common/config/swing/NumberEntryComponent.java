package common.config.swing;

import common.config.IConfigurationNumberLeaf;

/**
 * Object used to display a {@Link IConfigurationNumberLeaf} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 * @param <TYPE>
 *            type of the configuration element.
 * @param <DISP_TYPE>
 *            display type of the configuration element.
 * @param <LEAF_TYPE>
 *            leaf type of the configuration element.
 */
public abstract class NumberEntryComponent<TYPE extends Number, DISP_TYPE extends Enum<DISP_TYPE>, LEAF_TYPE extends IConfigurationNumberLeaf<TYPE, DISP_TYPE>>
		extends EntryComponent<TYPE, DISP_TYPE, LEAF_TYPE>
{

	/**
	 * Creates a new NumberEntryComponent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	protected NumberEntryComponent(final LEAF_TYPE entry)
	{
		super(entry);
	}
}
