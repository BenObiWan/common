package common.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.management.MBeanServer;

/**
 * An abstract implementation of {@link IConfigurationNode}.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConfigurationNode extends AbstractConfiguration
		implements IConfigurationNode
{
	/**
	 * A Map containing all the leaf of this node.
	 */
	private final Map<String, IConfigurationLeaf<?, ?>> _leafMap = new HashMap<String, IConfigurationLeaf<?, ?>>();

	/**
	 * A Set containing all the leaf of this node sorted by name.
	 */
	private final SortedSet<IConfigurationLeaf<?, ?>> _leafSet = new TreeSet<IConfigurationLeaf<?, ?>>();

	/**
	 * A Map containing all the children of this node.
	 */
	private final Map<String, IConfigurationNodeElement> _childMap = new HashMap<String, IConfigurationNodeElement>();

	/**
	 * A Set containing all the children of this node sorted by name.
	 */
	private final SortedSet<IConfigurationNodeElement> _childSet = new TreeSet<IConfigurationNodeElement>();

	/**
	 * The {@link MBeanServer} to use.
	 */
	private final MBeanServer _mBeanServer;

	/**
	 * Creates a new AbstractConfigurationNode.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfigurationNode.
	 * @param strName
	 *            the name of this AbstractConfigurationNode.
	 * @param mBeanServer
	 *            the {@link MBeanServer} to use.
	 */
	protected AbstractConfigurationNode(final IConfiguration parent,
			final String strName, final MBeanServer mBeanServer)
	{
		super(parent, strName);
		_mBeanServer = mBeanServer;
	}

	@Override
	public final SortedSet<IConfigurationLeaf<?, ?>> getLeafChildren()
	{
		return Collections.unmodifiableSortedSet(_leafSet);
	}

	@Override
	public final SortedSet<IConfigurationNodeElement> getChildren()
	{
		return Collections.unmodifiableSortedSet(_childSet);
	}

	/**
	 * Add a new {@link IConfigurationLeaf} to this node.
	 * 
	 * @param leaf
	 *            the leaf to add.
	 */
	protected void addLeaf(final IConfigurationLeaf<?, ?> leaf)
	{
		_leafSet.add(leaf);
		_leafMap.put(leaf.getName(), leaf);
	}

	/**
	 * Get the specified {@link IConfigurationLeaf} of this node.
	 * 
	 * @param strName
	 *            the name of the leaf.
	 * @return the leaf with the specified name.
	 */
	protected IConfigurationLeaf<?, ?> getLeaf(final String strName)
	{
		return _leafMap.get(strName);
	}

	/**
	 * Add a new {@link IConfigurationNodeElement} to this node.
	 * 
	 * @param elt
	 *            the element to add.
	 */
	protected void addChild(final IConfigurationNodeElement elt)
	{
		_childSet.add(elt);
		_childMap.put(elt.getName(), elt);
	}

	@Override
	public void updateCurrentValue()
	{
		if (!isLocked())
		{
			for (final IConfigurationLeaf<?, ?> leaf : _leafSet)
			{
				leaf.updateCurrentValue();
			}
			for (final IConfigurationNodeElement child : _childSet)
			{
				child.updateCurrentValue();
			}
		}
	}

	@Override
	public MBeanServer getMBeanServer()
	{
		return _mBeanServer;
	}
}
