package common.config.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.config.IConfigurationLeaf;
import common.config.InvalidConfigurationException;
import common.config.leaf.ConfigurationBoolean;
import common.config.leaf.ConfigurationDouble;
import common.config.leaf.ConfigurationFloat;
import common.config.leaf.ConfigurationInteger;
import common.config.leaf.ConfigurationLong;
import common.config.leaf.ConfigurationString;

/**
 * Object used to display a {@Link IConfigurationLeaf} on the
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
public abstract class EntryComponent<TYPE, DISP_TYPE extends Enum<DISP_TYPE>, LEAF_TYPE extends IConfigurationLeaf<TYPE, DISP_TYPE>>
{
	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EntryComponent.class);

	/**
	 * The configuration element.
	 */
	protected final LEAF_TYPE _entry;

	/**
	 * The initial value of this configuration element.
	 */
	protected final TYPE _initValue;

	/**
	 * The label displaying the current value.
	 */
	private final JLabel _currentValueLabel;

	/**
	 * The label displaying the command line value.
	 */
	private final JLabel _commandLineValueLabel;

	/**
	 * The label displaying the configuration value.
	 */
	private final JLabel _configurationValueLabel;

	/**
	 * The label displaying the default value.
	 */
	private final JLabel _defaultValueLabel;

	/**
	 * The display type of this component.
	 */
	protected final DISP_TYPE _dispType;

	/**
	 * The label displaying the description of the configuration element.
	 */
	private final JLabel _entryDescLabel;

	/**
	 * The check box showing whether the entered value is valid or not.
	 */
	protected final JCheckBox _validCheckBox;

	/**
	 * The check box showing whether the configuration element is locked or not.
	 */
	protected final JCheckBox _lockedCheckBox;

	/**
	 * The entry component itself.
	 */
	protected JComponent _entryComponent;

	/**
	 * Prefix for the tooltip of the current value label.
	 */
	private final String _currentValueToolTipPrefix;

	/**
	 * Suffix for the tooltip of the current value label.
	 */
	private final String __currentValueToolTipSuffix;

	/**
	 * Creates a new EntryComponent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	protected EntryComponent(final LEAF_TYPE entry)
	{
		final StringBuilder builder = new StringBuilder("<html>Current value");
		_entry = entry;
		_initValue = _entry.getCurrentValue();
		if (_entry.getCurrentValue() == null)
		{
			_currentValueLabel = new JLabel("-");
		}
		else
		{
			_currentValueLabel = new JLabel(_entry.getCurrentValue().toString());
		}
		_currentValueLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		builder.append("<br>Inital value : ");
		builder.append(_initValue.toString());
		builder.append("<br>Command line value : ");
		if (_entry.getCommandLineValue() == null)
		{
			_commandLineValueLabel = new JLabel("-");
			builder.append("-");
		}
		else
		{
			_commandLineValueLabel = new JLabel(_entry.getCommandLineValue()
					.toString());
			builder.append(_entry.getCommandLineValue().toString());
		}
		_commandLineValueLabel.setToolTipText("Command line value");
		builder.append("<br>Configuration value : ");
		_currentValueToolTipPrefix = builder.toString();
		_configurationValueLabel = new JLabel();
		builder.delete(0, builder.length());
		_configurationValueLabel.setToolTipText("Configuration value");
		builder.append("<br>Default value : ");
		if (_entry.getDefaultValue() == null)
		{
			_defaultValueLabel = new JLabel("-");
			builder.append("-");
		}
		else
		{
			_defaultValueLabel = new JLabel(_entry.getDefaultValue().toString());
			builder.append(_entry.getDefaultValue().toString());
		}
		_defaultValueLabel.setToolTipText("Default value");
		builder.append("</html>");
		__currentValueToolTipSuffix = builder.toString();

		_dispType = _entry.getDisplayType();
		_entryDescLabel = new JLabel(_entry.getDescription());
		final String strLongDesc = _entry.getLongDescription();
		if (strLongDesc != null)
		{
			_entryDescLabel.setToolTipText(strLongDesc);
		}
		_validCheckBox = new JCheckBox();
		_validCheckBox.setSelected(true);
		_validCheckBox.setEnabled(false);
		// _validCheckBox.setDisabledSelectedIcon(CoreUI.VALID_ICON);
		// _validCheckBox.setDisabledIcon(CoreUI.INVALID_ICON);
		_lockedCheckBox = new JCheckBox();
		_lockedCheckBox.setSelected(_entry.isLocked());
		_lockedCheckBox.setEnabled(false);
		// _lockedCheckBox.setDisabledSelectedIcon(CoreUI.LOCKED_ICON);
		// _lockedCheckBox.setDisabledIcon(CoreUI.UNLOCKED_ICON);
		updateConfigurationValue();
		generateComponent();
	}

	/**
	 * Update the configuration value label and the tooltip of the current value
	 * label according to the change of the configuration value.
	 */
	private void updateConfigurationValue()
	{
		final StringBuilder builder = new StringBuilder(
				_currentValueToolTipPrefix);
		if (_entry.getConfigurationValue() == null)
		{
			_configurationValueLabel.setText("-");
			builder.append("-");
		}
		else
		{
			_configurationValueLabel.setText(_entry.getConfigurationValue()
					.toString());
			builder.append(_entry.getConfigurationValue().toString());
		}
		builder.append(__currentValueToolTipSuffix);
		_currentValueLabel.setToolTipText(builder.toString());
	}

	/**
	 * Check whether the configuration element of this entry is advanced.
	 * 
	 * @return true if the configuration element of this entry is advanced.
	 */
	public boolean isAdvanced()
	{
		return _entry.isAdvanced();
	}

	/**
	 * Check whether the configuration element of this entry is locked.
	 * 
	 * @return true if the configuration element of this entry is locked.
	 */
	public boolean isLocked()
	{
		return _entry.isLocked();
	}

	/**
	 * Generate this component depending on the display type.
	 */
	protected abstract void generateComponent();

	/**
	 * Get the label displaying the description of the configuration element.
	 * 
	 * @return the label displaying the description of the configuration
	 *         element.
	 */
	public JLabel getDescLabel()
	{
		return _entryDescLabel;
	}

	/**
	 * Get the entry component.
	 * 
	 * @return the entry component.
	 */
	public JComponent getComponent()
	{
		return _entryComponent;
	}

	/**
	 * Get the check box showing whether the entered value is valid or not.
	 * 
	 * @return the check box showing whether the entered value is valid or not.
	 */
	public JCheckBox getValidCheckBox()
	{
		return _validCheckBox;
	}

	/**
	 * Get the label displaying the current value.
	 * 
	 * @return the label displaying the current value.
	 */
	public JLabel getCurrentValueLabel()
	{
		return _currentValueLabel;
	}

	/**
	 * Get the check box showing whether the configuration element is locked or
	 * not.
	 * 
	 * @return the check box showing whether the configuration element is locked
	 *         or not.
	 */
	public JCheckBox getLockedCheckBox()
	{
		return _lockedCheckBox;
	}

	/**
	 * Check whether the value entered on the component is valid or not, and
	 * update the valid checkbox accordingly.
	 * 
	 * @return true if the value entered on the component is valid.
	 */
	public final boolean validateAndShowValidity()
	{
		boolean bRes;
		try
		{
			bRes = _entry.validateValue(getDisplayedValue());
		}
		catch (final InvalidConfigurationException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
			bRes = false;
		}
		_validCheckBox.setSelected(bRes);
		return bRes;
	}

	/**
	 * Get the value displayed on the entry component.
	 * 
	 * @return the value displayed on the entry component.
	 * @throws InvalidConfigurationException
	 *             if the value on the component is invalid.
	 */
	protected abstract TYPE getDisplayedValue()
			throws InvalidConfigurationException;

	/**
	 * Set the value displayed on the entry component to the value given in
	 * argument, then validate it and update the valid checkbox accordingly.
	 * 
	 * @param value
	 *            the new value to display.
	 */
	protected abstract void setToValueAndShowValidity(TYPE value);

	/**
	 * Set the value displayed on the entry component to the default value.
	 */
	public void setToDefaultValue()
	{
		setToValueAndShowValidity(_entry.getDefaultValue());
	}

	/**
	 * Set the value displayed on the entry component to the initial value.
	 */
	public void setToInitialValue()
	{
		setToValueAndShowValidity(_initValue);
	}

	// public abstract void saveToConfigurator();

	/**
	 * Function used to create the appropriate {@link EntryComponent} for the
	 * {@link IConfigurationLeaf} given in argument.
	 * 
	 * @param leaf
	 *            the {@link IConfigurationLeaf} to display.
	 * @return the newly created {@link EntryComponent}.
	 * 
	 */
	public static EntryComponent<?, ?, ?> createEntryComponent(
			final IConfigurationLeaf<?, ?> leaf)
	{
		if (leaf instanceof ConfigurationInteger)
		{
			return new IntegerEntryComponent((ConfigurationInteger) leaf);
		}
		else if (leaf instanceof ConfigurationLong)
		{
			return new LongEntryComponent((ConfigurationLong) leaf);
		}
		else if (leaf instanceof ConfigurationDouble)
		{
			return new DoubleEntryComponent((ConfigurationDouble) leaf);
		}
		else if (leaf instanceof ConfigurationFloat)
		{
			return new FloatEntryComponent((ConfigurationFloat) leaf);
		}
		else if (leaf instanceof ConfigurationString)
		{
			return new StringEntryComponent((ConfigurationString) leaf);
		}
		else if (leaf instanceof ConfigurationBoolean)
		{
			return new BooleanEntryComponent((ConfigurationBoolean) leaf);
		}
		// TODO code for the enum component

		// else if (leaf instanceof ConfigurationEnum)
		// {
		// return new EnumEntryComponent((ConfigurationEnum) leaf);
		// }
		else
		{
			return null;
		}
	}

	/**
	 * {@link ActionListener} used to update the state of the valid check box
	 * when the interface value has been changed.
	 * 
	 * @author benobiwan
	 * 
	 */
	protected final class ValidateActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(final ActionEvent e)
		{
			validateAndShowValidity();
		}
	}

	/**
	 * {@link ChangeListener} used to update the state of the valid check box
	 * when the interface value has been changed.
	 * 
	 * @author benobiwan
	 * 
	 */
	protected final class ValidateChangeListener implements ChangeListener
	{
		@Override
		public void stateChanged(final ChangeEvent e)
		{
			validateAndShowValidity();
		}
	}

	/**
	 * {@link FocusListener} used to update the state of the valid check box
	 * when the interface value has been changed.
	 * 
	 * @author benobiwan
	 * 
	 */
	protected final class ValidateFocusListener implements FocusListener
	{
		@Override
		public void focusGained(final FocusEvent e)
		{
			validateAndShowValidity();
		}

		@Override
		public void focusLost(final FocusEvent e)
		{
			validateAndShowValidity();
		}
	}
}
