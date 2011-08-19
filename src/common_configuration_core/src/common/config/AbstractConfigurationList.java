package common.config;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.management.MBeanServer;

/**
 * A general purpose abstract configuration file.
 * 
 * @author benobiwan
 * @param <CONF>
 *            the type of this {@link IConfigurationList} elements.
 * 
 */
public abstract class AbstractConfigurationList<CONF extends IConfigurationListElement<CONF>>
		extends AbstractConfigurationNode implements IConfigurationList<CONF>
{
	/**
	 * Set containing all the elements of this {@link IConfigurationList}.
	 */
	protected final ConcurrentSkipListSet<CONF> _elementSet = new ConcurrentSkipListSet<CONF>();

	/**
	 * Creates a new AbstractConfigurationList.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationList.
	 * @param strName
	 *            the name of this AbstractConfigurationList.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractConfigurationList(final IConfiguration parent,
			final String strName, final MBeanServer mBeanServer)
	{
		super(parent, strName, mBeanServer);
	}

	@Override
	public final void updateCurrentValue()
	{
		if (!isLocked())
		{
			super.updateCurrentValue();
			for (final CONF elt : _elementSet)
			{
				elt.updateCurrentValue();
			}
		}
	}

	@Override
	public final Set<CONF> getElements()
	{
		return Collections.unmodifiableSet(_elementSet);
	}

	@Override
	public void addElement(final CONF elt)
	{
		_elementSet.add(elt);
	}
}
