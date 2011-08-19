package common.config.ui;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import common.config.InvalidConfigurationException;
import common.config.display.IntegerDisplayType;
import common.config.leaf.ConfigurationInteger;

/**
 * Object used to display a {@Link ConfigurationInteger} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 */
public class IntegerEntryComponent extends
		NumberEntryComponent<Integer, IntegerDisplayType, ConfigurationInteger>
{
	/**
	 * Creates a new IntegerEntryComponnent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	public IntegerEntryComponent(final ConfigurationInteger entry)
	{
		super(entry);
	}

	@Override
	protected void setToValueAndShowValidity(final Integer value)
	{
		switch (_dispType)
		{
		case SLIDER:
			((JSlider) _entryComponent).setValue(value.intValue());
			break;
		case SPINNER:
			((JSpinner) _entryComponent).setValue(value);
			break;
		case TEXTFIELD:
			((JTextField) _entryComponent).setText(value.toString());
			break;
		}
		validateAndShowValidity();
	}

	@Override
	protected void generateComponent()
	{
		int min, max, initValue;
		if (_entry.getMinValue() != null)
		{
			min = _entry.getMinValue().intValue();
		}
		else
		{
			min = Integer.MIN_VALUE;
		}
		if (_entry.getMaxValue() != null)
		{
			max = _entry.getMaxValue().intValue();
		}
		else
		{
			max = Integer.MAX_VALUE;
		}
		if (_entry.getCurrentValue() != null)
		{
			initValue = _entry.getCurrentValue().intValue();
		}
		else
		{
			initValue = 0;
		}
		final String strToolTip = "Min : " + min + " Max : " + max;
		switch (_dispType)
		{
		case SLIDER:
			_entryComponent = new JSlider(min, max, initValue);
			((JSlider) _entryComponent)
					.addChangeListener(new ValidateChangeListener());
			_entryComponent.setToolTipText(strToolTip);
			break;
		case SPINNER:
			final SpinnerNumberModel spinnerModel = new SpinnerNumberModel(
					initValue, min, max, 1);
			_entryComponent = new JSpinner(spinnerModel);
			spinnerModel.addChangeListener(new ValidateChangeListener());
			_entryComponent.setToolTipText(strToolTip);
			break;
		case TEXTFIELD:
			_entryComponent = new JTextField(Integer.toString(initValue));
			_entryComponent.setToolTipText(strToolTip);
			((JTextField) _entryComponent)
					.addFocusListener(new ValidateFocusListener());
			break;
		}
	}

	@Override
	protected Integer getDisplayedValue() throws InvalidConfigurationException
	{
		Integer value;
		switch (_dispType)
		{
		case SLIDER:
			value = Integer.valueOf(((JSlider) _entryComponent).getValue());
			break;
		case SPINNER:
			value = ((Integer) ((JSpinner) _entryComponent).getModel()
					.getValue());
			break;
		case TEXTFIELD:
			try
			{
				value = Integer.valueOf(((JTextField) _entryComponent)
						.getText());
			}
			catch (final NumberFormatException ex)
			{
				throw new InvalidConfigurationException(ex);
			}
			break;
		default:
			throw new InvalidConfigurationException();
		}
		return value;
	}
}
