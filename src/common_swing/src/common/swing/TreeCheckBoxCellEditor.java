package common.swing;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTree;
import javax.swing.tree.TreeCellEditor;

/**
 * A {@link TreeCellEditor} used to edit a {JTree} with a
 * {@link TreeCheckBoxCellRenderer}.
 * 
 * @author benobiwan
 * 
 */
public class TreeCheckBoxCellEditor extends AbstractCellEditor implements
		TreeCellEditor
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 2536906531444518528L;

	/**
	 * {@link JTree} edited by this editor.
	 */
	private final JTree _tree;

	/**
	 * Creates a new TreeCheckBoxCellEditor.
	 * 
	 * @param tree
	 *            the {@link JTree} edited by this editor.
	 */
	public TreeCheckBoxCellEditor(final JTree tree)
	{
		_tree = tree;
	}

	@Override
	public Object getCellEditorValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTreeCellEditorComponent(final JTree tree,
			final Object value, final boolean isSelected,
			final boolean expanded, final boolean leaf, final int row)
	{
		final Component cellEditor = _tree.getCellRenderer()
				.getTreeCellRendererComponent(tree, value, true, expanded,
						leaf, row, true);
		return cellEditor;
	}
}
