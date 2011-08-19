package common.config.swing;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import common.config.InvalidConfigurationException;
import common.config.display.BooleanDisplayType;
import common.config.leaf.ConfigurationBoolean;

/**
 * Object used to display a {@Link ConfigurationBoolean} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 */
public class BooleanEntryComponent extends
		EntryComponent<Boolean, BooleanDisplayType, ConfigurationBoolean>
{
	/**
	 * Creates a new BooleanEntryComponent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	public BooleanEntryComponent(final ConfigurationBoolean entry)
	{
		super(entry);
	}

	@Override
	protected void setToValueAndShowValidity(final Boolean value)
	{
		switch (_dispType)
		{
		case RADIOBUTTON:
			((JRadioButton) _entryComponent).setSelected(value.booleanValue());
			break;
		case CHECKBOX:
			((JCheckBox) _entryComponent).setSelected(value.booleanValue());
			break;
		}
		validateAndShowValidity();
	}

	@Override
	protected void generateComponent()
	{
		switch (_dispType)
		{
		case RADIOBUTTON:
			_entryComponent = new JRadioButton();
			((JRadioButton) _entryComponent).setSelected(_initValue
					.booleanValue());
			((JRadioButton) _entryComponent)
					.addActionListener(new ValidateActionListener());
			break;
		case CHECKBOX:
			_entryComponent = new JCheckBox();
			((JCheckBox) _entryComponent)
					.setSelected(_initValue.booleanValue());
			((JCheckBox) _entryComponent)
					.addActionListener(new ValidateActionListener());
			break;
		}
	}

	@Override
	protected Boolean getDisplayedValue() throws InvalidConfigurationException
	{
		Boolean value;
		switch (_dispType)
		{
		case RADIOBUTTON:
			value = Boolean.valueOf(((JRadioButton) _entryComponent)
					.isSelected());
			break;
		case CHECKBOX:
			value = Boolean.valueOf(((JCheckBox) _entryComponent).isSelected());
			break;
		default:
			throw new InvalidConfigurationException();
		}
		return value;
	}
}
