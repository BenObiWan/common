package common.swing.tree;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
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

	private final TreeCheckBoxCellRenderer _renderer;

	/**
	 * Creates a new TreeCheckBoxCellEditor.
	 * 
	 * @param tree
	 *            the {@link JTree} edited by this editor.
	 */
	public TreeCheckBoxCellEditor(final JTree tree,
			final TreeCheckBoxCellRenderer renderer)
	{
		_tree = tree;
		_renderer = renderer;
	}

	@Override
	public Object getCellEditorValue()
	{
		final Component comp = _renderer.getRenderer();
		if (comp instanceof JCheckBox)
		{
			final JCheckBox checkbox = (JCheckBox) comp;

			return new CheckBoxNode(checkbox.getText(), checkbox.isSelected());
		}
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

		// editor always selected / focused
		final ItemListener itemListener = new ItemListener()
		{
			@SuppressWarnings("synthetic-access")
			@Override
			public void itemStateChanged(final ItemEvent itemEvent)
			{
				if (stopCellEditing())
				{
					fireEditingStopped();
				}
			}
		};
		if (cellEditor instanceof JCheckBox)
		{
			((JCheckBox) cellEditor).addItemListener(itemListener);
		}

		return cellEditor;
	}
}
