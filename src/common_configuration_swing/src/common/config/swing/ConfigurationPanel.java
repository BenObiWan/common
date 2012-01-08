package common.config.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.config.IConfigurationLeaf;
import common.config.IConfigurationList;
import common.config.IConfigurationNode;

/**
 * Panel to show and configure a {@link IConfigurationNode}.
 * 
 * @author benobiwan
 * 
 */
public final class ConfigurationPanel extends JPanel
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 956359852088252815L;

	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConfigurationPanel.class);

	/**
	 * Label showing the name of the configuration at the head of the panel.
	 */
	private final JLabel _headLabel = new JLabel();

	/**
	 * Panel showing the names of the components.
	 */
	protected final JPanel _leftComponentPanel = new JPanel(new GridLayout(0,
			1, 5, 5));

	/**
	 * Panel showing the configuration elements.
	 */
	protected final JPanel _rightComponentPanel = new JPanel(new GridLayout(0,
			1, 5, 5));

	/**
	 * Panel showing the names of the advanced components.
	 */
	protected final JPanel _leftAdvancedComponentPanel = new JPanel(
			new GridLayout(0, 1, 5, 5));

	/**
	 * Panel showing the advanced configuration elements.
	 */
	protected final JPanel _rightAdvancedComponentPanel = new JPanel(
			new GridLayout(0, 1, 5, 5));

	/**
	 * List of component to show on this panel.
	 */
	private final ConcurrentLinkedQueue<EntryComponent<?, ?, ?>> _lEntry = new ConcurrentLinkedQueue<EntryComponent<?, ?, ?>>();

	/**
	 * Check box to control whether to show the advanced options or not.
	 */
	private final JCheckBox _checkBoxAdvanced = new JCheckBox(
			"Show advanced options", false);

	/**
	 * Panel displayed only for {@link IConfigurationList}, used to display
	 * buttons to add and delete element of the list.
	 */
	private final JPanel _listPanel = new JPanel(new BorderLayout(5, 5));

	/**
	 * ComboBox used only when displaying {@link IConfigurationList}. Contains
	 * the list of elements.
	 */
	private final JComboBox _listComboBox = new JComboBox();

	/**
	 * The configuration to display.
	 */
	protected IConfigurationNode _configuration;

	/**
	 * Creates a new ConfigurationPanel with no {@link IConfigurationNode} to
	 * display.
	 */
	public ConfigurationPanel()
	{
		this(null, true);
	}

	/**
	 * Creates a new ConfigurationPanel with no {@link IConfigurationNode} to
	 * display.
	 * 
	 * @param bShowButtons
	 *            show/hide the Save Reload and Default buttons.
	 */
	public ConfigurationPanel(final boolean bShowButtons)
	{
		this(null, bShowButtons);
	}

	/**
	 * Creates a new ConfigurationPanel with a {@link IConfigurationNode} to
	 * display.
	 * 
	 * @param configuration
	 *            the {@link IConfigurationNode} to display.
	 * @param bShowButtons
	 *            show/hide the Save Reload and Default buttons.
	 */
	public ConfigurationPanel(final IConfigurationNode configuration,
			final boolean bShowButtons)
	{
		super(new BorderLayout(5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		add(_headLabel, BorderLayout.PAGE_START);
		final JPanel tmpCenterPanel = new JPanel(new BorderLayout());
		final JPanel tmpAllComponentPanel = new JPanel();
		tmpAllComponentPanel.setLayout(new BoxLayout(tmpAllComponentPanel,
				BoxLayout.PAGE_AXIS));

		tmpCenterPanel.setBorder(new CompoundBorder(new LineBorder(Color.BLACK,
				1, true), new EmptyBorder(5, 5, 5, 5)));

		final JPanel tmpComponentPanel = new JPanel(new BorderLayout());
		tmpComponentPanel.add(_leftComponentPanel, BorderLayout.LINE_START);
		tmpComponentPanel.add(_rightComponentPanel, BorderLayout.LINE_END);

		final JPanel tmpAdvancedComponentPanel = new JPanel(new BorderLayout());
		tmpAdvancedComponentPanel.add(_leftAdvancedComponentPanel,
				BorderLayout.LINE_START);
		tmpAdvancedComponentPanel.add(_rightAdvancedComponentPanel,
				BorderLayout.LINE_END);

		final JPanel tmpCBPanel = new JPanel(new BorderLayout());
		tmpCBPanel.add(_checkBoxAdvanced, BorderLayout.LINE_START);
		tmpCBPanel.add(new JPanel(), BorderLayout.CENTER);

		tmpAllComponentPanel.add(tmpComponentPanel);
		tmpAllComponentPanel.add(tmpCBPanel);
		_checkBoxAdvanced.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(final ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					_leftAdvancedComponentPanel.setVisible(true);
					_rightAdvancedComponentPanel.setVisible(true);
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED)
				{
					_leftAdvancedComponentPanel.setVisible(false);
					_rightAdvancedComponentPanel.setVisible(false);
				}
			}
		});
		tmpAllComponentPanel.add(tmpAdvancedComponentPanel);
		final JButton buttonListAdd = new JButton("Add");
		// buttonListAdd.addActionListener();
		final JButton buttonListDel = new JButton("Del");
		// buttonListAdd.addActionListener();
		_listPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		_listPanel.add(buttonListAdd, BorderLayout.LINE_START);
		_listPanel.add(_listComboBox, BorderLayout.CENTER);
		_listPanel.add(buttonListDel, BorderLayout.LINE_END);
		_listPanel.setVisible(false);
		tmpAllComponentPanel.add(_listPanel);
		tmpCenterPanel.add(tmpAllComponentPanel, BorderLayout.PAGE_START);
		add(tmpCenterPanel, BorderLayout.CENTER);
		if (bShowButtons)
		{
			add(createBottomPanel(), BorderLayout.PAGE_END);
		}
		setConfiguration(configuration);
	}

	/**
	 * Set the configuration to show on this panel.
	 * 
	 * @param configuration
	 *            the configuration to show on this panel.
	 */
	public void setConfiguration(final IConfigurationNode configuration)
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("setConfiguration");
		}
		_leftComponentPanel.removeAll();
		_rightComponentPanel.removeAll();
		_leftAdvancedComponentPanel.removeAll();
		_rightAdvancedComponentPanel.removeAll();
		_lEntry.clear();
		_configuration = configuration;
		if (configuration == null)
		{
			_headLabel.setText(" ");
			_checkBoxAdvanced.setVisible(false);
		}
		else
		{
			_headLabel.setText(_configuration.getDescription());
			populateCenterPanel(_configuration.getLeafChildren());
			if (_configuration instanceof IConfigurationList<?>)
			{
				_listPanel.setVisible(true);
			}
			else
			{
				_listPanel.setVisible(false);
			}
		}
		// TODO need appeler validate?
	}

	/**
	 * Populate the center panel of this ConfigurationPanel with the lit of leaf
	 * specified in argument.
	 * 
	 * @param leafList
	 *            the list of leaf to show on the panel.
	 */
	private void populateCenterPanel(
			final Set<IConfigurationLeaf<?, ?>> leafList)
	{
		boolean bHasAdvancedOption = false;
		for (final IConfigurationLeaf<?, ?> entry : leafList)
		{
			final EntryComponent<?, ?, ?> entryComp = EntryComponent
					.createEntryComponent(entry);
			_lEntry.add(entryComp);
			final JPanel tmpPanel = new JPanel(new GridLayout(0, 2, 5, 5));

			final JPanel tmpLeftPanel = new JPanel(new BorderLayout(5, 5));
			tmpLeftPanel.add(entryComp.getCurrentValueLabel(),
					BorderLayout.CENTER);
			tmpLeftPanel.add(entryComp.getLockedCheckBox(),
					BorderLayout.LINE_END);
			tmpLeftPanel.setBorder(new LineBorder(Color.BLACK, 1, true));
			final JPanel tmpRightPanel = new JPanel(new BorderLayout(5, 5));
			tmpRightPanel.add(entryComp.getComponent(), BorderLayout.CENTER);
			tmpRightPanel.add(entryComp.getValidCheckBox(),
					BorderLayout.LINE_END);
			tmpPanel.add(tmpLeftPanel);
			tmpPanel.add(tmpRightPanel);

			if (entryComp.isAdvanced())
			{
				bHasAdvancedOption = true;
				_leftAdvancedComponentPanel.add(entryComp.getDescLabel());
				_rightAdvancedComponentPanel.add(tmpPanel);
			}
			else
			{
				_leftComponentPanel.add(entryComp.getDescLabel());
				_rightComponentPanel.add(tmpPanel);
			}
			if (bHasAdvancedOption)
			{
				_checkBoxAdvanced.setSelected(false);
				_checkBoxAdvanced.setVisible(true);
				_leftAdvancedComponentPanel.setVisible(false);
				_rightAdvancedComponentPanel.setVisible(false);
			}
			else
			{
				_checkBoxAdvanced.setVisible(false);
			}
		}
	}

	/**
	 * Create the bottom panel of this configuration panel.
	 * 
	 * @return the bottom panel of this configuration panel.
	 */
	private JPanel createBottomPanel()
	{
		final JPanel bottomPanel = new JPanel(new GridLayout(1, 0, 5, 5));
		final JButton butSave = new JButton("Save");
		butSave.setToolTipText("Save values");
		butSave.addActionListener(new SaveActionListener());
		bottomPanel.add(butSave);
		final JButton butReload = new JButton("Reload");
		butReload.setToolTipText("Reload previous values");
		butReload.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				setToInitialValue();
			}
		});
		bottomPanel.add(butReload);
		final JButton butDefault = new JButton("Default");
		butDefault.setToolTipText("Set to default values");
		butDefault.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				setToDefaultValue();
			}
		});
		bottomPanel.add(butDefault);
		return bottomPanel;
	}

	/**
	 * Check whether the value entered on all the component of this panel are
	 * valid or not, and update the corresponding valid checkbox accordingly.
	 * 
	 * @return true if the value entered on all the component are valid.
	 */
	protected boolean validateAndShowAll()
	{
		boolean bRes = true;
		for (final EntryComponent<?, ?, ?> comp : _lEntry)
		{
			bRes &= comp.validateAndShowValidity();
		}
		return bRes;
	}

	// private void setToConfigurator()
	// {
	// for (final EntryComponent entry : _lEntry)
	// {
	// entry.saveToConfigurator();
	// }
	// }

	/**
	 * Set the interface value to the default value.
	 */
	protected void setToDefaultValue()
	{
		for (final EntryComponent<?, ?, ?> entry : _lEntry)
		{
			entry.setToDefaultValue();
		}
	}

	/**
	 * Set the interface value to the value it had when the panel was created.
	 */
	protected void setToInitialValue()
	{
		for (final EntryComponent<?, ?, ?> entry : _lEntry)
		{
			entry.setToDefaultValue();
		}
	}

	/**
	 * Check whether the configuration represented by this panel is locked.
	 * 
	 * @return true if the configuration represented by this panel is locked.
	 */
	public boolean isLocked()
	{
		return _configuration.isLocked();
	}

	/**
	 * {@link ActionListener} for the save button.
	 * 
	 * @author benobiwan
	 * 
	 */
	private final class SaveActionListener implements ActionListener
	{
		/**
		 * Title for the error option dialog.
		 */
		private static final String ERROR_TITLE = "Error";

		/**
		 * Message for the error option dialog.
		 */
		private static final String ERROR_MESS = "Some fields are invalid.";

		/**
		 * Creates a new SaveActionListener.
		 */
		public SaveActionListener()
		{
			super();
		}

		@Override
		public void actionPerformed(final ActionEvent e)
		{
			if (!validateAndShowAll())
			{
				JOptionPane.showInternalMessageDialog(ConfigurationPanel.this,
						ERROR_MESS, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (_configuration != null)
				{
					// setToConfigurator();
					// final ConfigurationEditor<?> conf = _reflex
					// .getConfigurator();
					// if (conf instanceof SaveableConfigurationEditor<?>)
					// {
					// ((SaveableConfigurationEditor<?>) conf)
					// .saveToDisk();
					// }
				}
			}
		}
	}

}
