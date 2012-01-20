package common.swing.demo;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.apache.log4j.BasicConfigurator;

import common.swing.TreeCheckBoxCellEditor;
import common.swing.TreeCheckBoxCellRenderer;

/**
 * Demo for the selectable tree node.
 * 
 * @author benobiwan
 * 
 */
public final class SelectableTreeDemoFrame extends JFrame
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 4073570440226584627L;

	/**
	 * The {@link JTree} to display.
	 */
	private final JTree _tree;

	/**
	 * Creates a new SelectableTreeDemoFrame.
	 */
	public SelectableTreeDemoFrame()
	{
		super("selectable tree demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		BasicConfigurator.configure();
		final TreeNode rootNode = createTree();
		_tree = new JTree(rootNode);
		expandAll();

		_tree.setCellRenderer(new TreeCheckBoxCellRenderer());

		_tree.setCellEditor(new TreeCheckBoxCellEditor(_tree));
		_tree.setEditable(true);

		final JScrollPane scrollPane = new JScrollPane(_tree);
		setContentPane(scrollPane);
	}

	/**
	 * Create the {@link TreeNode}s composing the JTree to display.
	 * 
	 * @return the {@link TreeNode}s composing the JTree to display.
	 */
	private TreeNode createTree()
	{
		final DefaultMutableTreeNode root = createNode("root", "the root node",
				false);

		DefaultMutableTreeNode fam1 = createNode("fam 1", "first family", false);
		DefaultMutableTreeNode fam2 = createNode("fam 2", "second family", true);
		fam1.insert(createNode("tag 1", "first tag", true),
				fam1.getChildCount());
		fam1.insert(createNode("tag 2", "second tag", true),
				fam1.getChildCount());
		fam1.insert(createNode("tag 3", "third tag", true),
				fam1.getChildCount());
		fam2.insert(createNode("tag 4", "forth tag", true),
				fam2.getChildCount());
		fam2.insert(createNode("tag 5", "fifth tag", true),
				fam2.getChildCount());

		root.insert(fam1, root.getChildCount());
		root.insert(fam2, root.getChildCount());

		return root;
	}

	/**
	 * Creates a new node.
	 * 
	 * @param strName
	 *            the name of this {@link DemoSelectableTreeNode}.
	 * @param strDescription
	 *            the description of this {@link DemoSelectableTreeNode}.
	 * @param bSelectable
	 *            whether or not this {@link DemoSelectableTreeNode} is
	 *            selectable.
	 * @return the new node.
	 */
	private DefaultMutableTreeNode createNode(final String strName,
			final String strDescription, final boolean bSelectable)
	{
		return new DemoSelectableTreeNode(strName, strDescription, bSelectable);
	}

	/**
	 * Expand all nodes of the {@link JTree}.
	 */
	private void expandAll()
	{
		int row = 0;
		while (row < _tree.getRowCount())
		{
			_tree.expandRow(row);
			row++;
		}
	}

	/**
	 * Main class creating a new SelectableTreeDemoFrame and displaying it.
	 * 
	 * @param args
	 *            unused.
	 */
	public static void main(final String[] args)
	{
		final SelectableTreeDemoFrame main = new SelectableTreeDemoFrame();
		main.pack();
		main.setVisible(true);
	}
}
