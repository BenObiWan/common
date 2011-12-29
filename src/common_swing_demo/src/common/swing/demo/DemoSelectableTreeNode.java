package common.swing.demo;

import javax.swing.tree.DefaultMutableTreeNode;

import common.ISelectableTreeNode;

/**
 * A {@link ISelectableTreeNode}.
 * 
 * @author benobiwan
 * 
 */
public class DemoSelectableTreeNode extends DefaultMutableTreeNode implements
		ISelectableTreeNode
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 5771660204195299805L;

	/**
	 * The name of this {@link DemoSelectableTreeNode}.
	 */
	private final String _strName;

	/**
	 * The description of this {@link DemoSelectableTreeNode}.
	 */
	private final String _strDescription;

	/**
	 * Whether or not this {@link DemoSelectableTreeNode} is selectable.
	 */
	private final boolean _bSelectable;

	/**
	 * Whether or not this {@link DemoSelectableTreeNode} is selected.
	 */
	private boolean _bSelected = false;

	/**
	 * Lock protecting the access to _bSelected.
	 */
	private final Object _lockSelected = new Object();

	/**
	 * Creates a new {@link DemoSelectableTreeNode}.
	 * 
	 * @param strName
	 *            the name of this {@link DemoSelectableTreeNode}.
	 * @param strDescription
	 *            the description of this {@link DemoSelectableTreeNode}.
	 * @param bSelectable
	 *            whether or not this {@link DemoSelectableTreeNode} is
	 *            selectable.
	 */
	public DemoSelectableTreeNode(final String strName,
			final String strDescription, final boolean bSelectable)
	{
		this(strName, strDescription, bSelectable, false);
	}

	/**
	 * Creates a new {@link DemoSelectableTreeNode}.
	 * 
	 * @param strName
	 *            the name of this {@link DemoSelectableTreeNode}.
	 * @param strDescription
	 *            the description of this {@link DemoSelectableTreeNode}.
	 * @param bSelectable
	 *            whether or not this {@link DemoSelectableTreeNode} is
	 *            selectable.
	 * @param bSelected
	 *            whether or not this {@link DemoSelectableTreeNode} is
	 *            selected.
	 */
	public DemoSelectableTreeNode(final String strName,
			final String strDescription, final boolean bSelectable,
			final boolean bSelected)
	{
		super(strName);
		_strName = strName;
		_strDescription = strDescription;
		_bSelectable = bSelectable;
		setSelected(bSelected);
	}

	@Override
	public boolean isSelectable()
	{
		return _bSelectable;
	}

	@Override
	public boolean isSelected()
	{
		synchronized (_lockSelected)
		{
			return _bSelected;
		}
	}

	@Override
	public void setSelected(final boolean bSelected)
	{
		if (_bSelectable)
		{
			synchronized (_lockSelected)
			{
				_bSelected = bSelected;
			}
		}
	}

	/**
	 * Get the name of this {@link DemoSelectableTreeNode}.
	 * 
	 * @return the name of this {@link DemoSelectableTreeNode}.
	 */
	public String getName()
	{
		return _strName;
	}

	/**
	 * Get the description of this {@link DemoSelectableTreeNode}.
	 * 
	 * @return the description of this {@link DemoSelectableTreeNode}.
	 */
	public String getDescription()
	{
		return _strDescription;
	}
}
