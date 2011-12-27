package common;

import javax.swing.tree.TreeNode;

/**
 * A {@link TreeNode} that can be selected.
 * 
 * @author benobiwan
 * 
 */
public interface SelectableTreeNode extends TreeNode
{
	/**
	 * Check whether or not this {@link TreeNode} is selectable.
	 * 
	 * @return true if this {@link TreeNode} is selectable.
	 */
	public boolean isSelectable();

	/**
	 * Check whether or not this {@link TreeNode} is selected.
	 * 
	 * @return true if this {@link TreeNode} is selected.
	 */
	public boolean isSelected();

	/**
	 * Change the selected status of this {@link TreeNode}.
	 * 
	 * @param bSelected
	 *            the new selected status of this {@link TreeNode}.
	 */
	public void setSelected(boolean bSelected);
}
