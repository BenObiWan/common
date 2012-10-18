package common.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import common.ISelectableTreeNode;

/**
 * {@link TreeCellRenderer} used to render nodes using {@JCheckBox}
 * es.
 * 
 * @author benobiwan
 * 
 */
public class TreeCheckBoxCellRenderer extends DefaultTreeCellRenderer
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -5734562707728669282L;

	/**
	 * {@link JCheckBox} used to render the cells.
	 */
	private final JCheckBox _checkBoxCellRenderer = new JCheckBox();

	/**
	 * Color used for the foreground of the {@link JCheckBox} when it is
	 * selected.
	 */
	private final Color _selectedForegroundColor;

	/**
	 * Color used for the background of the {@link JCheckBox} when it is
	 * selected.
	 */
	private final Color _selectedBackgroundColor;

	/**
	 * Color used for the foreground of the {@link JCheckBox} when it isn't
	 * selected.
	 */
	private final Color _unselectedForegroundColor;

	/**
	 * Color used for the background of the {@link JCheckBox} when it isn't
	 * selected.
	 */
	private final Color _unselectedBackgroundColor;

	private Component _renderer;

	/**
	 * Creates a new TreeCheckBoxCellRenderer.
	 */
	public TreeCheckBoxCellRenderer()
	{
		super();
		final Font treeFont = UIManager.getFont("Tree.font");
		if (treeFont != null)
		{
			_checkBoxCellRenderer.setFont(treeFont);
		}
		try
		{
			final Boolean bPaintFocus = (Boolean) UIManager
					.get("Tree.drawsFocusBorderAroundIcon");
			_checkBoxCellRenderer.setFocusPainted((bPaintFocus != null)
					&& (bPaintFocus.booleanValue()));
		}
		catch (final ClassCastException e)
		{
			// nothing
		}

		_selectedForegroundColor = UIManager
				.getColor("Tree.selectionForeground");
		_selectedBackgroundColor = UIManager
				.getColor("Tree.selectionBackground");
		_unselectedForegroundColor = UIManager.getColor("Tree.textForeground");
		_unselectedBackgroundColor = UIManager.getColor("Tree.textBackground");
	}

	public Component getRenderer()
	{
		return _renderer;
	}

	@Override
	public Component getTreeCellRendererComponent(final JTree tree,
			final Object value, final boolean bSelected,
			final boolean expanded, final boolean leaf, final int row,
			final boolean bHasFocus)
	{
		if ((value != null) && (value instanceof ISelectableTreeNode)
				&& ((ISelectableTreeNode) value).isSelectable())
		{
			_checkBoxCellRenderer.setText(tree.convertValueToText(value,
					bSelected, expanded, leaf, row, false));
			_checkBoxCellRenderer.setSelected(((ISelectableTreeNode) value)
					.isSelected());
			_checkBoxCellRenderer.setEnabled(tree.isEnabled());
			if (bSelected)
			{
				_checkBoxCellRenderer.setForeground(_selectedForegroundColor);
				_checkBoxCellRenderer.setBackground(_selectedBackgroundColor);
			}
			else
			{
				_checkBoxCellRenderer.setForeground(_unselectedForegroundColor);
				_checkBoxCellRenderer.setBackground(_unselectedBackgroundColor);
			}
			_renderer = _checkBoxCellRenderer;
		}
		else
		{
			_renderer = super.getTreeCellRendererComponent(tree, value,
					bSelected, expanded, leaf, row, bHasFocus);
		}
		return _renderer;
	}
}
